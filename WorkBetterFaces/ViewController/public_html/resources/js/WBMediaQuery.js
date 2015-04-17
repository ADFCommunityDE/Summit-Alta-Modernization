/**Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.**/
/**
 *  JavaScript that sets up media query for a container inside a page. 
 *  To make the media query work, the following are needed on the page
 *  
 *  1. And ADF component that generates a div/table, for e.g. PGL. 
 *  2. Client Attribute for the component that reflects the EL bound property that we are trying to flip through MQ. 
 *     For e.g. :
 *     <af:panelGroupLayout id="pgltlcon" styleClass="WBViewPersonContainerMargin" clientComponent="true"
                             valign="top"
                             layout="#{pageFlowScope.vpLayoutMode == 'portrait' ? 'horizontal' : 'vertical'}">
        <af:clientAttribute name="vpLayoutMode" value="#{pageFlowScope.vpLayoutMode}"/>
 *     
 *  3. Include this js as follows: <af:resource type="javascript" source="resources/js/WBMediaQuery.js"/>
 *  4. 2 hidden buttons that will change the EL on the server for the media query for e.g.
 *     <!-- Hidden buttons used to change the orientation of the page -->
         
        <af:button visible="false" id="btnLayoutPortrait" partialSubmit="true">
            <af:setActionListener from="portrait" to="#{pageFlowScope.vpLayoutMode}"/>
        </af:button>
         
        <af:button visible="false" id="btnLayoutLandscape" partialSubmit="true">
            <af:setActionListener from="landscape" to="#{pageFlowScope.vpLayoutMode}"/>
        </af:button>
 *  5. Make a call to this JS to set the the media query as follows:
 *  
 *      <!-- invoke the method to establish media query -->
        <af:resource type="javascript">wbMQ.setupMediaQuery('(min-width: 1024px)', 'pgltlcon', 'vpLayoutMode', 'portrait', 'btnLayoutLandscape', 'btnLayoutPortrait');</af:resource>
 */
(function (wbMQ) {

  /**
   *  Setup a unique Media Query for an ADF component
   *  
   *  @param mediaQueryString {String}  The string used to setup the media query for e.g. 
   *                                    (min-width: 1024px), i.e landscape mode in a tablet
   *  @param mqRootId {String}          Id of the ADF component for which we are trying to setup the media query. 
   *                                    This id must be unque in order for the MQ+Component to be unique
   *  @param mqLayoutProp {String}      The property (client property and pushed into server EL) that is being change 
   *                                    based on media query
   *  @param initialMatchValue {String} Initial value of the parameter that will trigger a match FAIL, 
   *                                    for e.g. when the component is loaded and if the screen is in portrait mode, 
   *                                    it will trigger an match FAIL
   *  @param matchBtnId {String}        Id of the ADF component button to click on a match
   *  @param unmatchBtnId {String}      Id of the ADF component button to click on an umatch
   */
  wbMQ.setupMediaQuery = function(mediaQueryString, mqRootId, mqLayoutProp, initialMatchValue, matchBtnId, unmatchBtnId)
  {
    if(AdfPage.PAGE.isSynchronizedWithServer())
    {
      
      if (window.matchMedia) // supported only on modern browsers
      {
        // look for the component
        var contentContainerDOM = document.querySelector('*[id$=' +mqRootId +']');        
        var componentId = contentContainerDOM.id;
        var idPrefix = componentId.substring(0, componentId.indexOf(mqRootId));        
        
        // creat a unique combination of media query component using literal objects
        var compMQs = wbMQ.mqRootId;
        
        if (!compMQs)
        {
          compMQs = wbMQ.mqRootId = {};
        }
        
        compMQs[mediaQueryString] = {'mqRootId': mqRootId, 'idPrefix': idPrefix, 'matchBtnId': matchBtnId, 'unmatchBtnId':unmatchBtnId};
        
        // Need to setup media query only once
        if(!compMQs[mediaQueryString].mqList)
        {
          var mqList = window.matchMedia(mediaQueryString); 
          compMQs[mediaQueryString].mqList = mqList;
          // put a back reference to the component and the media query that is being registered
          mqList.compMQ = compMQs[mediaQueryString];
          mqList.addListener(mediaQueryListener);
        }
        
        var contentContainer = AdfPage.PAGE.findComponent(componentId);
        
        // There is some kind of bug in the framework. Even though we have synchronized with server, sometimes the comp is null
        // intially. So use a function reference to either call inline or call asynchronously after 100 ms timeout
        var func = function ()
        {
          if (!contentContainer)
          {
            contentContainer = AdfPage.PAGE.findComponent(componentId);
          }
          
          var currentLayout = contentContainer.getProperty(mqLayoutProp);
          // initial check
          if ((currentLayout == initialMatchValue || !currentLayout) && !compMQs[mediaQueryString].mqList.matches)
          {
            changeLayout(false, contentContainer, compMQs[mediaQueryString])
          }
        }
        
        if (contentContainer)
        {
          func();
        }
        else
        {
           window.setTimeout(func, 100);
        }
      }
    }
    else
    {
      window.setTimeout(function(){wbMQ.setupMediaQuery(mediaQueryString, mqRootId, mqLayoutProp, initialMatchValue, matchBtnId, unmatchBtnId)}, 100);
    }
  }
  
  function mediaQueryListener(mediaQueryList)
  {
    var compMQ = mediaQueryList.compMQ;
    
    // Chrome has changed this api. Instead of firing the listener with the MediaQueryList, it now wraps it with an
    // event, whose target is the mediaQueryList
    if (!compMQ) 
    {
      compMQ = mediaQueryList.target.compMQ;
    }
    
    var contentContainer = AdfPage.PAGE.findComponent(compMQ.idPrefix + compMQ.mqRootId);
    
    if (contentContainer)
    {
      changeLayout(mediaQueryList.matches, contentContainer, compMQ);
    }
  }
  
  function changeLayout(matches, contentContainer, compMQ)
  {
    var button = AdfPage.PAGE.findComponent(compMQ.idPrefix + (matches?compMQ.matchBtnId:compMQ.unmatchBtnId));
    
    // This should push the correct layout into the pageFlowScope
    AdfActionEvent.queue(button, true);
    
    // Now PPR the container with the correct layout
    AdfPage.PAGE.addPartialTargets(contentContainer);
  }
  
})(window.wbMQ = window.wbMQ || {}); // establish the mediaQuery namespace and execute immediately
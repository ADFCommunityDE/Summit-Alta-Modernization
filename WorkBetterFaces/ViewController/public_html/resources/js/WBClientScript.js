/*Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.*/
/**
 * This JavaScript provides client side scripting used by the Workbetter
 * demonstration application
 * We establish a WBClient namespace for all these functions
 */
var WBClient = {
    /**
     * Core function for taking a client (browser) mouse click or finger tap and sending 
     * that back to the server as a custom event that can be handled in Java. 
     * This allows you to attach "action" style events to components that do not directly
     * support actions or actionListeners
     * Expects the following parameters whch can be supplied as clientAttributes:
     * 1. serverEventName (optional) - name to attach to the event. Default: "clientClickProxyEvent"
     * 2. payload (optional) - value to pass back to the server via the click.  This will often be something 
     *                         like a row key value. The key for the payload in the event map is "payload". Default: null
     * 3. listenerComponentId (optional) - Full clientId of the component that has the handling <af:serverListener> 
     *                                     attached. Defaults to the component which is the source of this event 
     *                                     (e.g. the component with the <af:clientListener> attached
     */
    clientClickProxy : function(clickEvent){
        var eventToRaiseName = "clientClickProxyEvent";
        var eventPayload = "";
        var eventListener = clickEvent.getSource();
        var targetError = false;
        
        //Check for optional configuration arguments and resolve
        var checkTarget = eventListener.getProperty("listenerComponentId");
        var checkPayload = eventListener.getProperty("payload");
        var checkEventName = eventListener.getProperty("serverEventName");
        
        if (checkPayload){
            eventPayload = checkPayload;
        }
        if (checkEventName) {
            eventToRaiseName = checkEventName;
        }
        if (checkTarget){
           eventListener = AdfPage.PAGE.findComponentByAbsoluteId(checkTarget);
           if (!eventListener){
               targetError = true;
               AdfLogger.LOGGER.severe("WBClient: Unable to identifiy target component " + checkTarget);
           }
        }
        
        
        //Raise the custom event if the target is valid
        if (!targetError){
            AdfLogger.LOGGER.info("WBClient: Dispatching custom event with name: " + eventToRaiseName + " to " + eventListener.getClientId + ", payload: " + eventPayload);
            var serverEvent = new AdfCustomEvent(eventListener, eventToRaiseName, 
            {
                payload : eventPayload
            }, true);
            serverEvent.queue(true);   
        }
    },
    /**
     * Function that queues a client side action event for the 
     * Specified component (usually a button) 
     * Expects the following parameter:
     * 1. cmdId (Required) - the full clientId of the command component
     *                          that will receive the event. This is usually
     *                          by calling getClientId() on the component.
     */    
    clientButtonQueueAction : function (cmdId){
    var targetCmd = AdfPage.PAGE.findComponentByAbsoluteId(cmdId);
    if (targetCmd){
        AdfActionEvent.queue(targetCmd, true);
    }
    else {
        AdfLogger.LOGGER.severe("WBClient: Unable to identifiy target command component to invoke " + cmdId);
    }
        
    }
}
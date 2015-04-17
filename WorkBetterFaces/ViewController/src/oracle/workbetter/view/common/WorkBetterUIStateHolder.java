//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.view.common;

import oracle.adf.controller.ControllerContext;
import oracle.adf.view.rich.context.AdfFacesContext;

/**
 * Superclass for ADF PageFlowScope beans that need to be HA safe
 * This will really only have an effect if the adf-scope-ha-support flag is 
 * set in adf-config.xml
 */
public abstract class WorkBetterUIStateHolder {
    
    /**
     * Method which will mark the pageFlowScope as dirty when called
     * When running in High Availability mode, this will ensure that the 
     * pageFlowScope will be propagated accross the cluster
     */
    protected void markScopeChanged(){
        ControllerContext.getInstance().markScopeDirty(AdfFacesContext.getCurrentInstance().getPageFlowScope());
    }

}

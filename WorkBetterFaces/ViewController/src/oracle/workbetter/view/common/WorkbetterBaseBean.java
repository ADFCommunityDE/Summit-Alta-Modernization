//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.view.common;

import javax.faces.component.UIComponent;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.event.PhaseId;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;

import org.apache.myfaces.trinidad.component.UIXCommand;
import org.apache.myfaces.trinidad.component.UIXComponent;

/**
 * Holds common code for Backing Bean classes to share
 */
public abstract class WorkbetterBaseBean {
    protected static boolean queueActionOnCommandComponmentById(String buttonId) {
        if (buttonId != null && buttonId.length() > 0) {
            final String candidateId = buttonId;
            FacesContext ctx = FacesContext.getCurrentInstance();
            VisitContext visitContext = VisitContext.createVisitContext(ctx);
            return UIXComponent.visitTree(visitContext, ctx.getViewRoot(), new VisitCallback() {
                public VisitResult visit(VisitContext context, UIComponent component) {
                    try {
                        if (component instanceof UIXCommand && component.getId().equals(candidateId)) {
                            ActionEvent commandActionEvent = new ActionEvent(component);
                            commandActionEvent.setPhaseId(PhaseId.INVOKE_APPLICATION);
                            commandActionEvent.queue();
                            return VisitResult.COMPLETE;
                        }
                        return VisitResult.ACCEPT;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return VisitResult.COMPLETE;
                    }
                }
            });
        }
        return false;
    }
    
    protected static void refreshFilterAndResults(String filterName, String iteratorName){
        BindingContext bc = BindingContext.getCurrent();
        DCBindingContainer dcb = (DCBindingContainer) bc.getCurrentBindingsEntry();
        dcb.getOperationBinding(filterName).execute();
        DCIteratorBinding iter = dcb.findIteratorBinding(iteratorName);
        iter.executeQuery();
    }


}

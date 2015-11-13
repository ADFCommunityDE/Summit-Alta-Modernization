package de.adfcommunity.altaui.view;

import de.adfcommunity.altaui.view.utils.JSFUtils;

import java.io.Serializable;

import javax.faces.component.UIComponent;

import oracle.adf.controller.TaskFlowId;
import oracle.adf.view.rich.context.AdfFacesContext;

public class PageBean
    implements Serializable {

    private String taskFlowId = "/WEB-INF/dashboard.xml#dashboard";

    public PageBean() {}

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }

    public String dashboard() {
        setDynamicTaskFlowId("/WEB-INF/dashboard.xml#dashboard");
        triggerDeck();
        return null;
    }

    public String summitmanagement() {
        setDynamicTaskFlowId("/WEB-INF/summit-management.xml#summit-management");
        triggerDeck();
        return null;
    }

    public String inventorycontrol() {
        setDynamicTaskFlowId("/WEB-INF/inventory-control.xml#inventory-control");
        triggerDeck();
        return null;
    }

    public String getTaskFlowId() {
        return taskFlowId;
    }
    
    private void triggerDeck(){
        // #{CustomerNavigation.deck}
        UIComponent deck = (UIComponent)JSFUtils.resolveExpression("#{CustomerNavigation.deck}");
        
        AdfFacesContext.getCurrentInstance().addPartialTarget(deck);
        
    }
}

package de.adfcommunity.altaui.view;

import java.io.Serializable;

import oracle.adf.controller.TaskFlowId;

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
        return null;
    }

    public String summitmanagement() {
        setDynamicTaskFlowId("/WEB-INF/summit-management.xml#summit-management");
        return null;
    }

    public String inventorycontrol() {
        setDynamicTaskFlowId("/WEB-INF/inventory-control.xml#inventory-control");
        return null;
    }
}

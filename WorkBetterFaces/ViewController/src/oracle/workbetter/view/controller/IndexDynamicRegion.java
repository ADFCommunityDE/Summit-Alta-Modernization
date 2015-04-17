//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.view.controller;

import java.io.Serializable;

import oracle.adf.controller.TaskFlowId;
/**
 * This class manages the dynamic region on the index page
 * It provides the memory of which task flow is currently selected within the 
 * region and the methods to switch that value
 */
public class IndexDynamicRegion implements Serializable {
    @SuppressWarnings("compatibility:-5329817642937831563")
    private static final long serialVersionUID = -4633485426455218156L;
    private static final String DASHBOARD_TASKFLOW = "/WEB-INF/view/dashboard/dashboard.xml#dashboard";
    private static final String ORGANIZATION_TASKFLOW = "/WEB-INF/view/organizations/organizations.xml#organizations";
    private static final String PEOPLE_TASKFLOW = "/WEB-INF/view/people/people.xml#people";
    private String taskFlowId = DASHBOARD_TASKFLOW;

    public IndexDynamicRegion() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }

    public String dashboard() {
        setDynamicTaskFlowId(DASHBOARD_TASKFLOW);
        return null;
    }

    public String organizations() {
        setDynamicTaskFlowId(ORGANIZATION_TASKFLOW);
        return null;
    }

    public String people() {
        setDynamicTaskFlowId(PEOPLE_TASKFLOW);
        return null;
    }
}

//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.view.dashboard;

import java.io.Serializable;

import oracle.workbetter.view.common.WorkBetterUIStateHolder;

/**
 * Holds state for the dashboard flow
 */
public class DashboardFlowState extends WorkBetterUIStateHolder implements Serializable {
    @SuppressWarnings("compatibility:1370334523072190198")
    private static final long serialVersionUID = -8391369905787844810L;


    private int _drillOrgId;

    public void setDrillOrgId(int _dillOrgId) {
        this._drillOrgId = _dillOrgId;
        markScopeChanged();
    }

    public int getDrillOrgId() {
        return _drillOrgId;
    }


}

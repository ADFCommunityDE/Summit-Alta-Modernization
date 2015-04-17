//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.view.people;

import java.io.Serializable;

import oracle.workbetter.view.common.WorkBetterUIStateHolder;

/**
 * This bean is used to store any persisitent state used within the People
 * task flow providing a task flow scoped "UIManager"
 */
public class PeopleFlowState extends WorkBetterUIStateHolder implements Serializable {
    @SuppressWarnings("compatibility:-3203265047838731727")
    private static final long serialVersionUID = 2958201727290755679L;

    private enum CallOrigin {DASHBOARD,ORGANIZATION,UNSPECIFIED};
    
    //State holders for the flow input params
    private CallOrigin _calledFrom = CallOrigin.UNSPECIFIED;
    private int _selectedTile = 0;
    private String _rowKeyId;
    private String _origin;
    private int _drillOrgId;

    /* Accessors */
    public void setCalledFromDashboard(boolean calledFromDashboard) {
        if (calledFromDashboard){
            _calledFrom=CallOrigin.DASHBOARD;
            markScopeChanged();
        }
    }

    public boolean isCalledFromDashboard() {
        return (_calledFrom == CallOrigin.DASHBOARD);
    }
    
    public void setCalledFromOrganization(boolean calledFromOrganization) {
        if (calledFromOrganization){
            _calledFrom=CallOrigin.ORGANIZATION;
            markScopeChanged();
        }
    }

    public boolean isCalledFromOrganization() {
        return (_calledFrom == CallOrigin.ORGANIZATION);
    }

    public boolean isCalledFromUnspecified() {
        return (_calledFrom == CallOrigin.UNSPECIFIED);
    }

    public void setSelectedTile(int selectedTile) {
        this._selectedTile = selectedTile;
        markScopeChanged();
    }

    public int getSelectedTile() {
        return _selectedTile;
    }

    public void setRowKeyId(String rowKeyId) {
        this._rowKeyId = rowKeyId;
        markScopeChanged();
    }

    public String getRowKeyId() {
        return _rowKeyId;
    }


    public void setOrigin(String origin) {
        this._origin = origin;
        markScopeChanged();
    }

    public String getOrigin() {
        return _origin;
    }
    
    public void setDrillOrgId(int _drillOrgId) {
        this._drillOrgId = _drillOrgId;
        markScopeChanged();
    }

    public int getDrillOrgId() {
        return _drillOrgId;
    }
    
    /* Convenience Functions */
    /**
     * Generates the breadcrumb link at the top of the page based 
     * on where this flow was called from
     * @return
     */
    public String getBackLinkText() {
        String label;
        switch (_calledFrom) {
        case DASHBOARD:
            label =  "Dashboard";
            break;
        case ORGANIZATION:
            label =  "Organization";
            break;
        default:
            label = "Person List";
        }
        return label;
    }
}

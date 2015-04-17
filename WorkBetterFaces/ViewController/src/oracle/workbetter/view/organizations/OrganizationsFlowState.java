//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.view.organizations;

import java.io.Serializable;

import oracle.workbetter.view.common.WorkBetterUIStateHolder;

/**
 * Class to hold the persistent state for the Organizations flow
 */
public class OrganizationsFlowState extends WorkBetterUIStateHolder implements Serializable {
    @SuppressWarnings("compatibility:7912862141607292124")
    private static final long serialVersionUID = 2995398577490831074L;


    private String _rowKeyId;
    private String _origin;
    private int _selectedTile = 0;
    private String _summaryView;
    private int _drillPersonId;

    /* Accessors */
    public void setRowKeyId(String _rowKeyId) {
        this._rowKeyId = _rowKeyId;
        markScopeChanged();
    }

    public String getRowKeyId() {
        return _rowKeyId;
    }

    public void setOrigin(String _origin) {
        this._origin = _origin;
        markScopeChanged();
    }

    public String getOrigin() {
        return _origin;
    }

    public void setSelectedTile(int _selectedTile) {
        this._selectedTile = _selectedTile;
        markScopeChanged();
    }

    public int getSelectedTile() {
        return _selectedTile;
    }

    public void setSummaryView(String _summaryView) {
        this._summaryView = _summaryView;
        markScopeChanged();
    }

    public String getSummaryView() {
        return _summaryView;
    }
    
    public void setDrillPersonId(int _drillPersonId) {
        this._drillPersonId = _drillPersonId;
        markScopeChanged();
    }

    public int getDrillPersonId() {
        return _drillPersonId;
    }
    
    /* Convenience Functions */
    /**
     * Generates the breadcrumb link at the top of the page based 
     * on where this flow was called from
     * @return
     */
    public String getBackLinkText() {
        String label = "Organization List";
        if (_origin != null && _origin.length()>0) {
            label = _origin;
        }
        return label;
    }

}

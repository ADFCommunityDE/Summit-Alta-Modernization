//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.view.dashboard.backing;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import oracle.adf.model.bean.DCDataRow;
import oracle.adf.view.faces.bi.component.chart.UIHorizontalBarChart;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;

import oracle.workbetter.model.CompItem;
import oracle.workbetter.view.dashboard.DashboardFlowState;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class DashboardBean {
    private DashboardFlowState _dfState;

    public void setDfState(DashboardFlowState _dfState) {
        this._dfState = _dfState;
    }

    public DashboardFlowState getDfState() {
        return _dfState;
    }

    // Selection listener for the average performance chart on the dashboard page
    public void performanceChartSelectionListener(SelectionEvent selectionEvent) {
        // Navigate to the selected organization in the View Organization page, go to Performance tab
        navigateToSelectedOrg(selectionEvent.getSource(), "OrgPerformance");
    }
    
    // Selection listener for the average compensation chart on the dashboard page
    public void compensationChartSelectionListener(SelectionEvent selectionEvent) {
        // Navigate to the selected organization in the View Organization page, go to Compensation tab
        navigateToSelectedOrg(selectionEvent.getSource(), "OrgCompensation");
    }
        
        
    private void navigateToSelectedOrg(Object eventSource, String action) {
        if (eventSource != null) {
            UIHorizontalBarChart uiChart = (UIHorizontalBarChart)eventSource;
            RowKeySet selectedRowKeys = uiChart.getSelectedRowKeys();
            if (selectedRowKeys != null && selectedRowKeys.size() > 0) {
            
                for (Object rowKey : selectedRowKeys) {
                    DCDataRow chartData = (DCDataRow)uiChart.getRowData(rowKey);
                    CompItem selectedItem = (CompItem)chartData.getDataProvider();
              
                    // Push the current orgainization id into the pageflow scope
                    getDfState().setDrillOrgId(selectedItem.getId());
                  
                    // Programatically trigger the OrgPerformance action
                    _doNavigationAction(uiChart, action);
                        
                    return;
                }
            }
        }
    }
    
    
    private void _doNavigationAction(UIComponent comp, String action)
    {
        // walkup to find the containing region
        while(!(comp instanceof RichRegion)){
            comp = comp.getParent();
        }
      
        RichRegion rr = ((RichRegion) comp);        
        rr.queueActionEventInRegion(   
        _createMethodExpressionFromString(action),
        null, null, false, 0, 0,PhaseId.INVOKE_APPLICATION);                
    }
    
    private MethodExpression _createMethodExpressionFromString(String expr){
        FacesContext fctx = FacesContext.getCurrentInstance();
        ELContext elctx = fctx.getELContext();
        ExpressionFactory exprFactory = fctx.getApplication().getExpressionFactory();
        MethodExpression methodExpr = exprFactory.createMethodExpression( 
                     elctx,               
                     expr,
                     null, 
                     new Class[]{});  
      
        return methodExpr;
    }

}

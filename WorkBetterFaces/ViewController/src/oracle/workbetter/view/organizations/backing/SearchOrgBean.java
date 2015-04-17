//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.view.organizations.backing;


import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.workbetter.view.common.WorkbetterBaseBean;

public class SearchOrgBean extends WorkbetterBaseBean {
    private static ADFLogger _logger = ADFLogger.createADFLogger(SearchOrgBean.class);
    private static final String HIDDEN_NAV_BUTTON = "h_navb1";

    public void doSearchNRefresh(ActionEvent actionEvent) {
        refreshFilterAndResults("filterDepartments", "departmentsIterator");
    }

    public void doViewOrg(ClientEvent clientEvent) {
        if (!queueActionOnCommandComponmentById(HIDDEN_NAV_BUTTON)) {
            _logger.severe("Error: unable to locate hidden havigation component " + HIDDEN_NAV_BUTTON);
        }
    }
}

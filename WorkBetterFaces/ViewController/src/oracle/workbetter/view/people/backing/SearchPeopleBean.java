//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.view.people.backing;

import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.workbetter.view.common.WorkbetterBaseBean;

/**
 * Event handler for actions on the SearchPeople page
 */
public class SearchPeopleBean extends WorkbetterBaseBean {
    private static ADFLogger _logger = ADFLogger.createADFLogger(SearchPeopleBean.class);
    private static final String HIDDEN_NAV_BUTTON = "h_navb2";


    public void doSearchNRefresh(ActionEvent actionEvent) {
        refreshFilterAndResults("filterEmployees", "employeesIterator");
    }

    public void doViewPerson(ClientEvent clientEvent) {
        if (!queueActionOnCommandComponmentById(HIDDEN_NAV_BUTTON)) {
            _logger.severe("Error: unable to locate hidden havigation component " + HIDDEN_NAV_BUTTON);
        }
    }
}

package de.adfcommunity.altaui.view;

import javax.el.ELContext;

import javax.el.MethodExpression;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.view.rich.component.rich.layout.RichDeck;

import oracle.adf.view.rich.context.AdfFacesContext;

import org.apache.myfaces.trinidad.event.SelectionEvent;

public class CustomerNavigationBean {

    private RichDeck deck;

    public CustomerNavigationBean() {}

    public void selectCountry(SelectionEvent selectionEvent) {

        ELContext elcontext = FacesContext.getCurrentInstance().getELContext();
        MethodExpression methodExpression =
            FacesContext.getCurrentInstance().getApplication().getExpressionFactory()
            .createMethodExpression(elcontext, 
                                    "#{bindings.CountriesView.treeModel.makeCurrent}", 
                                    Object.class, 
                                    new Class[] { SelectionEvent.class });
        methodExpression.invoke(elcontext, new Object[] { selectionEvent });
        deck.setDisplayedChild("pgl2");
        AdfFacesContext.getCurrentInstance().addPartialTarget(deck);
    }

    public void setDeck(RichDeck deck) {
        this.deck = deck;
    }

    public RichDeck getDeck() {
        return deck;
    }

    public void backToCountry(ActionEvent actionEvent) {
        deck.setDisplayedChild("pgl1");
        AdfFacesContext.getCurrentInstance().addPartialTarget(deck);
    }
}

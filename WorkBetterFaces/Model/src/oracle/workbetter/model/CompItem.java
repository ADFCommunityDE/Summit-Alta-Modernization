//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.model;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class CompItem {
    private int id;
    private double itemValue;
    private String itemLabel;
    private int index;


    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public CompItem() {
        super();
    }

    public CompItem( int id, double itemValue, String itemLabel) {
        this.id = id;
        this.itemValue = itemValue;
        this.itemLabel = itemLabel;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setItemValue(double itemValue) {
        double oldItemValue = this.itemValue;
        this.itemValue = itemValue;
        propertyChangeSupport.firePropertyChange("itemValue", oldItemValue, itemValue);
    }

    public double getItemValue() {
        return itemValue;
    }

    public void setItemLabel(String itemLabel) {
        String oldItemLabel = this.itemLabel;
        this.itemLabel = itemLabel;
        propertyChangeSupport.firePropertyChange("itemLabel", oldItemLabel, itemLabel);
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public void setIndex(int index) {
        int oldIndex = this.index;
        this.index = index;
        propertyChangeSupport.firePropertyChange("index", oldIndex, index);
    }

    public int getIndex() {
        return index;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange("id", oldId, id);
    }

    public int getId() {
        return id;
    }

}

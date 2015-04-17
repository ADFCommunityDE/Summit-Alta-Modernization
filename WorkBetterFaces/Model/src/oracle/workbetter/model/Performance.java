//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.Date;


public class Performance {
    private int perfId;
    private int empId;
    private int rating;
    private int potential;
    private String empName;
    private Date effective;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Performance() {
    }
    
    public Performance( int perfId, int empId, int rating, int potential, Date effective, String empName) {
        this.perfId = perfId;
        this.empId = empId;
        this.rating = rating;
        this.potential = potential;
        this.effective = effective;
        this.empName = empName;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setPerfId(int perfId) {
        int oldPerfId = this.perfId;
        this.perfId = perfId;
        propertyChangeSupport.firePropertyChange("perfId", oldPerfId, perfId);
    }

    public int getPerfId() {
        return perfId;
    }

    public void setEmpId(int empId) {
        int oldEmpId = this.empId;
        this.empId = empId;
        propertyChangeSupport.firePropertyChange("empId", oldEmpId, empId);
    }

    public int getEmpId() {
        return empId;
    }

    public void setRating(int rating) {
        int oldRating = this.rating;
        this.rating = rating;
        propertyChangeSupport.firePropertyChange("rating", oldRating, rating);
    }

    public int getRating() {
        return rating;
    }

    public void setPotential(int potential) {
        int oldPotential = this.potential;
        this.potential = potential;
        propertyChangeSupport.firePropertyChange("potential", oldPotential, potential);
    }

    public int getPotential() {
        return potential;
    }

    public void setEffective(Date effective) {
        Date oldEffective = this.effective;
        this.effective = effective;
        propertyChangeSupport.firePropertyChange("effective", oldEffective, effective);
    }

    public Date getEffective() {
        return effective;
    }

    public void setEmpName(String empName) {
        String oldEmpName = this.empName;
        this.empName = empName;
        propertyChangeSupport.firePropertyChange("empName", oldEmpName, empName);
    }

    public String getEmpName() {
        return empName;
    }

    public String getNboxPotential() {
        return calcNboxString(potential);
    }

    public String getImage() {
        String image = "nopic.png";
        Integer i = new Integer(this.empId);
        if( i.intValue() < 188 ) {
            image = i.toString() + ".png";
        }
        return image;
    }
    
    public String getNboxRating() {
        return calcNboxString(rating);
    }

    private String calcNboxString( int value ) {
        String ret = "low";
        if( value == 3 || value == 4 ) {
            ret = "med";
        } else if( value == 5 ) {
            ret = "high";
        }
        return ret;
    }    

}

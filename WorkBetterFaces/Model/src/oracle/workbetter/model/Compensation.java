//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.model;

import java.util.Date;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Compensation {
    private int compId;
    private int empId;
    private int compRatio;
    private double salary;
    private double bonus;
    private double commission;
    private Date effective;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Compensation() {
    }

    public Compensation(int compId, int empId, int compRatio, double salary, double bonus, double commission, Date effective) {
        this.compId = compId;
        this.empId = empId;
        this.compRatio = compRatio;
        this.salary = salary;
        this.bonus = bonus;
        this.commission = commission;
        this.effective = effective;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setCompId(int compId) {
        int oldCompId = this.compId;
        this.compId = compId;
        propertyChangeSupport.firePropertyChange("compId", oldCompId, compId);
    }

    public int getCompId() {
        return compId;
    }

    public void setEmpId(int empId) {
        int oldEmpId = this.empId;
        this.empId = empId;
        propertyChangeSupport.firePropertyChange("empId", oldEmpId, empId);
    }

    public int getEmpId() {
        return empId;
    }

    public void setCompRatio(int compRatio) {
        int oldCompRatio = this.compRatio;
        this.compRatio = compRatio;
        propertyChangeSupport.firePropertyChange("compRatio", oldCompRatio, compRatio);
    }

    public int getCompRatio() {
        return compRatio;
    }

    public void setSalary(double salary) {
        double oldSalary = this.salary;
        this.salary = salary;
        propertyChangeSupport.firePropertyChange("salary", oldSalary, salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setBonus(double bonus) {
        double oldBonus = this.bonus;
        this.bonus = bonus;
        propertyChangeSupport.firePropertyChange("bonus", oldBonus, bonus);
    }

    public double getBonus() {
        return bonus;
    }

    public void setCommission(double commission) {
        double oldCommission = this.commission;
        this.commission = commission;
        propertyChangeSupport.firePropertyChange("commission", oldCommission, commission);
    }

    public double getCommission() {
        return commission;
    }

    public void setEffective(Date effective) {
        Date oldEffective = this.effective;
        this.effective = effective;
        propertyChangeSupport.firePropertyChange("effective", oldEffective, effective);
    }

    public Date getEffective() {
        return effective;
    }

}

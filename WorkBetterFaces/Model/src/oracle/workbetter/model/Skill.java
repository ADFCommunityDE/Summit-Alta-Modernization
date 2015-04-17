//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class Skill {
    private String skill;
    private int level;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Skill() {
    }
    
    public Skill(String skill, int level) {
        this.skill = skill;
        this.level = level;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setSkill(String skill) {
        String oldSkill = this.skill;
        this.skill = skill;
        propertyChangeSupport.firePropertyChange("skill", oldSkill, skill);
    }

    public String getSkill() {
        return skill;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    

}

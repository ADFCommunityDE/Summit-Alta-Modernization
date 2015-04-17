//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import java.util.Date;


public class Event {
    private int eventId;
    private int type;
    private String name;
    private String description;
    private Date start;
    private Date end;
    private String color;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Event() {
        super();
    }

    public Event(int eventId, int type, String description, Date start, Date end) {
        this.eventId = eventId;
        this.type = type;
        this.description = description;
        this.start = start;
        this.end = end;
        
        if (this.type == 1) {
            name = "Customer Meeting";
            color = "#267DB3";
        } else if (this.type == 2) {
            name = "Event"; 
            color = "#68C182";
        } else if (this.type == 3) {
            name = "Training";
            color = "#FAD55C";
        } else {
            name = "Time Off";
            color = "#8561C8";
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setEventId(int eventId) {
        int oldEventId = this.eventId;
        this.eventId = eventId;
        propertyChangeSupport.firePropertyChange("eventId", oldEventId, eventId);
    }

    public int getEventId() {
        return eventId;
    }

    public void setType(int type) {
        int oldType = this.type;
        this.type = type;
        propertyChangeSupport.firePropertyChange("type", oldType, type);
    }

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        String oldDescription = this.description;
        this.description = description;
        propertyChangeSupport.firePropertyChange("description", oldDescription, description);
    }

    public String getDescription() {
        return description;
    }

    public void setStart(Date start) {
        Date oldStart = this.start;
        this.start = start;
        propertyChangeSupport.firePropertyChange("start", oldStart, start);
    }

    public Date getStart() {
        return start;
    }

    public void setEnd(Date end) {
        Date oldEnd = this.end;
        this.end = end;
        propertyChangeSupport.firePropertyChange("end", oldEnd, end);
    }

    public Date getEnd() {
        return end;
    }
    
    public String getColor() {
        return color;
    }

}

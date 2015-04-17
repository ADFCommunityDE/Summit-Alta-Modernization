//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Dashboard {
    private static final long day = (long) (1000 * 60 * 60 * 24);
    private HRService hrs = null;
    private Employee profile = null;
    private List avgComp = new ArrayList();
    private List avgPerf = new ArrayList();
    private List attritionHistory = new ArrayList();

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Dashboard() {
        super();
    }

    public Dashboard(HRService hrs) {
        this.hrs = hrs;
        profile = hrs.getEmployees()[50];
        calcAverageComp();
        calcAveragePerf();
        initAttritionHistory();
    }

    @SuppressWarnings("unchecked")
    private void calcAverageComp() {
        Department[] depts = hrs.getDepartments();
        int count = depts.length;

        for (int x = 0; x < count; x++) {
            Department d = depts[x];
            CompItem c = new CompItem(d.getDeptId(), d.getAvgTotalComp(), d.getDeptName());
            if (avgComp.size() == 0) {
                avgComp.add(c);
            } else {
                boolean added = false;
                for (int y = 0; y < avgComp.size(); y++) {
                    CompItem ci = (CompItem) avgComp.get(y);
                    if (d.getAvgTotalComp() > ci.getItemValue()) {
                        avgComp.add(y, c);
                        added = true;
                        break;
                    }
                }
                if (added == false) {
                    avgComp.add(c);
                }
            }
        }

        while (avgComp.size() > 6) {
            avgComp.remove(avgComp.size() - 1);
        }
        for (int x = 0; x < avgComp.size(); x++) {
            CompItem ci = (CompItem) avgComp.get(x);
            ci.setIndex(x);
            avgComp.set(x, ci);
        }

    }

    @SuppressWarnings("unchecked")
    private void calcAveragePerf() {
        Department[] depts = hrs.getDepartments();
        int count = depts.length;

        for (int x = 0; x < count; x++) {
            Department d = depts[x];
            CompItem c = new CompItem(d.getDeptId(), d.getAvgRating(), d.getDeptName());
            if (avgPerf.size() == 0) {
                avgPerf.add(c);
            } else {
                boolean added = false;
                for (int y = 0; y < avgPerf.size(); y++) {
                    CompItem ci = (CompItem) avgPerf.get(y);
                    if (d.getAvgRating() > ci.getItemValue()) {
                        avgPerf.add(y, c);
                        added = true;
                        break;
                    }
                }
                if (added == false) {
                    avgPerf.add(c);
                }
            }
        }

        while (avgPerf.size() > 6) {
            avgPerf.remove(avgPerf.size() - 1);
        }
        for (int x = 0; x < avgPerf.size(); x++) {
            CompItem ci = (CompItem) avgPerf.get(x);
            ci.setIndex(x);
            avgPerf.set(x, ci);
        }

    }

    @SuppressWarnings("unchecked")
    public CompItem[] getAvgComps() {
        return (CompItem[]) avgComp.toArray(new CompItem[avgComp.size()]);
    }

    @SuppressWarnings("unchecked")
    public CompItem[] getAvgPerfs() {
        return (CompItem[]) avgPerf.toArray(new CompItem[avgPerf.size()]);
    }

    public Employee getProfile() {
        return profile;
    }

    public int getNotifyApproved() {
        return profile.getNotifyApproved();
    }

    public int getNotifyWaiting() {
        return profile.getNotifyWaiting();
    }

    public int getNotifyRejected() {
        return profile.getNotifyRejected();
    }

    public int getGroupSize() {
        return profile.getGroupSize();
    }

    public int getTeamSize() {
        return profile.getReportCount();
    }

    public double getGroupAvgRating() {
        return profile.getGroupAvgRating();
    }

    public double getGroupAvgPotential() {
        return profile.getGroupAvgPotential();
    }

    public int getGroupCompRatioAbove() {
        return profile.getGroupCompRatioAbove();
    }
    
    public int getGroupCompRatioIn() {
        return profile.getGroupCompRatioIn();
    }

    public int getGroupCompRatioBelow() {
        return profile.getGroupCompRatioBelow();
    }
    
    public int getGroupMeetings() {
        return profile.getGroupMeetings();
    }
    
    public int getGroupEvents() {
        return profile.getGroupEvents();
    }
    
    public int getGroupTimeoff() {
        return profile.getGroupTimeOff();
    }
    
    public int getGroupTrainings() {
        return profile.getGroupTrainings();
    }

    public int getEmpMeetings() {
        return profile.getEmpMeetings();
    }

    public int getEmpEvents() {
        return profile.getEmpEvents();
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    @SuppressWarnings("unchecked")
    public CompItem[] getAttritionHistory() {
        return (CompItem[]) attritionHistory.toArray(new CompItem[attritionHistory.size()]);
    }

    @SuppressWarnings("unchecked")
    private void initAttritionHistory() {
        
        CompItem ci = new CompItem(0, 2, "No Career Progression");
        ci.setIndex(0);
        attritionHistory.add(ci);
        
        ci = new CompItem(1, 4, "Salary");
        ci.setIndex(1);
        attritionHistory.add(ci);
        
        ci = new CompItem(2, 3, "Seeking New Skills");
        ci.setIndex(2);
        attritionHistory.add(ci);
        
        ci = new CompItem(3, 1, "Work Environment");
        ci.setIndex(3);
        attritionHistory.add(ci);
        
        ci = new CompItem(4, 3, "Personal/Family Reasons");
        ci.setIndex(4);
        attritionHistory.add(ci);
        
        ci = new CompItem(5, 2, "Not Fitting into a Team");
        ci.setIndex(5);
        attritionHistory.add(ci);
        
    }
    
}

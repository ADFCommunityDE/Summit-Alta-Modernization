//Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
package oracle.workbetter.model;


import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Random;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class Employee {
    private int empId;
    private String firstName;
    private String lastName;
    private String title;
    private String email;
    private String phone;
    private String mobile;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postal;
    private String twitter;
    private String facebook;
    private String google;
    private String linkedIn;
    private Date hireDate;
    private int compRatio;
    private double salary;
    private double bonus;
    private double commission;
    private int rating;
    private int potential;
    private int deptId;
    private String deptName;
    private int mgrId;
    private String mgrFirstName;
    private String mgrLastName;
    private double teamAvgRating;
    private boolean active = false;
    private int empMeetings = 0;
    private int empEvents = 0;
    private int notifyApproved = 3;
    private int notifyWaiting = 4;
    private int notifyRejected = 1;
    private int groupSize = 0;
    private double groupAvgRating = 0;
    private double groupAvgPotential = 0;
    private int groupCompRatioAbove = 0;
    private int groupCompRatioIn = 0;
    private int groupCompRatioBelow = 0;
    private int groupMeetings = 0;
    private int groupEvents = 0;
    private int groupTrainings = 0;
    private int groupTimeOff = 0;
    private List comps = new ArrayList();
    private List perfs = new ArrayList();
    private List<Skill> skills = new ArrayList<Skill>();
    private List piecomps = new ArrayList();
    protected List events = new ArrayList();
    private List colleaguePerfs = new ArrayList();
    private List reports = new ArrayList();
    private static String[] skillList = {
        "Bookeeping", "Corporate Tax", "Excel", "Word", "Statistics", "Javascript", "Java", "Analytics", "Testing",
        "Acquisitions", "Project Planning", "Risk Analysis", "Recruiting", "Management", "Financials", "CRM", "HCM",
        "Human Resources", "Engineering", "Outsourcing", "Procurement", "Strategy", "Estimation", "Staffing",
        "Budgeting"
    };
    private static String[][] eventlist = {
        { "Acme Ent", "Foo Ltd", "Bar Inc", "AAA Inc", "Oracle", "BBB Ltd", "CCC Enterprises", "ABC LLC", "DEF Inc",
          "XYZ Systems" },
        { "Trade Show", "Sales Convention", "Development Convention", "User Group Meetup", "Winner's Circle",
          "StockHolder's Meeting", "Design Awards", "Customer Advisory Board", "Business Meeting", "Feedback Session" },
        { "Mgr Essentials", "Sexual Harrassment", "Ethics", "Mobility", "Sales", "Java Development", "iOS Development",
          "Effective Mgmt", "Public Speaking", "Security" },
        { "Vacation", "Vacation", "Vacation", "Vacation", "Sick", "Sick", "Sick", "Sick", "Bereavement", "Bereavement" }
    };
    private static final long year = (long) (1000 * 60 * 60 * 24 * 365.25);
    private static final long day = (1000 * 60 * 60 * 24);

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public Employee() {
    }

    public Employee(int empId, String firstName, String lastName, String title, int deptId, String deptName,
                    String phone, String mobile, String email, String linkedIn, String twitter, String facebook,
                    String google, String address, String city, String state, String country, String postal, int rating,
                    int potential, int compRatio, double salary, double bonus, double commission, int mgrId,
                    Date hireDate, String mgrFirstName, String mgrLastName) {
        this.empId = empId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.deptId = deptId;
        this.deptName = deptName;
        this.phone = phone;
        this.mobile = mobile;
        this.email = email;
        this.linkedIn = linkedIn;
        this.twitter = twitter;
        this.facebook = facebook;
        this.google = google;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postal = postal;
        this.rating = rating;
        this.potential = potential;
        this.compRatio = compRatio;
        this.salary = salary * 10;
        this.bonus = bonus * 10;
        this.commission = commission * 10;
        this.mgrId = mgrId;
        this.hireDate = hireDate;
        this.mgrFirstName = mgrFirstName;
        this.mgrLastName = mgrLastName;
    }


    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setEmpId(int empId) {
        int oldEmpId = this.empId;
        this.empId = empId;
        propertyChangeSupport.firePropertyChange("empId", oldEmpId, empId);
    }

    public int getEmpId() {
        return empId;
    }

    public void setFirstName(String firstName) {
        String oldFirstName = this.firstName;
        this.firstName = firstName;
        propertyChangeSupport.firePropertyChange("firstName", oldFirstName, firstName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        String oldLastName = this.lastName;
        this.lastName = lastName;
        propertyChangeSupport.firePropertyChange("lastName", oldLastName, lastName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setTitle(String title) {
        String oldTitle = this.title;
        this.title = title;
        propertyChangeSupport.firePropertyChange("title", oldTitle, title);
    }

    public String getTitle() {
        return title;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        propertyChangeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getEmail() {
        return email.toLowerCase() + "@example.net";
    }

    public void setMobile(String mobile) {
        String oldMobile = this.mobile;
        this.mobile = mobile;
        propertyChangeSupport.firePropertyChange("mobile", oldMobile, mobile);
    }

    public String getMobile() {
        return mobile;
    }

    public void setPhone(String phone) {
        String oldPhone = this.phone;
        this.phone = phone;
        propertyChangeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getPhone() {
        return phone;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        propertyChangeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getAddress() {
        return address;
    }

    public void setCity(String city) {
        String oldCity = this.city;
        this.city = city;
        propertyChangeSupport.firePropertyChange("city", oldCity, city);
    }

    public String getCity() {
        return city;
    }

    public void setState(String state) {
        String oldState = this.state;
        this.state = state;
        propertyChangeSupport.firePropertyChange("state", oldState, state);
    }

    public String getState() {
        return state;
    }

    public void setCountry(String country) {
        String oldCountry = this.country;
        this.country = country;
        propertyChangeSupport.firePropertyChange("country", oldCountry, country);
    }

    public String getCountry() {
        return country;
    }

    public void setPostal(String postal) {
        String oldPostal = this.postal;
        this.postal = postal;
        propertyChangeSupport.firePropertyChange("postal", oldPostal, postal);
    }

    public String getPostal() {
        return postal;
    }

    public void setTwitter(String twitter) {
        String oldTwitter = this.twitter;
        this.twitter = twitter;
        propertyChangeSupport.firePropertyChange("twitter", oldTwitter, twitter);
    }

    public String getTwitter() {
        return twitter;
    }

    public void setFacebook(String facebook) {
        String oldFacebook = this.facebook;
        this.facebook = facebook;
        propertyChangeSupport.firePropertyChange("facebook", oldFacebook, facebook);
    }

    public String getFacebook() {
        return facebook;
    }

    public void setGoogle(String google) {
        String oldGoogle = this.google;
        this.google = google;
        propertyChangeSupport.firePropertyChange("google", oldGoogle, google);
    }

    public String getGoogle() {
        return google;
    }

    public void setLinkedIn(String linkedIn) {
        String oldLinkedIn = this.linkedIn;
        this.linkedIn = linkedIn;
        propertyChangeSupport.firePropertyChange("linkedIn", oldLinkedIn, linkedIn);
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setHireDate(Date hireDate) {
        Date oldHireDate = this.hireDate;
        this.hireDate = hireDate;
        propertyChangeSupport.firePropertyChange("hireDate", oldHireDate, hireDate);
    }

    public Date getHireDate() {
        return hireDate;
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

    public void setDeptId(int deptId) {
        int oldDeptId = this.deptId;
        this.deptId = deptId;
        propertyChangeSupport.firePropertyChange("deptId", oldDeptId, deptId);
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptName(String deptName) {
        String oldDeptName = this.deptName;
        this.deptName = deptName;
        propertyChangeSupport.firePropertyChange("deptName", oldDeptName, deptName);
    }

    public String getDeptName() {
        return deptName;
    }

    public void setMgrId(int mgrId) {
        int oldMgrId = this.mgrId;
        this.mgrId = mgrId;
        propertyChangeSupport.firePropertyChange("mgrId", oldMgrId, mgrId);
    }

    public int getMgrId() {
        return mgrId;
    }

    public void setMgrFirstName(String mgrFirstName) {
        String oldMgrFirstName = this.mgrFirstName;
        this.mgrFirstName = mgrFirstName;
        propertyChangeSupport.firePropertyChange("mgrFirstName", oldMgrFirstName, mgrFirstName);
    }

    public String getMgrFirstName() {
        return mgrFirstName;
    }

    public void setMgrLastName(String mgrLastName) {
        String oldMgrLastName = this.mgrLastName;
        this.mgrLastName = mgrLastName;
        propertyChangeSupport.firePropertyChange("mgrLastName", oldMgrLastName, mgrLastName);
    }

    public String getMgrLastName() {
        return mgrLastName;
    }

    public String getMgrImage() {
        return getEmpImage(this.mgrId);
    }

    public String getImage() {
        return getEmpImage(this.empId);
    }

    private String getEmpImage(int id) {
        String image = "nopic.png";
        Integer i = new Integer(id);
        if (i.intValue() < 188) {
            image = i.toString() + ".png";
        }
        return image;
    }

    public void setActive(boolean active) {
        boolean oldActive = this.active;
        this.active = active;
        propertyChangeSupport.firePropertyChange("active", oldActive, active);
    }

    public boolean isActive() {
        return active;
    }

    public int getTenure() {
        return (int) ((new Date().getTime() - getHireDate().getTime()) / year);
    }

    public String getNboxPotential() {
        return calcNboxString(potential);
    }

    public String getNboxRating() {
        return calcNboxString(rating);
    }


    public void setTeamAvgRating(double teamAvgRating) {
        double oldTeamAvgRating = this.teamAvgRating;
        this.teamAvgRating = teamAvgRating;
        propertyChangeSupport.firePropertyChange("teamAvgRating", oldTeamAvgRating, teamAvgRating);
    }

    public double getTeamAvgRating() {
        return teamAvgRating;
    }

    private String calcNboxString(int value) {
        String ret = "low";
        if (value == 3 || value == 4) {
            ret = "med";
        } else if (value == 5) {
            ret = "high";
        }
        return ret;
    }

    @SuppressWarnings("unchecked")
    public Compensation[] getCompHistory() {
        return (Compensation[]) comps.toArray(new Compensation[comps.size()]);
    }

    @SuppressWarnings("unchecked")
    public Performance[] getPerfHistory() {
        return (Performance[]) perfs.toArray(new Performance[perfs.size()]);
    }

    public Skill[] getSkills() {
        return skills.toArray(new Skill[skills.size()]);
    }

    @SuppressWarnings("unchecked")
    public Performance[] getColleagues() {
        return (Performance[]) colleaguePerfs.toArray(new Performance[colleaguePerfs.size()]);
    }

    @SuppressWarnings("unchecked")
    public Employee[] getReports() {
        return (Employee[]) reports.toArray(new Employee[reports.size()]);
    }

    public int getReportCount() {
        return reports.size();
    }

    @SuppressWarnings("unchecked")
    public CompItem[] getPieComps() {
        return (CompItem[]) piecomps.toArray(new CompItem[piecomps.size()]);
    }

    @SuppressWarnings("unchecked")
    public Event[] getEvents() {
        return (Event[]) events.toArray(new Event[events.size()]);
    }

    public void setEmpMeetings(int empMeetings) {
        int oldEmpMeetings = this.empMeetings;
        this.empMeetings = empMeetings;
        propertyChangeSupport.firePropertyChange("empMeetings", oldEmpMeetings, empMeetings);
    }

    public int getEmpMeetings() {
        return empMeetings;
    }

    public void setEmpEvents(int empEvents) {
        int oldEmpEvents = this.empEvents;
        this.empEvents = empEvents;
        propertyChangeSupport.firePropertyChange("empEvents", oldEmpEvents, empEvents);
    }

    public int getEmpEvents() {
        return empEvents;
    }

    public void setGroupSize(int groupSize) {
        int oldGroupSize = this.groupSize;
        this.groupSize = groupSize;
        propertyChangeSupport.firePropertyChange("groupSize", oldGroupSize, groupSize);
    }

    public int getGroupSize() {
        return groupSize;
    }


    public double getGroupAvgRating() {
        return groupAvgRating;
    }

    public double getGroupAvgPotential() {
        return groupAvgPotential;
    }

    public int getGroupCompRatioAbove() {
        return groupCompRatioAbove;
    }

    public int getGroupCompRatioIn() {
        return groupCompRatioIn;
    }

    public int getGroupCompRatioBelow() {
        return groupCompRatioBelow;
    }

    public int getGroupMeetings() {
        return groupMeetings;
    }

    public int getGroupEvents() {
        return groupEvents;
    }

    public int getGroupTrainings() {
        return groupTrainings;
    }

    public int getGroupTimeOff() {
        return groupTimeOff;
    }

    public int getNotifyApproved() {
        return notifyApproved;
    }

    public int getNotifyWaiting() {
        return notifyWaiting;
    }

    public int getNotifyRejected() {
        return notifyRejected;
    }

    // This method populates the child collections with a random amount of data
    @SuppressWarnings("unchecked")
    protected void createChildren(HRService hr) {
        int years = getTenure();

        Random ran = new Random();

        double newSalary = getSalary();
        double newBonus = getBonus();
        double newCommission = getCommission();

        int newRating = getRating(); 
        int newPotential = getPotential();

        for (int x = years; x > 0; x--) {
            if (x < years) {
                double sp = (double) (ran.nextInt(4) + 1) / 100 + 1 - 0.05; //between 101-105%
                double bp = (double) (ran.nextInt(9) + 1) / 100 + 1 - 0.10; //between 101-110%
                double cp = (double) (ran.nextInt(6) + 5) / 100 + 1 - 0.10; //between 105-110%

                newSalary = newSalary * sp;
                newBonus = newBonus * bp;
                newCommission = newCommission * cp;

                if( newRating <= 3) {
                    newRating += ran.nextInt(2);
                } else {
                    newRating += (ran.nextInt(3) - 2);
                }
                if( newPotential <= 3) {
                    newPotential += ran.nextInt(2);
                } else {
                    newPotential += (ran.nextInt(3) - 2);
                }
            }
            comps.add(0, new Compensation((getEmpId() * 100) + (years - x) + 1, getEmpId(), 85 + (((years - x) % 7) * 5), newSalary, newBonus,
                                       newCommission, new Date(new Date().getTime() - (year * (years-x)))));
            perfs.add(0, new Performance((getEmpId() * 100) + (years - x) + 1, getEmpId(), newRating, newPotential,
                                      new Date(new Date().getTime() - (year * (years-x))), getFirstName() + getLastName().substring(0,1)));

            skills.add(new Skill(skillList[x], ran.nextInt(5)+1));
            skills.add(new Skill(skillList[x+10], ran.nextInt(5)+1));
            
            int num = ran.nextInt(3) + 1; // 1-3 random events per x

            for (int y = 0; y < num; y++) {
                int startday = ran.nextInt(120);
                int length = ran.nextInt(21) - 7;
                Date start = new Date(new Date().getTime() + (startday * day));
                Date end = null;
                if (length > 0) {
                    end = new Date(start.getTime() + (length * day));
                } else {
                    end = new Date(start.getTime());
                }
                int type = ran.nextInt(4) + 1;

                events.add(new Event(x * 10 + y, type, eventlist[type - 1][y], start, end));
            }
        }
        
        // Add this year's compensation and performance values to the history so this year as the last bar
        comps.add(new Compensation((getEmpId() * 100) + years + 2, getEmpId(), getCompRatio(), getSalary(), getBonus(), getCommission(), new Date()) );
        perfs.add(new Performance((getEmpId() * 100) + years + 2, getEmpId(), getRating(), getPotential(), new Date(), getFirstName() + getLastName().substring(0,1) ));

        // Add some events for the next 7 days for Steven or his directs
        if( this.getMgrId() == 100 || this.getEmpId() == 100) {
            for (int x = 0; x < 2; x++) {
                Date start = new Date(new Date().getTime() + (x * day));
                events.add(new Event(events.size(), 1, eventlist[0][x], start, start));
                events.add(new Event(events.size(), 1, eventlist[0][x + 6], start, start));
                events.add(new Event(events.size(), 2, eventlist[1][x], start, start));
            }
        }

        calcEvents();

        // Create the data for the compensation pie chart
        piecomps.add(new CompItem(0, getSalary(), "Salary"));
        piecomps.add(new CompItem(1, getBonus(), "Bonus"));
        piecomps.add(new CompItem(2, getCommission(), "Commission"));

        int count = hr.s_employees.size();
        int thisMgrId = this.getMgrId();
        int thisEmpId = this.getEmpId();

        // Calculate  this person's colleagues and direct reports
        for (int x = 0; x < count; x++) {
            Employee e = (Employee) hr.s_employees.get(x);
            int mgrId = e.getMgrId();
            if (mgrId == thisMgrId) {
                boolean added = false;
                for (int y = 0; y < colleaguePerfs.size(); y++) {
                    Performance p = (Performance) colleaguePerfs.get(y);
                    if (e.getRating() > p.getRating()) {
                        colleaguePerfs.add(y, new Performance(colleaguePerfs.size() + 1, e.getEmpId(), e.getRating(),
                                                          e.getPotential(), new Date(), e.getFirstName() + " " + e.getLastName()));
                        added = true;
                        break;
                    }
                }
                if (!added) {
                    colleaguePerfs.add(new Performance(colleaguePerfs.size() + 1, e.getEmpId(), e.getRating(),
                                                      e.getPotential(), new Date(), e.getFirstName() + " " + e.getLastName()));
                }
                teamAvgRating += e.getRating();
            }
            if (mgrId == thisEmpId) {
                reports.add(e);
            }
        }
        if (colleaguePerfs.size() > 0) {
            teamAvgRating /= colleaguePerfs.size();
        }
        
    }

    protected void createGroupInfo() {
        // Now find the totals for this person's organization
        traverseOrg(this);
        groupAvgPotential /= groupSize;
        groupAvgRating /= groupSize;
    }

    private void traverseOrg(Employee emp) {
        // Don't add yourself into the group metrics
        if (emp.getEmpId() != this.getEmpId()) {
            groupAvgRating += emp.getRating();
            groupAvgPotential += emp.getPotential();
            int compRatio = emp.getCompRatio();
            if (compRatio <= 95) {
                groupCompRatioBelow++;
            } else if (compRatio > 95 && compRatio <= 110) {
                groupCompRatioIn++;
            } else {
                groupCompRatioAbove++;
            }

            Event[] evts = emp.getEvents();
            for (int x = 0; x < evts.length; x++) {
                switch (evts[x].getType()) {
                case 1:
                    groupMeetings += isInNextSevenDays(evts[x]);
                    break;
                case 2:
                    groupEvents += isInNextSevenDays(evts[x]);
                    break;
                case 3:
                    groupTrainings += isInNextSevenDays(evts[x]);
                    break;
                case 4:
                    groupTimeOff += isInNextSevenDays(evts[x]);
                    break;
                }
            }
        }

        int reports = emp.getReportCount();
        groupSize += reports;
        if (reports > 0) {
            Employee[] team = emp.getReports();
            for (int x = 0; x < reports; x++) {
                traverseOrg(team[x]);
            }
        }
    }

    public void calcEvents() {
        for (int x = 0; x < events.size(); x++) {
            Event evt = (Event) events.get(x);
            switch (evt.getType()) {
            case 1:
                empMeetings += isInNextSevenDays(evt);
                break;
            case 2:
                empEvents += isInNextSevenDays(evt);
                break;
            }
        }
    }


    private int isInNextSevenDays(Event e) {
        int add = 0;

        Date sevenDaysFromNow = new Date(new Date().getTime() + (day * 7));

        if (e.getStart().before(sevenDaysFromNow)) {
            add++;
        }

        return add;
    }

    public String getRatingDesc() {
        return calcRatingDesc(this.rating);
    }

    public String getPotentialDesc() {
        return calcRatingDesc(this.potential);
    }

    public String calcRatingDesc(int value) {
        String desc = "";
        switch (value) {
        case 3:
            desc = "Average";
            break;
        case 4:
            desc = "Outstanding";
            break;
        case 5:
            desc = "Exceptional";
            break;
        default:
            desc = "Below";
            break;
        }
        return desc;
    }

    public int getSkillCount() {
        return skills.size();
    }
    
    public Employee[] getMe() {
        return new Employee[] { this };
    }
}



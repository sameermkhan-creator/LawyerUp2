package com.mystifydev.lawyerup2.ui.dashboard;

public class model {
    private String Where;
    private String Assigned;
    private String TicketDate;
    private String CourtDate;
    private String Accident;
    private String Driver;
    private String Violations;
    private Long CaseNumber;

    public model() {
    }

    public model(String Where, String Assigned, String TicketDate, String CourtDate, String Accident, String Driver, String Violations, Long CaseNumber) {
        this.Where = Where;
        this.Assigned = Assigned;
        this.TicketDate = TicketDate;
        this.CourtDate = CourtDate;
        this.Driver = Driver;
        this.Violations = Violations;
          this.CaseNumber = CaseNumber;
        this.Accident = Accident;


    }

    public String getWhere() {
        return Where;
    }

    public void setWhere(String where) {
        Where = where;
    }

    public String getAssigned() {
        return Assigned;
    }

    public void setAssigned(String assigned) {
        Assigned = assigned;
    }

    public String getTicketDate() {
        return TicketDate;
    }

    public void setTicketDate(String ticketDate) {
        TicketDate = ticketDate;
    }

    public String getCourtDate() {
        return CourtDate;
    }

    public void setCourtDate(String courtDate) {
        CourtDate = courtDate;
    }

    public String getAccident() {
        return Accident;
    }

    public void setAccident(String accident) {
        Accident = accident;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public String getViolations() {
        return Violations;
    }

    public void setViolations(String violations) {
        Violations = violations;
    }


   public Long getCaseNumber() {
        return CaseNumber;
    }

    public void setCaseNumber(Long caseNumber) {
        CaseNumber = caseNumber;
    }
}

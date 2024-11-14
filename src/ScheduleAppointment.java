import java.time.LocalDateTime;
import java.util.Date;

public class ScheduleAppointment {
    private Person user;
    private Person employee;
    private Date appointmentDateTime;
    private String service;

    public ScheduleAppointment(Person user, Person employee, Date appointmentDateTime, String service) {
        this.user = user;
        this.employee = employee;
        this.appointmentDateTime = appointmentDateTime;
        this.service = service;
    }


    public Person getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Person getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(Date appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}

import java.util.Date;

public class User extends  Person {
    private Date dateOfBirth;
    private String gender;

    public User(String name, String cpf, String email, int id, Date dateOfBirth, String gender) {
        super(id, name, cpf, email);
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

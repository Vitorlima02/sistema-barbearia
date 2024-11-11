import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonDbUser {
    private List<Person> persons = new ArrayList<>();

    public void addPerson(Person person) {
        persons.add(person);
    }

    public List<Person> getPersons() {
        return persons;
    }

    public Person getPersonById(int id) {
        for (Person person : persons) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public void updateUser(String name, String cpf, String email, int id) {
        Person user = getPersonById(id);
        if (user != null) {
            user.setName(name);
            user.setCpf(cpf);
            user.setEmail(email);
            user.setId((id));
        }
    }
}

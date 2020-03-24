import java.util.*;
import java.util.stream.Collectors;

public class Person {

    private String city;
    private String firstName;
    private String lastName;
    private Long pesel;
    Scanner scanner = new Scanner(System.in);

    List<Person> personList = new ArrayList<Person>();
    Collection<Person> filterd = new ArrayList<>();

    public Person() {
    }

    public Person(String city, String firstName, String lastName, Long pesel) {
        this.city = city;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }

    public void createPerson() {

        Person person = new Person();
        validePesel validePesel = new validePesel();

        System.out.println("Podaj swoje imie");
        person.setFirstName(scanner.nextLine());

        System.out.println("Podaj swoje nazwisko");
        person.setLastName(scanner.nextLine());

        System.out.println("Podaj nazwe miasta");
        person.setCity(scanner.nextLine());

        System.out.println("Podaj swoj pesel");
        person.setPesel(scanner.nextLong());


        try {
            if (validePesel.checkPesel(person)) {
                personList.add(person);
            }
        } catch (Exception e) {
            System.out.println("Nie poprawny pesel - nie zapisano do pliku wyjsciowego");
        }

        //personList.add(person);
        scanner.nextLine();

        filterd = personList.stream()
                .collect(Collectors.toMap(
                        Person::getPesel, p -> p, (p1, p2) -> p2))
                .values();
    }

    public void showList() {
        for (Person person : personList
        ) {
            System.out.println(person);
        }
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPesel() {
        return pesel;
    }

    public void setPesel(Long pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "city='" + city + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel=" + pesel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(city, person.city) &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(pesel, person.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, firstName, lastName, pesel);
    }
}

import java.util.*;
import java.util.stream.Collectors;

public class Person {
//    Stworzenie programu, który będzie tworzyć listy mieszkańców i zapisywać je do pliku.
//    Użytkownik podaje korzystając z konsoli nazwę miasta i w kolejnej linii imię, nazwisko i numer PESEL mieszkańca.

//    Numer PESEL powinien być sprawdzany względem poprawności - co najmniej w zakresie sumy kontrolnej ostatniej cyfry.
//    https://pl.wikipedia.org/wiki/PESEL

//    W przypadku złego numeru PESEL podany wpis nie jest zapisywany do pliku a użytkownik otrzymuje komunikat o błędzie.

//    Każde uruchomienie tworzy nowy plik odpowiedzi (program nie odczytuje żadnych danych).

//    W przypadku podania dwa razy tego samego numeru PESEL a innego imienia i nazwiska wpis jest nadpisywany.

//    Napisz co najmniej 2 testy do danych klas - co najmniej dla metody sprawdzającej
//    poprawność numeru PESEL oraz dla jakiejś innej klasy z twojego projektu.

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

        System.out.println("Podaj swoje imie");
        person.setFirstName(scanner.nextLine());

        System.out.println("Podaj swoje nazwisko");
        person.setLastName(scanner.nextLine());

        System.out.println("Podaj nazwe miasta");
        person.setCity(scanner.nextLine());

        System.out.println("Podaj swoj pesel");
        person.setPesel(scanner.nextLong());

        checkPesel(person);

        personList.add(person);
        scanner.nextLine();


        filterd = personList.stream()
                .collect(Collectors.toMap(
                        Person::getPesel, p -> p, (p1, p2) -> p2))
                .values();


    }


    private void checkPesel(Person person) {

        Long[] array = new Long[11];
        Long number = person.getPesel();
        int lenght = (int) (Math.log10(number) + 1);
        if (lenght == 11) {
            for (int i = 10; i >= 0; i--) {
                array[i] = number % 10;
                number /= 10;
                // System.out.println(array[i]);
            }
        } else {
            System.out.println("error");
        }

        //9×a + 7×b + 3×c + 1×d + 9×e + 7×f + 3×g + 1×h + 9×i + 7×j
        int a = (int) (array[0] * 9);
        int b = (int) (array[1] * 7);
        int c = (int) (array[2] * 3);
        int d = (int) (array[3] * 1);
        int e = (int) (array[4] * 9);
        int f = (int) (array[5] * 7);
        int g = (int) (array[6] * 3);
        int h = (int) (array[7] * 1);
        int i = (int) (array[8] * 9);
        int j = (int) (array[9] * 7);

        int suma = a + b + c + d + e + f + g + h + i + j;

        int control = suma % 10;

        if (control == array[10]) {
            System.out.println("hura");
        } else {
            System.out.println("nie poprawny numer pesel");
        }

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

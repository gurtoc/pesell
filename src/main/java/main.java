import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class main {

    public static void main(String[] args) throws IOException {

        Person person = new Person();


        //FileWriter fileWriter = new FileWriter("lista.txt");

        File filePath = File.createTempFile("out_", ".txt", new File("."));
        FileWriter fileWriter = new FileWriter(filePath, true);



        Scanner input = new Scanner(System.in);
        String x;

        do {
            person.createPerson();
            System.out.println("Jeśli chcesz zakończyć dodawanie kolejnych osób wcisnij i potwierdz '`'. W przeciwnym razie wciśnij 'enter'");
            x = input.nextLine();
        } while (!x.equalsIgnoreCase("`"));



//        for (Person s : person.filterd) {
//            writeFile.saveFile().write(s + System.lineSeparator());
//        }
//        writeFile.saveFile().close();

        for (Person s : person.filterd) {
            fileWriter.write(s + System.lineSeparator());
        }
        fileWriter.close();



    }
}

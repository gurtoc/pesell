import java.io.File;
import java.util.Scanner;

public class CompareFiles {

    Scanner scanner = new Scanner(System.in);

    public boolean compare(){
        System.out.println("Wpisz ścieżkę pliku");
        String name = scanner.nextLine();
        File file = new File(name);

        System.out.println("Wpisz ścieżkę pliku drugiego");
        String name2 = scanner.nextLine();
        File file2 = new File(name2);

        if (file==file2){
            return true;
        }else {
            return false;
        }
    }

}

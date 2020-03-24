public class validePesel {

    public boolean checkPesel(Person person) {

        Long[] array = new Long[11];
        Long number = person.getPesel();
        int lenght = (int) (Math.log10(number) + 1);
        if (lenght == 11) {
            for (int i = 10; i >= 0; i--) {
                array[i] = number % 10;
                number /= 10;
            }
        } else {
            System.out.println("pesel nie posiada 11 cyfr");
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
            System.out.println("Zapisano osobę do listy/pliku");
        } else {
            System.out.println("nie poprawny numer pesel");
        }
        return true;
    }
}

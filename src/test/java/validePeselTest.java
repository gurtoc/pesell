import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class validePeselTest {

    @Test
    public void checkTest() {
        Person person = new Person("poznan", "tom", "paw", 88092802614l);
        validePesel validePesel = new validePesel();

        boolean test = validePesel.checkPesel(person);

        assertTrue(test);
    }

    @Test()
    public void checkTest2() {
        Person person = new Person("poznan", "tom", "paw", 8809280261l);
        validePesel validePesel = new validePesel();
        boolean test2 = validePesel.checkPesel(person);
        assertTrue(test2);
    }
}
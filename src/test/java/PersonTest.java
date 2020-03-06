import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {


    @Test
    public void checkPeselTest(){
        Person person = new Person("tom","paw","poznań",88092802614l);

        boolean test = person.checkPesel(person);

        assertTrue( test);
    }

}
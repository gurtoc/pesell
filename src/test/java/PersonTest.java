import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {



    @Test
    public void creatPersonTest(){
        Person person = new Person("poznan", "tom", "paw", 88092802614l);

        assertEquals(person.getCity(),"poznan");
        assertEquals(person.getFirstName(),"tom");
        assertEquals(person.getLastName(),"paw");
        assertEquals(person.getPesel().longValue(),88092802614l);
    }

    @Test
    public void creatPersonTest2(){
        Person person = new Person("poznan", "tom", "paw", 88092814l);

        assertEquals(person.getCity(),"poznan");
        assertEquals(person.getFirstName(),"tom");
        assertEquals(person.getLastName(),"paw");
        assertEquals(person.getPesel().longValue(),88092802614l);
    }


}
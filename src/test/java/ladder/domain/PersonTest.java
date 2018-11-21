package ladder.domain;

import ladder.domain.player.Person;
import org.junit.Test;


public class PersonTest {

    @Test(expected = ladder.exception.FormatException.class)
    public void 사람이름_글자수() {
        Person person = new Person("crongs");
    }

}
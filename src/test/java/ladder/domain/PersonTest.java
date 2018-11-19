package ladder.domain;

import org.junit.Test;


public class PersonTest {

    @Test(expected = ladder.exception.FormatException.class)
    public void 사람이름_글자수() {
        Person person = new Person("crongs");
    }

}
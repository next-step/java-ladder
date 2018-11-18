package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test(expected = ladder.exception.FormatException.class)
    public void 사람이름_글자수() {
        Person person = new Person("crongs");
    }

}
package ladder.domain;

import ladder.exception.FormatException;
import org.junit.Test;

public class PersonTest {

    @Test(expected = FormatException.class)
    public void 이름이_다섯글자이상일_경우_오류발생한다() {
        Person.from("1234567");
    }

}
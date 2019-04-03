package domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {
    private Person person;

    @Before
    public void 참여자생성() {
        String input = "shin, yeon, jong";
        this.person = new Person(input);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 참여자_이름이_다섯글자_이상() {
        this.person = new Person("shinyeonjong, hello~");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 참여자0명() {
        this.person = new Person("");
    }

    @Test
    public void 참여자3명() {
        assertThat(this.person.personCount()).isEqualTo(3);
    }
}

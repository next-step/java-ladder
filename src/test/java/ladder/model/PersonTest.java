package ladder.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    public void 사람_이름_입력() {
        Person person = Person.of("terry");
        assertThat(person).isEqualTo(Person.of("terry"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사람_이름_5자_초과입력() {
        Person.of("abcdefg");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사람_이름_1자_미만입력() {
        Person.of("");
    }
}

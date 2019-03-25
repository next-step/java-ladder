package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PersonTest {

    @Test(expected = IllegalArgumentException.class)
    public void 사람의_이름_NULL() {
        Person person = new Person(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사람의_이름_공백() {
        Person person = new Person(" ");
    }


    @Test
    public void 사람의_이름이_5글자_이하() {
        Person person = new Person("njkim");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 사람의_이름이_5글자_초과() {
        Person person = new Person("namjun");
    }

    @Test
    public void 이름_확인() {
        Person person = new Person("njkim");

        assertThat(person.toString()).isEqualTo(" njkim");
    }

    @Test
    public void 이름_포매팅_확인_5글자_이하() {
        Person person = new Person("nj");

        assertThat(person.toString()).isEqualTo("    nj");
    }
}

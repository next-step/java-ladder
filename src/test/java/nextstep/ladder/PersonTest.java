package nextstep.ladder;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

    @Test
    void personCreateFailureTest() {
        assertThatThrownBy(() -> new Person("tomson"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isEqualsNameTest() {
        Person person = new Person("wotjd");
        assertThat(person.isEqualsName("wotjd"))
                .isTrue();
    }
}

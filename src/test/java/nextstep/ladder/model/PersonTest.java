package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

    @Test
    void create() {
        String name = "osean";
        assertThat(Person.is(name).name()).isEqualTo(name);
    }

    @Test
    void outOfLength() {
        String name = "helloWorld";
        assertThatThrownBy(() -> Person.is(name)).isExactlyInstanceOf(IndexOutOfBoundsException.class);
    }
}
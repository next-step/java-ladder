package nextstep.step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {

    @Test
    void create() {
        Person peter = Person.of("peter");
        assertThat(peter.getName()).isEqualTo("peter");
    }
}

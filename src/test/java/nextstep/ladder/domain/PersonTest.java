package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PersonTest {

    @Test
    void create() {
        Person pobi = new Person("pobi");
        assertThat(pobi.name()).isEqualTo(new Person("pobi").name());
    }
}

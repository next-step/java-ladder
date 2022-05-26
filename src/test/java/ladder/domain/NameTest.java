package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class NameTest {
    @Test
    void create() {
        Name name = Name.of("pobi");
        assertThat(name).isEqualTo(Name.of("pobi"));
    }

    @Test
    void validate() {
        assertThatThrownBy(() -> {
            Name.of("kiwoong");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}

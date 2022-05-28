package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ElementGroupTest {

    @Test
    void invalidCreate() {
        assertThatThrownBy(() -> new ElementGroup(null, new Elements("tom")))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new ElementGroup(new Elements("tom"), null))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new ElementGroup(null, null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
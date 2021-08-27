package nextstep.ladder;

import nextstep.ladder.domain.Name;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameTest {
    @Test
    void create() {
        assertThatThrownBy(()-> new Name("geonhee")).isInstanceOf(IllegalArgumentException.class);
    }
}
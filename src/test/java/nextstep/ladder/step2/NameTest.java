package nextstep.ladder.step2;

import nextstep.ladder.step2.domain.Name;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NameTest {
    @Test
    void create() {
        assertThatThrownBy(()-> new Name("geonhee")).isInstanceOf(IllegalArgumentException.class);
    }
}
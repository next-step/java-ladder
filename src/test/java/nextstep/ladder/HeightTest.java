package nextstep.ladder;

import nextstep.ladder.domain.Height;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void create(int num) {
        assertThatThrownBy(() -> new Height(num)).isInstanceOf(IllegalArgumentException.class);
    }
}
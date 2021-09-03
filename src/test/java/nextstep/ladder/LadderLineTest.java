package nextstep.ladder;

import nextstep.ladder.domain.LadderLine;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderLineTest {

    @Test
    void create() {
        assertThat(LadderLine.of(5).size()).isEqualTo(5);
    }
}
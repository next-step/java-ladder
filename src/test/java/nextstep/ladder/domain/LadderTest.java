package nextstep.ladder.domain;

import nextstep.ladder.doamin.Ladder;
import nextstep.ladder.doamin.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class LadderTest {
    @Test
    @DisplayName("사다리 정상 생성 검증")
    void create() {
        assertDoesNotThrow(() -> Ladder.from(Arrays.asList(Line.from(Arrays.asList(false, true)),
                                                           Line.from(Arrays.asList(false, false)))));
    }

    @Test
    @DisplayName("라인 정보가 빈값이거나 null인 경우 예외 발생 검증")
    void create_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.from(Collections.emptyList()));
        assertThatIllegalArgumentException().isThrownBy(() -> Ladder.from(null));
    }
}

package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {

    @Test
    @DisplayName("사다리의 높이 만큼 사다리가 생성이 되었는지 확인한다.")
    void confirmLadderHeight() {
        Ladder ladder = new Ladder(3, 5);
        assertThat(ladder.lines()).hasSize(3);
    }

    @ParameterizedTest(name = "사다리는 반드시 생성이 되야 합니다.")
    @NullAndEmptySource
    void inputNull(List<Line> lines) {
        assertThrows(NullPointerException.class, () -> {
            Ladder ladder = new Ladder(lines);
        });
    }
}
package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {

    @DisplayName("오른쪽에 발판이 존재하는지 알 수 있다")
    @Test
    void hasSpokeRightSide() {
        Line line = Spoke.of(true, false, true).toLine();
        assertAll(
                () -> assertThat(line.hasSpokeRightSide(Position.of(0))).isTrue(),
                () -> assertThat(line.hasSpokeRightSide(Position.of(1))).isFalse(),
                () -> assertThat(line.hasSpokeRightSide(Position.of(2))).isTrue()
        );
    }
}

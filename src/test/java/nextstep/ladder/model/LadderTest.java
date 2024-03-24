package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("참가자 수와 높이 값을 입력받아 Ladder 생성한다")
    @Test
    void of() {
        int height = 2;
        int countOfPerson = 4;

        Ladder ladder = Ladder.of(height, countOfPerson);
        assertThat(ladder.height()).isEqualTo(height);
    }

    @DisplayName("Line 입력받아 Ladder 생성한다")
    @Test
    void from() {
        Line line1 = Line.from(3);
        Line line2 = Line.from(3);
        Line line3 = Line.from(3);

        Ladder ladder = Ladder.from(line1, line2, line3);

        assertThat(ladder)
                .isEqualTo(Ladder.from(line1, line2, line3));
    }
}

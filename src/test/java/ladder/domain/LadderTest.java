package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("참여자 수와 높이를 가지는 사다리 객체를 생성할 수 있다.")
    @Test
    void createLadder() {
        final Height height = Height.of("1");
        final int playerCount = 1;

        List<Line> actual = new Ladder(playerCount, height).getLines();

        assertThat(actual.get(0)).isEqualTo(Line.of(playerCount));
    }

    @DisplayName("높이가 1, 참여자가 1명인 사다리를 탄다.")
    @Test
    void climbDown() {
        final Position position = new Position(0);
        final Height height = Height.of("1");
        final int playerCount = 1;

        Ladder ladder = new Ladder(playerCount, height);
        Position actual = ladder.climbDown(position);

        assertThat(actual).isEqualTo(position);
    }
}
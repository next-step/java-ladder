package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LadderLine 클래스 테스트")
class LadderLineTest {
    private final int countOfPlayers = 4;

    @DisplayName("입력받은 갯수 만틈 Line 객체를 생성할 수 있다.")
    @Test
    void create() {
        LadderLine ladderLine = new LadderLine(countOfPlayers, new RandomPointGenerationStrategy());

        assertThat(ladderLine.getPoints()).hasSize(countOfPlayers);
    }

    @DisplayName("Point 이동 후의 index를 반환할 수 있다.")
    @Test
    void move() {
        LadderLine ladderLine = new LadderLine(countOfPlayers, new RandomPointGenerationStrategy());

        int actual = ladderLine.move(0);

        assertThat(actual).isGreaterThanOrEqualTo(0);
    }
}


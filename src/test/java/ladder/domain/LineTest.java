package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Line 클래스 테스트")
class LineTest {
    private final int countOfPlayers = 4;

    @DisplayName("입력받은 갯수 만틈 Line 객체를 생성할 수 있다.")
    @Test
    void create() {
        Line line = new Line(countOfPlayers, new RandomPointGenerationStrategy());

        assertThat(line.getPoints()).hasSize(countOfPlayers);
    }

    @DisplayName("Point 이동 후의 index를 반환할 수 있다.")
    @Test
    void move() {
        Line line = new Line(countOfPlayers, new RandomPointGenerationStrategy());

        int actual = line.move(0);

        assertThat(actual).isGreaterThanOrEqualTo(0);
    }
}


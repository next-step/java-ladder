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

    @DisplayName("첫 번째는 기둥 사이를 잇는 다리를 놓을 수 없다.")
    @Test
    void first_is_false() {
        Line line = new Line(countOfPlayers, new RandomPointGenerationStrategy());

        assertThat(line.getPoints().get(0).isPoint()).isFalse();
    }


    @DisplayName("기둥 사이를 잇는 다리를 연속해서 생성할 수 없다.")
    @Test
    void cannot_be_created_continuously() {
        Line line = new Line(countOfPlayers, new AlwaysTruePointGenerationStrategy());
        assertThat(line.getPoints()).hasSize(countOfPlayers);
        assertThat(line.getPoints().get(0).isPoint()).isFalse();
        assertThat(line.getPoints().get(1).isPoint()).isTrue();
        assertThat(line.getPoints().get(2).isPoint()).isFalse();
    }

    private static class AlwaysTruePointGenerationStrategy implements PointGenerationStrategy {
        @Override
        public boolean generate() {
            return true;
        }
    }
}

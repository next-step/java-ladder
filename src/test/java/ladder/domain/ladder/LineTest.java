package ladder.domain.ladder;

import ladder.generator.DefaultLineGenerator;
import ladder.generator.LineGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private Line line;

    @BeforeEach
    void init() {
        LineGenerator lineGenerator = new DefaultLineGenerator(() -> true);
        line = lineGenerator.generate(4);
    }

    @Test
    @DisplayName("Generator 로 line 생성")
    void generateLine() {
        LineGenerator lineGenerator = new DefaultLineGenerator(() -> true);
        Line line = lineGenerator.generate(4);
        assertThat(line).isEqualTo(lineGenerator.generate(4));
        assertThat(line.getPoints()).size().isEqualTo(4);
    }

    @Test
    @DisplayName("라인에서 move(위치값) 호출 -> 위치값 계산 후 반환(+1)")
    void moveRight() {
        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    @DisplayName("라인에서 move(위치값) 호출 -> 위치값 계산 후 반환(-1)")
    void moveLeft() {
        assertThat(line.move(1)).isEqualTo(0);
    }

    @Test
    @DisplayName("라인에서 move(위치값) 호출 -> 위치값 계산 후 반환(정지)")
    void notMove() {
        LineGenerator lineGenerator = new DefaultLineGenerator(() -> false);
        Line line = lineGenerator.generate(4);
        assertThat(line.move(1)).isEqualTo(1);
    }

}
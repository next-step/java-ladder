package ladder.domain.generator;

import ladder.domain.expert.Line;
import ladder.dto.PointDto;
import ladder.exception.BadPositionException;
import ladder.strategy.FalseStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineGeneratorTest {

    private final int sizeOfPersons = 5;
    private final DirectionGenerator directionGenerator = new DirectionGenerator(FalseStrategy.getInstance());
    private final LineGenerator lineGenerator = new LineGenerator(sizeOfPersons, directionGenerator);
    private final Line line = lineGenerator.generate();

    @Test
    @DisplayName("generate 된 라인의 move 테스트")
    void generate() {
        assertAll(
                () -> assertThat(line.move(0))
                        .isEqualTo(1),
                () -> assertThat(line.move(1))
                        .isEqualTo(0),
                () -> assertThat(line.move(2))
                        .isEqualTo(3),
                () -> assertThat(line.move(3))
                        .isEqualTo(2),
                () -> assertThat(line.move(4))
                        .isEqualTo(4)
        );
    }

    @Test
    @DisplayName("sizeOfPersons 보다 더 큰 position 을 move 하려 하면, BadPositionException 이 발생한다.")
    void move_BadPosition() {
        assertAll(
                () -> assertThatExceptionOfType(BadPositionException.class)
                        .isThrownBy(() -> line.move(sizeOfPersons)),
                () -> assertThatExceptionOfType(BadPositionException.class)
                        .isThrownBy(() -> line.move(sizeOfPersons + 10))
        );
    }

    @Test
    @DisplayName("LineDto 의 포장을 풀었을 때 값이 일치하는지 확인")
    void exportLineDto() {
        List<PointDto> points = line.exportLineDto().getPoints();
        assertAll(
                () -> assertThat(points.get(0).getIsLeft())
                        .isFalse(),
                () -> assertThat(points.get(1).getIsLeft())
                        .isTrue(),
                () -> assertThat(points.get(2).getIsLeft())
                        .isFalse(),
                () -> assertThat(points.get(3).getIsLeft())
                        .isTrue(),
                () -> assertThat(points.get(4).getIsLeft())
                        .isFalse()
        );
    }
}

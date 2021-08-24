package ladder.domain.ladder;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Line Test")
class LineTest {

    DirectionStrategy directionStrategy;

    @BeforeEach
    void setUp() {
        directionStrategy = () -> true;
    }

    @Test
    @DisplayName("Line 생성 후 사이즈 체크")
    void generateLine_sizeCheck() {
        int generateCount = 5;
        Line line = Line.generate(directionStrategy, generateCount);
        int actual = line.getDirections().size();
        assertThat(actual).isEqualTo(5);
    }

    @Test
    @DisplayName("마지막 위치는 오른쪽 가로라인이 없는지 확인")
    void lastPositionNonRightTest() {
        // given
        int generateCount = 5;
        Line line = Line.generate(directionStrategy, generateCount);

        // when
        List<Direction> positions = line.getDirections();
        Direction lastDirection = positions.get(positions.size() - 1);

        // then
        assertThat(lastDirection).isNotEqualTo(Direction.RIGHT);
    }

    @Test
    @DisplayName("가로 라인이 겹치지 않는지 확인")
    void notOverlapHorizontalLineTest() {
        // given
        int generateCount = 5;

        // when
        Line line = Line.generate(directionStrategy, generateCount);
        List<Direction> positions = line.getDirections();

        assertAll(
                () -> assertThat(positions.get(0)).isEqualTo(Direction.RIGHT),
                () -> assertThat(positions.get(1)).isEqualTo(Direction.LEFT),
                () -> assertThat(positions.get(2)).isEqualTo(Direction.RIGHT),
                () -> assertThat(positions.get(3)).isEqualTo(Direction.LEFT),
                () -> assertThat(positions.get(4)).isEqualTo(Direction.STRAIGHT)
        );
    }
}
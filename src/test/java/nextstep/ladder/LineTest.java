package nextstep.ladder;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.LinePoint;
import nextstep.ladder.domain.MoveDirection;
import nextstep.ladder.infra.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    private static final int lineLength = 4;

    @ParameterizedTest
    @MethodSource("makeInvalidLine")
    @DisplayName("올바르지 않게 라인 포인트가 이어져 있을 경우 에러 발생")
    void testOverlapLine(List<LinePoint> invalidLine) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(lineLength, count -> invalidLine));
    }


    @Test
    @DisplayName("라인 생성 테스트")
    void testNextIndex() {
        Line line = new Line(lineLength, length -> List.of(rightLinePoint(), leftLinePoint(), nonLinePoint(), rightLinePoint(), leftLinePoint()));
        List<Integer> expectNextIndex = List.of(1, 0, 2, 4, 3);

        for (int i = 0; i < lineLength; i++) {
            assertThat(line.nextIndex(i)).isEqualTo(expectNextIndex.get(i));
        }
        assertThat(line.nextIndex(lineLength)).isEqualTo(expectNextIndex.get(lineLength));
    }

    @Test
    @DisplayName("랜덤 값으로 라인 생성 테스트")
    void testRandomLine() {
        assertThat(new Line(lineLength, new RandomLineGenerator()).getLine()).hasSize(lineLength);
    }

    private static List<List<LinePoint>> makeInvalidLine() {
        return List.of(
                List.of(rightLinePoint(), nonLinePoint(), nonLinePoint(), nonLinePoint()),
                List.of(rightLinePoint(), nonLinePoint(), leftLinePoint(), nonLinePoint()),
                List.of(nonLinePoint(), nonLinePoint(), nonLinePoint(), rightLinePoint()),
                List.of(leftLinePoint(), nonLinePoint(), nonLinePoint(), nonLinePoint())
        );
    }

    private static LinePoint leftLinePoint() {
        return LinePoint.of(MoveDirection.LEFT);
    }

    private static LinePoint rightLinePoint() {
        return LinePoint.of(MoveDirection.RIGHT);
    }

    private static LinePoint nonLinePoint() {
        return LinePoint.of(MoveDirection.NON);
    }


}

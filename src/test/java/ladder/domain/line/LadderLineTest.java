package ladder.domain.line;

import ladder.domain.point.Direction;
import ladder.domain.point.FakeDirectionCreateStrategy;
import ladder.exception.InvalidDirectionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderLineTest {
    @DisplayName("열려있지 않은 줄을 닫았음")
    @Test
    void ctorTest_PointNotOpend() {
        assertThatThrownBy(() ->
                LadderLine.builder()
                        .manuel()
                        .next(Direction.RIGHT)
                        .next(Direction.LEFT)
                        .next(Direction.LEFT)
                        .build()
        ).isInstanceOf(InvalidDirectionException.class);
    }

    @DisplayName("열려있지만 닫히지 않은 줄이 존재")
    @Test
    void ctorTest_PointNotClosed() {
        assertThatThrownBy(() ->
                LadderLine.builder()
                        .manuel()
                        .next(Direction.RIGHT)
                        .next(Direction.LEFT)
                        .next(Direction.RIGHT)
                        .build()
        ).isInstanceOf(InvalidDirectionException.class);
    }

    @DisplayName("첫번째 줄이 닫혀있으면 안됨")
    @Test
    void ctorTest_PointFirstOpened() {
        assertThatThrownBy(() ->
                LadderLine.builder()
                        .manuel()
                        .next(Direction.LEFT)
                        .build()
        ).isInstanceOf(InvalidDirectionException.class);
    }

    @DisplayName("마지막 줄이 열려있으면 안됨")
    @Test
    void ctorTest_PointLastOpened() {
        assertThatThrownBy(() ->
                LadderLine.builder()
                        .manuel()
                        .next(Direction.RIGHT)
                        .next(Direction.LEFT)
                        .next(Direction.RIGHT)
                        .build()
        ).isInstanceOf(InvalidDirectionException.class);
    }

    @CsvSource({"3,0,1", "3,1,0", "3,2,2"})
    @DisplayName("move가 정상적으로 움직였는지 테스트")
    @ParameterizedTest
    void moveTest(int pointSize, int index, int correctIndex) {
        LadderLine line = LadderLine.builder()
                .auto(new FakeDirectionCreateStrategy())
                .pointSize(pointSize)
                .build();

        assertThat(
                line.move(index)
        ).isEqualTo(correctIndex);
    }
}

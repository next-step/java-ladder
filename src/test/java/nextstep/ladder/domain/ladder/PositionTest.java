package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 포인트의 위치 테스트")
public class PositionTest {
    @DisplayName("사다리 잘못된 위치 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"-1:4", "3:1"}, delimiter = ':')
    public void createPosition(int currentPosition, int maxPosition) {
        assertThatThrownBy(() -> {
            Position.of(currentPosition, maxPosition);
        }).isInstanceOf(InvalidPointPositionException.class)
                .hasMessageContaining("포인트의 위치는 0이상이고 최대로 지정된 위치보다 작아야 합니다.");
    }

    @DisplayName("다음 사다리 포지션 생성")
    @Test
    public void next() {
        Position position = Position.of(0, 10).next();

        int currentPosition = position.getCurrentPosition();

        assertThat(currentPosition).isEqualTo(1);
    }

    @DisplayName("사다리 이전 포지션")
    @Test
    public void prevPosition() {
        Position position = Position.of(1, 10);

        int currentPosition = position.getPreviousPosition();

        assertThat(currentPosition).isEqualTo(0);
    }

    @DisplayName("사다리 다음 포지션")
    @Test
    public void nextPosition() {
        Position position = Position.of(1, 10);

        int currentPosition = position.getNextPosition();

        assertThat(currentPosition).isEqualTo(2);
    }

    @DisplayName("첫번째 포지션")
    @Test
    public void first() {
        Position position = Position.first(10);

        int currentPosition = position.getCurrentPosition();

        assertThat(currentPosition).isEqualTo(0);
    }

    @DisplayName("마지막 사다리 포지션")
    @Test
    public void last() {
        Position position = Position.of(0, 10).last();

        int currentPosition = position.getCurrentPosition();

        assertThat(currentPosition).isEqualTo(10);
    }

    @DisplayName("마지막 사다리 포지션인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:true"}, delimiter = ':')
    public void isLast(int currentPosition, boolean expectedResult) {
        Position position = Position.of(currentPosition, 1);

        boolean isLast = position.isLast();

        assertThat(isLast).isEqualTo(expectedResult);
    }
}
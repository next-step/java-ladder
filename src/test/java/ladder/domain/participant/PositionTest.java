package ladder.domain.participant;

import ladder.exception.InvalidPositionNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5})
    public void createInstanceTest(int startPosition) {
        //Given & When
        Position position = Position.from(startPosition);

        //Then
        assertThat(position).isEqualTo(Position.from(startPosition));

    }

    @DisplayName("Postion 인스턴스 생성시 0보다 작은값일 경우 예외처리")
    @Test
    public void inValidStartPositionValue() {
        assertThatThrownBy(() ->
                Position.from(-1)
        ).isInstanceOf(InvalidPositionNumberException.class);
    }

    @DisplayName("1 혹은 -1 보다 더 큰 절대값 수가 들어갈 경우 예외처리")
    @ParameterizedTest
    @ValueSource(ints = {-2, 2, 3, 5, 6})
    public void inValidMovePositionValue(int movePosition) {
        assertThatThrownBy(() ->
                Position.from(1).move(movePosition)
        ).isInstanceOf(InvalidPositionNumberException.class);
    }

    @DisplayName("포지션 이동 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, -1})
    public void movePositionTest(int movePosition) {
        //Given & When
        int startPosition = 3;
        Position movedPosition = Position.from(startPosition).move(movePosition);

        //Then
        assertThat(movedPosition).isEqualTo(Position.from(startPosition + movePosition).move(0));
    }

    @Test
    public void movePositionForEachTest() {
        //Given
        Position position = Position.from(5);
        Position expectedPosition = Position.from(10);

        for (int i = 0; i < 5; i++){
            position = position.move(1);
            expectedPosition = expectedPosition.move(0);
        }

        //Then
        assertThat(position).isEqualTo(expectedPosition);
    }

}

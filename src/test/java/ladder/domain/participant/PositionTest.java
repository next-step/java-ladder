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


    @DisplayName("포지션 이동 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void movePositionTest(int newPosition) {
        //Given & When
        int startPosition = 3;
        Position movedPosition = Position.from(startPosition).move(newPosition);

        //Then
        assertThat(movedPosition).isEqualTo(Position.from(newPosition).move(newPosition));
    }

}

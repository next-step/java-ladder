package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @ParameterizedTest
    @CsvSource(value = {"4,4"}, delimiter = ',')
    @DisplayName("위치좌표의 생성 및 위치확인 테스트")
    void positionTest(int initailPosition, int checkPosition) {
        Position position = new Position(initailPosition);
        assertThat(position.getPosition()).isEqualTo(checkPosition);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2"}, delimiter = ',')
    @DisplayName("위치좌표의 오른쪽이동 테스트")
    void positionRightMoveTest(int initailPosition, int checkPosition) {
        Position position = new Position(initailPosition);
        position.right();
        assertThat(position.getPosition()).isEqualTo(checkPosition);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,2"}, delimiter = ',')
    @DisplayName("위치좌표의 왼쪽이동 테스트")
    void positionLeftMoveTest(int initailPosition, int checkPosition) {
        Position position = new Position(initailPosition);
        position.left();
        assertThat(position.getPosition()).isEqualTo(checkPosition);
    }

}

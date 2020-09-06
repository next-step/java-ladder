package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderPositionBoardTest {

    @ParameterizedTest
    @CsvSource(value = {"0,1"}, delimiter = ',')
    @DisplayName("사다리 위치 테스트")
    void ladderPositionBoardTest(int switchPosition, int position) {
        Users users = Users.create("test1,test2");
        LadderPositionBoard ladderPositionBoard = LadderPositionBoard.create(users);
        ladderPositionBoard.switchPosition(switchPosition);
        ladderPositionBoard.resultUserPosition("test1");
        assertThat(ladderPositionBoard.resultUserPosition("test1").getPosition()).isEqualTo(position);
    }

    @Test
    @DisplayName("존재하지않는 참여자 조회시 에러 테스트")
    void notExistUserTest() {
        assertThatThrownBy(() -> {
            Users users = Users.create("test1,test2");
            LadderPositionBoard ladderPositionBoard = LadderPositionBoard.create(users);

            ladderPositionBoard.resultUserPosition("test3");
        }).isInstanceOf(IllegalArgumentException.class);
    }

}

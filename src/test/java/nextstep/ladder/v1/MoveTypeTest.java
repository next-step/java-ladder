package nextstep.ladder.v1;

import nextstep.ladder.v1.model.MoveType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoveTypeTest {
    @Test
    @DisplayName("MoveType NEXT 테스트")
    void moveTypeNextTest() {
        //given
        int startIndex = 0;

        //when
        int nextMove = MoveType.NEXT.getNextMove(startIndex);

        //then
        Assertions.assertThat(nextMove).isEqualTo(1);
    }

    @Test
    @DisplayName("MoveType STAY 테스트")
    void moveTypeStayTest() {
        //given
        int startIndex = 0;

        //when
        int nextMove = MoveType.STAY.getNextMove(startIndex);

        //then
        Assertions.assertThat(nextMove).isEqualTo(0);
    }

    @Test
    @DisplayName("MoveType BACK 테스트")
    void moveTypeBackTest() {
        //given
        int startIndex = 1;

        //when
        int nextMove = MoveType.BACK.getNextMove(startIndex);

        //then
        Assertions.assertThat(nextMove).isEqualTo(0);
    }
}

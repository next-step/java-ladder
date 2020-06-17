package nextstep.ladder.domain;

import nextstep.ladder.domain.user.LadderGameUser;
import nextstep.ladder.domain.vo.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderLinesTest {

    @DisplayName("첫번째 유저는 최대높이-1 만큼의 Point 무조건 생성하고, 두번째 유저는 첫번쨰 유저와 연결되는 포인트가 아닌 3번쨰 포인트연결을 생성한다.")
    @Test
    void createLadder() {
        //given
        LadderGameUser user1 = new LadderGameUser("abc");
        LadderGameUser user2 = new LadderGameUser("def");
        int maxHeight = 3;
        LadderLines ladderLines = new LadderLines();

        //when
        ladderLines.addLine(Order.of(1), user1, () -> true, maxHeight);
        ladderLines.addLine(Order.of(2), user2, () -> true, maxHeight);

        //then
        /*
        | ------ |        |
        | ------ |        |
        |        | ------ |
         */
        assertAll(
                () -> assertThat(ladderLines.findLadderLineBy(1).connectedWith(1)).isTrue(),
                () -> assertThat(ladderLines.findLadderLineBy(1).connectedWith(2)).isTrue(),
                () -> assertThat(ladderLines.findLadderLineBy(1).connectedWith(3)).isFalse(),
                () -> assertThat(ladderLines.findLadderLineBy(2).connectedWith(3)).isTrue()
        );
    }


}
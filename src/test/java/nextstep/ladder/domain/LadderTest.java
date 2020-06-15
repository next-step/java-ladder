package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("항상 true를 반환하는 드로잉머신으로 사다리테스트")
class LadderTest {

    @DisplayName("첫번째 유저는 최대높이-1 만큼의 Point 무조건 생성하고, 두번째 유저는 첫번쨰 유저와 연결되는 포인트가 아닌 3번쨰 포인트연결을 생성한다.")
    @Test
    void createLadder() {
        //given
        LadderGameUser user1 = new LadderGameUser(Order.FIRST_ORDER, "abc");
        LadderGameUser user2 = new LadderGameUser(Order.of(2), "def");
        int maxHeight = 3;
        Ladder ladder = new Ladder(maxHeight);

        //when
        ladder.drawLine(user1, () -> true);
        ladder.drawLine(user2, () -> true);

        //then
        /*
        | ------ |        |
        | ------ |        |
        |        | ------ |
         */
        assertAll(
                () -> assertThat(ladder.findLadderLineByOrder(Order.of(1)).connectedWith(Point.of(1))).isTrue(),
                () -> assertThat(ladder.findLadderLineByOrder(Order.of(1)).connectedWith(Point.of(2))).isTrue(),
                () -> assertThat(ladder.findLadderLineByOrder(Order.of(1)).connectedWith(Point.of(3))).isFalse(),
                () -> assertThat(ladder.findLadderLineByOrder(Order.of(2)).connectedWith(Point.of(3))).isTrue()
        );
    }

}
package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGameTest {

    @DisplayName("항상 true를 반환하는 드로잉머신으로 사다리리를 생성하는 테스트")
    @Test
    void createLadder() {
        //given
        LadderGame ladderGame = new LadderGame(() -> true);
        LadderGameUsers users = createLadderGameUsers();
        int maxHeight = 3;

        //when
        Ladder ladder = ladderGame.createLadder(users, maxHeight);

        //then
        /*
        | ------ |        |
        | ------ |        |
        |        | ------ |
         */
        assertAll(
                () -> assertThat(ladder.findByOrder(Order.of(1)).connectedWith(Point.of(0))).isTrue(),
                () -> assertThat(ladder.findByOrder(Order.of(1)).connectedWith(Point.of(1))).isTrue(),
                () -> assertThat(ladder.findByOrder(Order.of(1)).connectedWith(Point.of(2))).isFalse(),
                () -> assertThat(ladder.findByOrder(Order.of(2)).connectedWith(Point.of(2))).isTrue()
        );
    }

    private LadderGameUsers createLadderGameUsers() {
        LadderGameUser user1 = new LadderGameUser(Order.FIRST_ORDER, "abc");
        LadderGameUser user2 = new LadderGameUser(Order.of(2), "def");
        LadderGameUser user3 = new LadderGameUser(Order.of(3), "ghi");
        return new LadderGameUsers(Arrays.asList(user1, user2, user3));
    }

}
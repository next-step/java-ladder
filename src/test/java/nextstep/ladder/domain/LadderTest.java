package nextstep.ladder.domain;

import nextstep.ladder.domain.user.LadderGameUser;
import nextstep.ladder.domain.user.LadderGameUserStorage;
import nextstep.ladder.domain.vo.Order;
import nextstep.ladder.domain.vo.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderTest {

    @DisplayName("Order와 Point가 주어졌을 때 연결라인이 있는지 여부를 반환한")
    @Test
    void connect() {
        //given
        Ladder ladder = Ladder.of(3, createLadderGameUsers(), createLadderLines());

        //then
        assertAll(
                () -> assertThat(ladder.hasConnection(1, 1)).isTrue(),
                () -> assertThat(ladder.hasConnection(1, 2)).isTrue(),
                () -> assertThat(ladder.hasConnection(1, 3)).isFalse(),
                () -> assertThat(ladder.hasConnection(2, 3)).isTrue()
        );
    }

    private LadderGameUserStorage createLadderGameUsers() {
        LadderGameUser user1 = new LadderGameUser("abc");
        LadderGameUser user2 = new LadderGameUser("def");
        LadderGameUser user3 = new LadderGameUser("ghi");
        return new LadderGameUserStorage(Arrays.asList(user1, user2, user3));
    }

    private LadderLines createLadderLines() {
        //then
        /*
        | ------ |        |
        | ------ |        |
        |        | ------ |
         */
        LadderLines ladderLines = new LadderLines();
        ladderLines.addLine(Order.of(1), () -> true, Point.of(3));
        ladderLines.addLine(Order.of(2), () -> true, Point.of(3));
        ladderLines.addLine(Order.of(3), () -> false, Point.of(3));
        return ladderLines;
    }
}
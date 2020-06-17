package nextstep.ladder.domain;

import nextstep.ladder.domain.game.LadderGame;
import nextstep.ladder.domain.game.LadderGamePrize;
import nextstep.ladder.domain.game.LadderGameResult;
import nextstep.ladder.domain.user.LadderGameUser;
import nextstep.ladder.domain.user.LadderGameUserStore;
import nextstep.ladder.domain.vo.Order;
import nextstep.ladder.domain.vo.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("항상 true를 반환하는 라이너로 게임진행")
class LadderGameTest {
    LadderGame ladderGame = new LadderGame(() -> true);

    @DisplayName("항상 true를 반환하는 드로잉머신으로 사다리리를 생성하는 테스트")
    @Test
    void createLadder() {
        //given
        LadderGameUserStore users = createLadderGameUsers();
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
                () -> assertThat(ladder.hasConnection(1, 1)).isTrue(),
                () -> assertThat(ladder.hasConnection(1, 2)).isTrue(),
                () -> assertThat(ladder.hasConnection(1, 3)).isFalse(),
                () -> assertThat(ladder.hasConnection(2, 3)).isTrue()
        );
    }

    @DisplayName("사다리와 경품정보를 입력하면 결과를 반환한다")
    @Test
    void result() {
        //given
        LadderGameUserStore ladderGameUsers = createLadderGameUsers();
        Ladder ladder = Ladder.of(Point.of(3), ladderGameUsers, createLadderLines());
        LadderGamePrize prize = createPrize();

        //when
        LadderGameResult result = ladderGame.execute(ladder, prize);

        //then
        assertAll(
                () -> assertThat(result.getPrizeOf(ladderGameUsers.findByUserName("abc").get())).isEqualTo("꽝"),
                () -> assertThat(result.getPrizeOf(ladderGameUsers.findByUserName("def").get())).isEqualTo("당첨"),
                () -> assertThat(result.getPrizeOf(ladderGameUsers.findByUserName("ghi").get())).isEqualTo("꽝")
        );

    }

    private LadderGameUserStore createLadderGameUsers() {
        LadderGameUser user1 = new LadderGameUser("abc");
        LadderGameUser user2 = new LadderGameUser("def");
        LadderGameUser user3 = new LadderGameUser("ghi");
        return new LadderGameUserStore(Arrays.asList(user1, user2, user3));
    }

    private LadderLines createLadderLines() {
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

    private LadderGamePrize createPrize() {
        Map<Order, String> prizes = new HashMap<>();
        prizes.put(Order.of(1), "꽝");
        prizes.put(Order.of(2), "꽝");
        prizes.put(Order.of(3), "당첨");
        return new LadderGamePrize(prizes);
    }


}
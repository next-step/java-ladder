package nextstep.ladder.domain;

import nextstep.ladder.domain.game.LadderGame;
import nextstep.ladder.domain.game.LadderGamePrize;
import nextstep.ladder.domain.game.LadderGameResult;
import nextstep.ladder.domain.user.LadderGameUser;
import nextstep.ladder.domain.user.LadderGameUserStorage;
import nextstep.ladder.domain.vo.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("항상 true를 반환하는 라이너로 게임진행")
class LadderGameTest {

    @DisplayName("항상 true를 반환하는 드로잉머신으로 사다리리를 생성하는 테스트")
    @Test
    void createLadder() {
        //given
        LadderGame ladderGame = new LadderGame(() -> true);
        LadderGameUserStorage users = createLadderGameUsers();
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
        LadderGameUserStorage users = createLadderGameUsers();
        Ladder ladder = new Ladder(3, new TestConditional(), 3);
        LadderGamePrize prize = createPrize();
        LadderGame ladderGame = new LadderGame(new TestConditional());

        /*
        abc def ghi
        |---|   |
        |   |---|
        |---|   |
        꽝   꽝   당첨
         */
        //when
        LadderGameResult result = ladderGame.execute(ladder, users, 3, prize);

        //then
        assertAll(
                () -> assertThat(result.getPrizeOf(users.findByUserName("abc").get())).isEqualTo("당첨"),
                () -> assertThat(result.getPrizeOf(users.findByUserName("def").get())).isEqualTo("꽝"),
                () -> assertThat(result.getPrizeOf(users.findByUserName("ghi").get())).isEqualTo("꽝")
        );

    }

    private LadderGameUserStorage createLadderGameUsers() {
        LadderGameUser user1 = new LadderGameUser("abc");
        LadderGameUser user2 = new LadderGameUser("def");
        LadderGameUser user3 = new LadderGameUser("ghi");
        return new LadderGameUserStorage(Arrays.asList(user1, user2, user3));
    }

    private LadderGamePrize createPrize() {
        Map<Order, String> prizes = new HashMap<>();
        prizes.put(Order.of(1), "꽝");
        prizes.put(Order.of(2), "꽝");
        prizes.put(Order.of(3), "당첨");
        return new LadderGamePrize(prizes);
    }

    static class TestConditional implements LadderConnectionConditional {
        static boolean flag = false;

        @Override
        public boolean isEnough() {
            flag = !flag;
            return flag;
        }
    }

}
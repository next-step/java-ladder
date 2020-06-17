package nextstep.ladder.domain;

import nextstep.ladder.domain.game.LadderGame;
import nextstep.ladder.domain.user.LadderGameUser;
import nextstep.ladder.domain.user.LadderGameUserStore;
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

    private LadderGameUserStore createLadderGameUsers() {
        LadderGameUser user1 = new LadderGameUser("abc");
        LadderGameUser user2 = new LadderGameUser("def");
        LadderGameUser user3 = new LadderGameUser("ghi");
        return new LadderGameUserStore(Arrays.asList(user1, user2, user3));
    }

}
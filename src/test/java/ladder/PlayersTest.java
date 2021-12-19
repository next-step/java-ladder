package ladder;

import ladder.domain.Players;
import ladder.fixture.TestLadderFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {

    @Test
    void 입력한플레이어_수() {
        Players players = TestLadderFactory.createPlayer("pobi,honux,crong,jk");
        assertThat(players.countOfPlayers()).isEqualTo(4);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobbby,honux,crong", "poby,hoonux,crong", "poby,,crong"})
    void 플레이어_이름_5자초과_예외(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(()-> TestLadderFactory.createPlayer(input))
                .withMessage("이름은 1~5자까지 가능합니다.");
    }

    @ParameterizedTest
    @EmptySource
    void 플레이어_이름_empty_예외(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(()-> TestLadderFactory.createPlayer(input))
                .withMessage("참여할 사람의 이름을 입력해주세요");
    }

}

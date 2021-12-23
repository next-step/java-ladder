package ladder.domain;

import ladder.fixture.TestLadderFactory;
import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("플레이어들 중 해당하는 이름이 없을 경우 예외")
    @Test
    void 플레이어_findIndexByName_예외() {
        Players players = TestLadderFactory.createPlayer("hi,hello,bye");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> players.findIndexByName("poby"))
                .withMessage("찾을 수 없는 이름입니다.");
    }

}

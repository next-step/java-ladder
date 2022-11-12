package nextstep.ladder;

import nextstep.ladder.domain.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayersTest {

    @Test
    void 성공테스트() {
        Players players = new Players(new String[]{"num1","num2"});

        assertThat(players).isEqualTo(new Players(new String[]{"num1", "num2"}));
    }

    @Test
    void 중복오류_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Players(new String[]{"num1", "num1"})
        );
    }

    @Test
    void 이름_길이_5자초과_테스트() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Players(new String[]{"123456"})
        );
    }

    @Test
    void changePosition() {
        Players players = new Players(new String[]{"A", "B", "C", "D"});

        players.changePositions(1);

        assertThat(players).isEqualTo(new Players(new String[]{"A", "C", "B", "D"}));
    }
}

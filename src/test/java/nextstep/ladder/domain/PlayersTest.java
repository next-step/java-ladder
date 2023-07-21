package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {
    @Test
    void 참여자_길이_테스트(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Players(List.of(new Player("kbc"))));
    }

    @Test
    void toString_테스트(){
        Players players = new Players(List.of(new Player("kbc"), new Player("kbc2")));

        String result = players.toString();

        assertThat(result).isEqualTo("   kbc  kbc2");
    }


}

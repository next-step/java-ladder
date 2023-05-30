package ladder;

import ladder.domain.Players;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.domain.Player.validateName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {

    @Test
    void 새로운_플레이어들_생성() {
        Players players = new Players(List.of("일","이","삼"));
        assertThat(players.getCountOrPerson()).isEqualTo(3);
    }

    @Test
    void 이름이_5자이상이면_에러발생() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    validateName("일이삼사오육");
                });
    }
}

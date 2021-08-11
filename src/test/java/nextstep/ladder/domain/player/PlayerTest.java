package nextstep.ladder.domain.player;

import nextstep.ladder.domain.exception.PlayerNameLengthLimitException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.player.Player.NAME_LENGTH_LIMIT;

/**
 * Player는 참가자를 표현한다. 현재 위치를 Position에 의존한다.
 */
class PlayerTest {
    @Test
    void initException() {
        Assertions.assertThatThrownBy(() -> {
                      Player.of("pobiii", 1);
                  }).isInstanceOf(PlayerNameLengthLimitException.class)
                  .hasMessage(String.format("참가자 이름의 길이는 %s글자를 넘을 수 없습니다.", NAME_LENGTH_LIMIT));
    }

    @Test
    void getName() {
        String name = "pobi";
        Player pobi = Player.of(name, 1);
        Assertions.assertThat(pobi.name()).isEqualTo(name);
    }
}

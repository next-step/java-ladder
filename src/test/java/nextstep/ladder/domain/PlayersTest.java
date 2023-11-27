package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    @DisplayName("플레이어의 수가 2명 미만이면 예외를 던진다.")
    @Test
    void createPlayersWhenUnderTwo() {
        assertThatThrownBy(() -> new Players(List.of("홍길동"))).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NOT_ENOUGH_PLAYER.message());
    }

    @DisplayName("플레이어들의 이름을 가져온다.")
    @Test
    void playersName() {
        // given
        Players players = new Players(List.of("홍길동", "전창길", "코난"));

        // when & then
        assertThat(players.names()).isEqualTo("홍길동   전창길   코난    ");
    }
}

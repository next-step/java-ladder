package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.ValidPositionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerGameNameTest {


    @Test
    @DisplayName("플레이어 게임 네임이 잘 생성되는지 확인")
    void create() {
        PlayerGameName playerGameName = PlayerGameName.of("a");
        assertThat(playerGameName).isEqualTo(PlayerGameName.of("a"));
    }


    @Test
    @DisplayName("네임이 5글자를 초과하는경우 익셉션 발생")
    void throwPositionException() {
        assertThatThrownBy(() -> PlayerGamePosition.of(-1))
                .isInstanceOf(ValidPositionException.class);
    }
}
package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.exception.NameLengthException;
import step2.exception.NotMoveLeftException;
import step2.exception.NotMoveRightException;
import step2.exception.ValidPositionException;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerGamePositionTest {

    @Test
    @DisplayName("게임 포지션이 잘 생성되는지 확인한다.")
    void create() {
        PlayerGamePosition playerGamePosition = PlayerGamePosition.of(1);
        assertThat(playerGamePosition).isEqualTo(PlayerGamePosition.of(1));
    }


    @Test
    @DisplayName("포지션이 0 이하일경우 익셉션 발생")
    void throwPositionException() {
        assertThatThrownBy(() -> PlayerGamePosition.of(-1))
                .isInstanceOf(ValidPositionException.class);
    }

}
package nextstep.ladder.domain.play;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayResultTest {

    @DisplayName("Player Position List로 PlayResult를 만든다")
    @Test
    void should_make_player() {
        //arrange, act, assert
        assertThat(PlayResult.of(Arrays.asList(PlayerPosition.of(0)))).isInstanceOf(PlayResult.class);
    }

    @DisplayName("PlayerPosition이 null 이면 IllegalArgumentException이 발생한다")
    @Test
    void should_throw_exception_when_null() {
        assertThatIllegalArgumentException().isThrownBy(() -> PlayResult.of(null));
    }

    @DisplayName("시작Position에 맞는 Ladder의 Position을 반환한다")
    @Test
    void should_return_position() {
        //arrange
        List<PlayerPosition> playerPositionList = Arrays.asList(PlayerPosition.of(0), PlayerPosition.of(1));
        PlayResult playResult = PlayResult.of(playerPositionList);

        //act
        PlayerPosition resultPosition = playResult.result(PlayerPosition.of(0));

        //assert
        assertThat(resultPosition.getValue()).isEqualTo(0);
    }

}

package nextstep.ladder.domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PlayerRecordTest {

    @DisplayName("record String으로 PlayerRecord 객체를 만들 수 있다")
    @Test
    void should_make_player_record() {
        //arrange, act, assert
        assertThat(PlayerRecord.of("record")).isInstanceOf(PlayerRecord.class);
    }

    @DisplayName("플레이어 이름이 null 이거나 비어있으면 IllegalArgumentException이 발생한다")
    @Test
    void should_throw_exception_when_null() {
        assertThatIllegalArgumentException().isThrownBy(() -> PlayerRecord.of(null));
    }

}
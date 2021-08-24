package nextstep.ladder.domain;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PlayersTest {

    @Test
    @DisplayName("플레이어들 생성 - 플레이어들 이름이 null 인 경우")
    public void nonNull() {
        // given
        String names = null;
        String message = "입력값은 null 일 수 없습니다";

        // when
        ThrowingCallable throwingCallable = () -> new Players(names);

        // then
        assertThatThrownBy(throwingCallable)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
    }

    @ParameterizedTest(name = "플레이어 count 테스트 | {arguments}")
    @CsvSource(value = {"pobi,honux,crong,jk|4", "a|1"}, delimiter = '|')
    public void count(final String names, final int expected) {
        // given

        // when
        Players players = new Players(names);

        // then
        assertThat(players).isNotNull();
        assertThat(players.count()).isEqualTo(expected);
    }

}
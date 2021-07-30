package nextstep.ladder.domain.init;

import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.gift.Gifts;
import nextstep.ladder.exception.NullArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static nextstep.ladder.domain.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 타기 게임의 참가자와 결과 값을 담기 위한 클래스 테스트")
class PlayersAndGiftsTest {

    @DisplayName("참가자 그룹과 결과값 그룹을 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(PlayersAndGifts.of(TWO_PLAYERS, TWO_GIFTS)).isInstanceOf(PlayersAndGifts.class);
    }

    @DisplayName("참가자 원시값 그룹과 결과 원시값 그룹을 가지고 초기화 한다")
    @Test
    void initUsingPrimitives() {
        assertThat(PlayersAndGifts.of(TWO_PLAYERS_NAMES, TWO_GIFTS_VALUES)).isInstanceOf(PlayersAndGifts.class);
    }

    @DisplayName("참자가 그룹이나 결과값 그룹이 null 일 경우 예외를 발생 시킨다")
    @MethodSource
    @ParameterizedTest
    void initException(Players players, Gifts gifts) {
        assertThatThrownBy(() -> PlayersAndGifts.of(players, gifts)).isInstanceOf(NullArgumentException.class);
    }

    private static Stream<Arguments> initException() {
        return Stream.of(
                Arguments.of(null, TWO_GIFTS),
                Arguments.of(TWO_PLAYERS, null),
                Arguments.of(null, null)
        );
    }
}

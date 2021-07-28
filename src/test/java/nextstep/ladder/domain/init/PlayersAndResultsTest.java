package nextstep.ladder.domain.init;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.Fixture.TWO_PLAYERS;
import static nextstep.ladder.domain.Fixture.TWO_RESULTS;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 타기 게임의 참가자와 결과 값을 담기 위한 클래스 테스트")
class PlayersAndResultsTest {

    @DisplayName("참가자 그룹과 결과값 그룹을 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(PlayersAndResults.of(TWO_PLAYERS, TWO_RESULTS)).isInstanceOf(PlayersAndResults.class);
    }

}

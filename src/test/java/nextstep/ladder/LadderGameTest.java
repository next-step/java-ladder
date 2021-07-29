package nextstep.ladder;

import nextstep.ladder.dto.LadderResult;
import nextstep.ladder.dto.MatchResult;
import nextstep.ladder.exception.NullArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static nextstep.ladder.domain.Fixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 게임 클래스 테스트")
class LadderGameTest {

    @DisplayName("사다리 게임은 사다리 게임 초기화 정보를 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(LadderGame.init(LADDER_GAME_INIT_INFO_2_X_2)).isInstanceOf(LadderGame.class);
    }

    @DisplayName("사다리 게임 초기화 정보가 null 일 경우 예외를 발생 시킨다")
    @Test
    void initException() {
        assertThatThrownBy(() -> LadderGame.init(null)).isInstanceOf(NullArgumentException.class);
    }

    @DisplayName("완성된 사다리 반환한다")
    @Test
    void result() {
        LadderGame ladderGame = LadderGame.init(LADDER_GAME_INIT_INFO_2_X_2);
        LadderResult ladderResult = ladderGame.result();

        assertThat(ladderResult.getNames()).isEqualTo(TWO_PLAYERS_NAMES);
        assertThat(ladderResult.getResults()).isEqualTo(TWO_RESULTS_VALUE);

        ladderResult.getRows()
                .forEach(rowDto -> assertThat(rowDto.getSteps()).isEqualTo(Arrays.asList(true, false)));
    }


    @DisplayName("사다리 타기 결과를 반환한다")
    @Test
    void match() {
        LadderGame ladderGame = LadderGame.init(LADDER_GAME_INIT_INFO_2_X_2);
        MatchResult matchResult = ladderGame.match();

        assertThat(matchResult.getPlayers()).containsAll(TWO_PLAYERS_NAMES);
        assertThat(matchResult.getPrize("nokc")).isEqualTo("500");
        assertThat(matchResult.getPrize("cha")).isEqualTo("꽝");
    }
}

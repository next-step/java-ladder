package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.dto.ResultDto;
import nextstep.ladder.domain.endpoint.Endpoints;
import nextstep.ladder.domain.exception.LadderGameInitializeException;
import nextstep.ladder.domain.player.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.player.Player.NAME_LENGTH_LIMIT;
import static nextstep.ladder.fixture.LadderFixture.*;
import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * LadderGame는 부속 클래스를 엮어주는 책임을 갖는다.
 */
class LadderGameTest {
    @Test
    @DisplayName("부속 클래스들이 생성한 결과를 반환한다.")
    void getGameResult() {
        LadderGame ladderGame = LadderGame.initialize(PLAYERS, HEIGHT_SIZE_FIXTURE, ENDPOINTS);
        ResultDto gameResult = ladderGame.getGameResult();

        assertAll(
                () -> Assertions.assertThat(gameResult.getNames()).filteredOn(name -> name.length() <= NAME_LENGTH_LIMIT),
                () -> Assertions.assertThat(gameResult.getRows().size()).isEqualTo(WIDTH_SIZE_FIXTURE)
        );
    }

    @Test
    @DisplayName("참가자의 수와 결과의 수가 다르다면 예외를 발생시킨다.")
    void initException() {
        Players players = Players.from("pobi,honux,crong,jk");
        Endpoints endpoints = Endpoints.from("꽝,5000,꽝");
        Assertions.assertThatThrownBy(() -> LadderGame.initialize(players, HEIGHT_SIZE_FIXTURE, endpoints))
                  .isInstanceOf(LadderGameInitializeException.class)
                  .hasMessage("참가자수와 결과개수가 다릅니다.");
    }
}

package nextstep.ladder.domain.laddar;

import nextstep.ladder.domain.dto.ResultDto;
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
        LadderGame ladderGame = LadderGame.of(PLAYERS, HEIGHT_SIZE_FIXTURE);
        ResultDto gameResult = ladderGame.getGameResult();

        assertAll(
                () -> Assertions.assertThat(gameResult.getNames())
                                .filteredOn(name -> name.length() <= NAME_LENGTH_LIMIT),

                () -> Assertions.assertThat(gameResult.getRows().size()).isEqualTo(WIDTH_SIZE_FIXTURE)
        );
    }
}

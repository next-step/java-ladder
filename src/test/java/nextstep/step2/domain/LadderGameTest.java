package nextstep.step2.domain;

import nextstep.step2.dto.GameInfoDto;
import nextstep.step2.dto.LadderInfoDto;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    @Test
    void createTest() {
        GameInfoDto gameInfoDto = GameInfoDto.of("miz,bi", "1000,꽝");
        LadderInfoDto ladderInfoDto = LadderInfoDto.of("miz,bi", "2");
        Ladder ladder = Ladder.of(ladderInfoDto, () -> true);

        assertThat(LadderGame.of(gameInfoDto, ladder)).isEqualTo(LadderGame.of(gameInfoDto, ladder));
    }
}

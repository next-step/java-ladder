package nextstep.step2.domain;

import nextstep.step2.dto.GameInfoDto;
import nextstep.step2.dto.LadderInfoDto;
import nextstep.step2.vo.Bridge;
import nextstep.step2.vo.Gift;
import nextstep.step2.vo.Lines;
import nextstep.step2.vo.Name;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        GameInfoDto gameInfoDto = GameInfoDto.of("miz,kiz,diz", "1000,2000,꽝");
        Lines lines = Lines.of(
                Arrays.asList(
                        Line.of(Arrays.asList(
                                Bridge.RIGHT, Bridge.LEFT, Bridge.DOWN
                        )),
                        Line.of(Arrays.asList(
                                Bridge.DOWN, Bridge.RIGHT, Bridge.LEFT
                        ))
                )
        );

        Ladder ladder = Ladder.of(lines);

        ladderGame = LadderGame.of(gameInfoDto, ladder);
    }

    @Test
    void createTest() {
        GameInfoDto gameInfoDto = GameInfoDto.of("miz,bi", "1000,꽝");
        LadderInfoDto ladderInfoDto = LadderInfoDto.of("miz,bi", "2");
        Ladder ladder = Ladder.of(ladderInfoDto, () -> true);

        assertThat(LadderGame.of(gameInfoDto, ladder)).isEqualTo(LadderGame.of(gameInfoDto, ladder));
    }

    /*
    |-| |
    | |-|
     */
    @DisplayName("playGame() 당첨 선물을 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"miz:꽝", "kiz:1000", "diz:2000"}, delimiter = ':')
    void playGameTest(String nameString, String giftString) {
        assertThat(ladderGame.playGame(Name.of(nameString))).isEqualTo(Gift.of(giftString));
    }

}

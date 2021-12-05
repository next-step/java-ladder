package nextstep.step2.domain;

import nextstep.step2.dto.GameInfoDto;
import nextstep.step2.dto.GameResult;
import nextstep.step2.dto.GameResults;
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
        GameInfoDto gameInfo = GameInfoDto.of("miz,kiz,diz", "1000,2000,꽝");
        Lines lines = Lines.from(
                Arrays.asList(
                        Line.from(Arrays.asList(
                                Bridge.RIGHT, Bridge.LEFT, Bridge.DOWN
                        )),
                        Line.from(Arrays.asList(
                                Bridge.DOWN, Bridge.RIGHT, Bridge.LEFT
                        ))
                )
        );

        Ladder ladder = Ladder.from(lines);

        ladderGame = LadderGame.ofWithGamInfoDtoAndLadder(gameInfo, ladder);
    }

    @Test
    void createTest() {
        GameInfoDto gameInfoDto = GameInfoDto.of("miz,kiz,diz", "1000,2000,꽝");
        LadderInfoDto ladderInfoDto = LadderInfoDto.of("miz,kiz,diz", "2");
        Ladder ladder = Ladder.ofWithLadderInfoAndStrategy(ladderInfoDto, () -> true);

        assertThat(LadderGame.ofWithGamInfoDtoAndLadder(gameInfoDto, ladder)).isEqualTo(LadderGame.ofWithGamInfoDtoAndLadder(gameInfoDto, ladder));
    }

    /*
    |-| |
    | |-|
     */
    @DisplayName("playGame() Game Result를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"miz:꽝", "kiz:1000", "diz:2000"}, delimiter = ':')
    void playGameTest(String nameString, String giftString) {
        assertThat(ladderGame.playGame(Name.from(nameString)))
                .isEqualTo(new GameResult(Name.from(nameString), Gift.from(giftString)));
    }

    /*
    |-| |
    | |-|
     */
    @DisplayName("playAllGame() 모든 게임 결과(GameResults)를 반환한다.")
    @Test
    void playAllGameTest() {
        GameResults expect = new GameResults(Arrays.asList(
                new GameResult(Name.from("miz"), Gift.from("꽝")),
                new GameResult(Name.from("kiz"), Gift.from("1000")),
                new GameResult(Name.from("diz"), Gift.from("2000"))
        ));


        assertThat(ladderGame.playAllGame()).isEqualTo(expect);
    }
}

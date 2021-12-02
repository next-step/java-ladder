package nextstep.step2.domain;

import nextstep.step2.dto.GameResult;
import nextstep.step2.dto.GameResults;
import nextstep.step2.dto.LadderInfoDto;
import nextstep.step2.vo.*;
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
        GameInfo gameInfo = GameInfo.of(Names.of("miz,kiz,diz"), Gifts.of("1000,2000,꽝"));
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

        ladderGame = LadderGame.of(gameInfo, ladder);
    }

    @Test
    void createTest() {
        GameInfo gameInfo = GameInfo.of(Names.of("miz,kiz,diz"), Gifts.of("1000,2000,꽝"));
        LadderInfoDto ladderInfoDto = LadderInfoDto.of("miz,kiz,diz", "2");
        Ladder ladder = Ladder.of(ladderInfoDto, () -> true);

        assertThat(LadderGame.of(gameInfo, ladder)).isEqualTo(LadderGame.of(gameInfo, ladder));
    }

    /*
    |-| |
    | |-|
     */
    @DisplayName("playGame() Game Result를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"miz:꽝", "kiz:1000", "diz:2000"}, delimiter = ':')
    void playGameTest(String nameString, String giftString) {
        assertThat(ladderGame.playGame(Name.of(nameString)))
                .isEqualTo(new GameResult(Name.of(nameString), Gift.of(giftString)));
    }

    /*
    |-| |
    | |-|
     */
    @DisplayName("playAllGame() 모든 게임 결과(GameResults)를 반환한다.")
    @Test
    void playAllGameTest() {
        GameResults expect = new GameResults(Arrays.asList(
                new GameResult(Name.of("miz"), Gift.of("꽝")),
                new GameResult(Name.of("kiz"), Gift.of("1000")),
                new GameResult(Name.of("diz"), Gift.of("2000"))
        ));


        assertThat(ladderGame.playAllGame()).isEqualTo(expect);
    }
}

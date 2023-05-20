package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameTest {

    private static final String USERNAMES = "kim,lian,lizzy,lego";
    private static final String RESULTS = "꽝,5000,꽝,3000";
    private static final int HEIGHT = 5;

    private LadderGame ladderGame;
    private Results results;

    @BeforeEach
    void setUp() {
        ladderGame = new LadderGame(USERNAMES, HEIGHT, new TestLinesGenerator());
        results = Results.toResults(RESULTS, HEIGHT);
    }

    @DisplayName("kim,lian,lizzy,lego 파라미터로 사다리 생성 시 사다리에 가로 길이는 4가 되야한다.")
    @Test
    void 사다리_가로_검증() {
        assertThat(ladderGame.ladderWidth()).isEqualTo(4);
    }

    @DisplayName("높이를 5로 사다리 생성 시 사다리에 높이는 5가 되야한다.")
    @Test
    void 사다리_높이_검증() {
        assertThat(ladderGame.ladderHeight()).isEqualTo(5);
    }

    @ParameterizedTest(name = "사다리 게임 실행 시 사용자별로 결과를 검증한다.")
    @CsvSource(value = {
            "kim|꽝",
            "lian|5000",
            "lizzy|3000",
            "lego|꽝",
    }, delimiter = '|')
    void 사다리_결과_검증(String userName, String result) {
        ladderGame.play();
        assertThat(results.reuslt(ladderGame.userCurrentPosition(userName))).isEqualTo(result);
    }

}
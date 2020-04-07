package nextstep.ladder.domain;

import nextstep.ladder.domain.exception.NoEqualLengthArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LadderGameTest {
    private Ladder ladder;
    private List<String> names;
    private List<String> prizes;
    private int height;

    @BeforeEach
    void setUp() {
        LineSelector lineSelector = (size) -> 1;
        RightDirection rightDirection = () -> true;
        ladder = Ladder.valueOf(new LadderSize(4, 5), lineSelector,
                rightDirection);

        names = Arrays.asList("boram", "rambo", "luv", "ram");
        prizes = Arrays.asList("꽝", "5000", "꽝", "3000");
        height = 5;
    }

    @DisplayName("사다리 게임을 생성한다.")
    @Test
    void create() {
        LadderGame ladderGame = new LadderGame(names, prizes, ladder);
        assertThat(ladderGame.getLadderHeight()).isEqualTo(height);
        assertThat(ladderGame.getParticipantNames().size())
                .isEqualTo(names.size());
    }

    @DisplayName("사다리 결과를 가져온다.")
    @Test
    void getResult() {
        LadderGame ladderGame = new LadderGame(names, prizes, ladder);
        assertThat(ladderGame.result("boram").getPrizeName()).isEqualTo("꽝");
    }

    @DisplayName("참여자 수와 경품 갯수가 맞지 않으면 에러")
    @Test
    void noEqualLengthError() {
        assertThatExceptionOfType(NoEqualLengthArgumentException.class).isThrownBy(() -> {
            List<String> prizes = Arrays.asList("꽝", "5000", "꽝");
            new LadderGame(names, prizes, ladder);
        });
    }

    @DisplayName("참여자를 조회한다.")
    @Test
    void getParticipant() {
        LadderGame ladderGame = new LadderGame(names, prizes, ladder);
        assertThat(ladderGame.getParticipantNames().size()).isEqualTo(4);
    }

    @DisplayName("경품을 조회한다")
    @Test
    void getPrize() {
        LadderGame ladderGame = new LadderGame(names, prizes, ladder);
        assertThat(ladderGame.getPrizeNames().size()).isEqualTo(4);
    }

    @DisplayName("결과가 맞는지 확인한다")
    @Test
    void checkResults() {
        LineSelector lineSelector = (size) -> 0;
        RightDirection rightDirection = () -> true;
        Ladder ladder = Ladder.valueOf(new LadderSize(2, 1), lineSelector,
                rightDirection);
        List<String> names = Arrays.asList("boram", "rambo");
        List<String> prizes = Arrays.asList("1", "2");
        LadderGame ladderGame = new LadderGame(names, prizes, ladder);
        List<LadderGameResult> ladderGameResults = ladderGame.resultAll();
        LadderGameResult  firstResult= ladderGameResults.get(0);
        assertThat(firstResult.getParticipantName()).isEqualTo("boram");
        assertThat(firstResult.getPrizeName()).isEqualTo("2");
    }
}

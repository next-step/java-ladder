package nextstep.ladder.domain.game;

import nextstep.ladder.domain.game.exception.NoEqualLengthArgumentException;
import nextstep.ladder.domain.line.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
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
        ladder = new Ladder(new LadderSize(4, 5));

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

    @DisplayName("참여자 수와 경품 갯수가 맞지 않으면 에러")
    @Test
    void noEqualLengthError() {
        assertThatExceptionOfType(NoEqualLengthArgumentException.class)
                .isThrownBy(() -> {
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

    @DisplayName("사다리 결과를 가져온다.")
    @Test
    void getResult() {
        List<String> names = Arrays.asList("boram", "rambo");
        List<String> prizes = Arrays.asList("1", "2");
        LadderGame ladderGame = new LadderGame(names, prizes, getFixedLadder());
        assertThat(ladderGame.getResult("boram").getPrizeName()).isEqualTo("2");
    }

    @DisplayName("결과가 맞는지 확인한다")
    @Test
    void checkResults() {
        List<String> names = Arrays.asList("boram", "rambo");
        List<String> prizes = Arrays.asList("1", "2");
        LadderGame ladderGame = new LadderGame(names, prizes, getFixedLadder());
        List<LadderGameResult> ladderGameResults = ladderGame.getResultAll();
        LadderGameResult firstResult = ladderGameResults.get(0);
        assertThat(firstResult.getParticipantName()).isEqualTo("boram");
        assertThat(firstResult.getPrizeName()).isEqualTo("2");
    }

    private Ladder getFixedLadder() {
        DirectionSelector directionSelector = () -> true;
        Direction first = Direction.getFirst(directionSelector);
        List<Point> points = Arrays.asList(
                new Point(0, first),
                new Point(1, first.getLast())
        );
        List<LadderLine> ladderLines =
                Collections.singletonList(new LadderLine(points));
        return new Ladder(ladderLines);
    }
}

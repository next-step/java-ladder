package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private Participants participants;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        participants = new Participants("AOA,TWICE,GD");
        List<Point> points = List.of(
                new Point(false, true),
                new Point(true, false),
                new Point(false, false));
        Line line = new Line(points);
        ladder = new Ladder(List.of(line));
    }

    @Test
    void 사다리게임_결과_반환() {
        LadderGame game = new LadderGame(participants, ladder);
        GameResult gameResult = game.play(List.of("꽝", "5000", "꽝"));
        assertThat(gameResult.findResultByName("AOA")).isEqualTo("5000");
        assertThat(gameResult.findResultByName("TWICE")).isEqualTo("꽝");
        assertThat(gameResult.findResultByName("GD")).isEqualTo("꽝");
    }
}

package nextstep.step4.impl;

import nextstep.step4.engine.LadderResult;
import nextstep.step4.engine.Participants;
import nextstep.step4.engine.Results;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SimpsonLadderTest {
    @Test
    void playTest() {

        final SimpsonLine simpsonLine1 = new SimpsonLine(Arrays.asList(Point.first(true), Point.first(true).last()));
        final SimpsonLine simpsonLine2 = new SimpsonLine(Arrays.asList(Point.first(false), Point.first(false).next(false)));
        final SimpsonLadder simpsonLadder = new SimpsonLadder(Arrays.asList(simpsonLine1, simpsonLine2), 2);

        final Participants participants = new Participants(new String[]{"aa", "bb"});
        final Results results = new Results(new String[]{"1", "2"});
        final LadderResult ladderResult = simpsonLadder.play(participants, results);

        assertThat(ladderResult.result("aa")).isEqualTo("aa : 2" + "\n");
    }
}
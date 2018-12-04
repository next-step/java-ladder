package net.chandol.ladder.v2.domain;

import net.chandol.ladder.v2.domain.line.Line;
import net.chandol.ladder.v2.domain.line.LinesGenerator;
import net.chandol.ladder.v2.domain.line.ManualLinesGenerator;
import net.chandol.ladder.v2.domain.player.Players;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 사다리만들기() {
        Ladder ladder = createDefaultLadder();
        assertThat(ladder.hasPoint(0, 0)).isTrue();
        assertThat(ladder.hasPoint(1, 0)).isFalse();
    }

    public Ladder createDefaultLadder(){
        Players players = Players.of("aaa", "bbb");
        LinesGenerator linesGenerator = new ManualLinesGenerator(
                Line.of(true, false),
                Line.of(false, false)
        );

        return new Ladder(players, 2, linesGenerator);
    }

}
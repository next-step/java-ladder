package nextstep.ladder.domain;

import java.util.List;

import nextstep.ladder.engine.LadderFrame;
import nextstep.ladder.engine.LadderRails;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.LadderHeightTest.h;
import static nextstep.ladder.domain.LadderPlayersTest.ps;
import static nextstep.ladder.domain.LadderPrizesTest.pzs;
import static nextstep.ladder.domain.Step4LadderRailsTest.lrs;
import static nextstep.ladder.domain.Step4LadderRailsTest.simpleRails;
import static org.assertj.core.api.Assertions.assertThat;

public class Step4LadderFrameTest {
    @Test
    public void create() {
        final LadderRails rails = lrs(List.of("p1", "p2"), List.of("r2", "r3"));
        final int height = 4;
        assertThat(Step4LadderFrame.of(rails, height)).isEqualTo(Step4LadderFrame.of(rails, height));
    }

    @Test
    public void asLadderRails() {
        final List<String> players = List.of("p1", "p2");
        final List<String> prizes = List.of("r2", "r3");
        final LadderRails rails = lrs(players, prizes);
        final int height = 4;
        assertThat(Step4LadderFrame.of(rails, height).players()).isEqualTo(ps(players));
        assertThat(Step4LadderFrame.of(rails, height).prizes()).isEqualTo(pzs(prizes));
        assertThat(Step4LadderFrame.of(rails, height).railCount()).isEqualTo(LadderRailCount.of(players.size()));
    }

    @Test
    public void height() {
        final LadderRails rails = lrs(List.of("p1", "p2"), List.of("r2", "r3"));
        final int height = 4;
        assertThat(Step4LadderFrame.of(rails, height).height()).isEqualTo(h(height));

    }

    public static LadderFrame lf(List<String> players, List<String> prizes, int height) {
        return Step4LadderFrame.of(lrs(players, prizes), height);
    }

    public static LadderFrame lf(LadderRails rails, int height) {
        return Step4LadderFrame.of(rails, height);
    }

    public static LadderFrame simpleFrame = lf(simpleRails, 5);
}

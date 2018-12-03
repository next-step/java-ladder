package net.chandol.ladder.v2.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 사다리만들기() {
        Ladder ladder = createDefaultLadder();
        assertThat(ladder.hasPoint(0, 0)).isTrue();
        assertThat(ladder.hasPoint(1, 0)).isFalse();
    }

    @Test
    public void 컬럼문자열생성하기() {
        Ladder ladder = createDefaultLadder();

        Assertions.assertThat(ladder.createColumnString(0)).isEqualTo("  |-----|     ");
        Assertions.assertThat(ladder.createColumnString(1)).isEqualTo("  |     |     ");
    }

    @Test
    public void 사다리문자열생성하기() {
        Ladder ladder = createDefaultLadder();

        Assertions.assertThat(ladder.createLadderString()).containsExactly("  |-----|     ", "  |     |     ");
    }


    @Test
    public void 플레이어문자열확인() {
        Ladder ladder = createDefaultLadder();
        Assertions.assertThat(ladder.createPlayersString()).isEqualTo(" aaa   bbb ");
    }

    public Ladder createDefaultLadder(){
        List<String> players = asList("aaa", "bbb");
        LinesGenerator linesGenerator = new ManualLinesGenerator(
                Line.of(true, false),
                Line.of(false, false)
        );

        return new Ladder(players, 2, linesGenerator);
    }

}
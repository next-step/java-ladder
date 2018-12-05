package net.chandol.ladder.v2.domain;

import net.chandol.ladder.v2.domain.line.Line;
import net.chandol.ladder.v2.domain.line.LinesGenerator;
import net.chandol.ladder.v2.domain.line.ManualLinesGenerator;
import net.chandol.ladder.v2.domain.player.Players;
import net.chandol.ladder.v2.domain.prize.Prize;
import net.chandol.ladder.v2.domain.prize.Prizes;
import net.chandol.ladder.v2.dto.LadderGameResult;
import net.chandol.ladder.v2.dto.LadderInitializeRequest;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 사다리만들기() {
        Ladder ladder = createDefaultLadder();
        assertThat(ladder.hasPoint(0, 0)).isTrue();
        assertThat(ladder.hasPoint(1, 0)).isFalse();
    }

    @Test
    public void 결과_확인하기(){
        Ladder ladder = createDefaultLadder();
        LadderGameResult gameResult = ladder.createGameResult();

        Prize prize = gameResult.findPrize("aaa");
        assertThat(prize).isEqualTo(Prize.prize("5000"));
    }

    public Ladder createDefaultLadder(){
        Players players = Players.of("aaa", "bbb");
        Prizes prizes = Prizes.of("꽝", "5000");
        LinesGenerator linesGenerator = new ManualLinesGenerator(
                Line.of(true, false),
                Line.of(false, false)
        );

        LadderInitializeRequest request = new LadderInitializeRequest(players, prizes, 2);

        return new Ladder(request, linesGenerator);
    }



}
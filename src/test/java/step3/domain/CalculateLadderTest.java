package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculateLadderTest {

    @DisplayName("사다리 1개 = 1인 플레이")
    @Test
    void calculteSinglePlay() {
        // set
        Ladders ladders = new Ladders();
        List<Ladder> laddersToSet = new ArrayList<>();
        // add
        laddersToSet.add(new Ladder(4, false));
        ladders.setLadderList(laddersToSet);
        // calc
        CalculateLadder calculateLadder = new CalculateLadder(ladders);
        int[] result = calculateLadder.calculte();
        System.out.println(Arrays.toString(result));
        assertThat(result.length).isEqualTo(1);
    }

    @DisplayName("멀티플레이어")
    @Test
    void calculteMultiPlay() {
        // set
        Ladders ladders = new Ladders();
        List<Ladder> laddersToSet = new ArrayList<>();
        Players players = new Players(Arrays.asList(
                new Player("a"),
                new Player("b"),
                new Player("c")));

        WinningPrizes winningPrizes = new WinningPrizes(
                Arrays.asList("1등", "2등", "3등"));
        // add
        LadderGame ladderGame = LadderGame.createLadder(players, winningPrizes, 4);
        ladders.setLadders(4, ladderGame,players);

        // calc
        CalculateLadder calculateLadder = new CalculateLadder(ladders);
        int[] result = calculateLadder.calculte();
        System.out.println(Arrays.toString(result));
        assertThat(result.length).isEqualTo(3);

    }


    @Test
    void calculateWinningPrizeLine() {

        // set
        Ladders ladders = new Ladders();
        List<Ladder> laddersToSet = new ArrayList<>();
        Players players = new Players(Arrays.asList(
                new Player("a"),
                new Player("b"),
                new Player("c")));
        WinningPrizes winningPrizes = new WinningPrizes(
                Arrays.asList("1등", "2등", "3등"));
        // add
        LadderGame ladderGame = LadderGame.createLadder(players, winningPrizes, 4);
        ladders.setLadders(4, ladderGame,players);
        CalculateLadder calculateLadder = new CalculateLadder(ladders);
        // calc
        String[] winningPrize = calculateLadder.calculateWinningPrizeLine(winningPrizes);
        assertThat(winningPrize.length).isEqualTo(3);
        assertThat(Arrays.stream(winningPrize).filter(x -> x.equals(winningPrizes.get(0))).count()).isEqualTo(1);
        assertThat(Arrays.stream(winningPrize).filter(x -> x.equals(winningPrizes.get(1))).count()).isEqualTo(1);
        assertThat(Arrays.stream(winningPrize).filter(x -> x.equals(winningPrizes.get(2))).count()).isEqualTo(1);

    }
}

package domain.game;

import domain.ladder.Ladders;
import domain.player.Players;
import domain.prize.Prizes;
import generator.bool.impl.ProbabilityBasedGenerator;
import generator.ladder.LaddersGenerator;
import generator.ladder.impl.RandomLineLaddersGenerator;
import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameBoardTest {

    LaddersGenerator laddersGenerator;

    @Before
    public void setup() {
        laddersGenerator = new RandomLineLaddersGenerator(new ProbabilityBasedGenerator(100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_플레이어와_경품사다리의_갯수가_다름() {
        Players players = Players.generate("pobi, honux, crong, jk");
        Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        Ladders ladders = laddersGenerator.generate(5, 2);
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(ladders, prizes);

        new LadderGameBoard(players, laddersAndPrizes);
    }

    @Test
    public void test_개별_추첨_결과_높이1() {
        // pobi  honux crong   jk
        //    |-----|     |-----|
        // 꽝    5000  꽝    3000
        Players players = Players.generate("pobi, honux, crong, jk");
        Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        Ladders ladders = laddersGenerator.generate(1, 4);
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(ladders, prizes);

        LadderGameBoard board = new LadderGameBoard(players, laddersAndPrizes);

        assertThat(board.raffle("pobi"))
                .isEqualTo(Prizes.generate("5000"));
        assertThat(board.raffle("honux"))
                .isEqualTo(Prizes.generate("꽝"));
        assertThat(board.raffle("crong"))
                .isEqualTo(Prizes.generate("3000"));
        assertThat(board.raffle("jk"))
                .isEqualTo(Prizes.generate("꽝"));
    }

    @Test
    public void test_개별_추첨_결과_높이2() {
        // pobi  honux crong   jk
        //    |-----|     |-----|
        //    |-----|     |-----|
        // 꽝    5000  꽝    3000
        Players players = Players.generate("pobi, honux, crong, jk");
        Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        Ladders ladders = laddersGenerator.generate(2, 4);

        LadderGameBoard board = new LadderGameBoard(players, new LaddersAndPrizes(ladders, prizes));

        assertThat(board.raffle("pobi"))
                .isEqualTo(Prizes.generate("꽝"));
        assertThat(board.raffle("honux"))
                .isEqualTo(Prizes.generate("5000"));
        assertThat(board.raffle("crong"))
                .isEqualTo(Prizes.generate("꽝"));
        assertThat(board.raffle("jk"))
                .isEqualTo(Prizes.generate("3000"));
    }

    @Test
    public void test_전체_추첨_결과_높이1() {
        // pobi  honux crong   jk
        //    |-----|     |-----|
        // 꽝    5000  꽝    3000
        Players players = Players.generate("pobi, honux, crong, jk");
        Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        Ladders ladders = laddersGenerator.generate(1, 4);
        LadderGameBoard board = new LadderGameBoard(players, new LaddersAndPrizes(ladders, prizes));

        assertThat(board.raffle("all"))
                .isEqualTo(Prizes.generate("5000, 꽝, 3000, 꽝"));
    }
}

package domain.game;

import domain.player.Players;
import domain.prize.Prizes;
import generator.ladder.LaddersGenerator;
import generator.ladder.impl.FixingLineLaddersGenerator;
import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameBoardTest {

    LaddersGenerator laddersGenerator;
    Players players;
    Prizes prizes;

    @Before
    public void setup() {
        laddersGenerator = new FixingLineLaddersGenerator();
        players = Players.generate("pobi, honux, crong, jk");
        prizes = Prizes.generate("꽝,5000,꽝,3000");
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_플레이어와_경품의_갯수가_다름() {
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(laddersGenerator, 1, Prizes.generate("꽝"));
        new LadderGameBoard(players, laddersAndPrizes);
    }

    @Test
    public void test_개별_추첨_결과_높이1() {
        // pobi  honux crong   jk
        //    |-----|     |-----|
        // 꽝    5000  꽝    3000
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(laddersGenerator, 1, prizes);
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
        LadderGameBoard board = new LadderGameBoard(players, new LaddersAndPrizes(laddersGenerator, 2, prizes));

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
        LadderGameBoard board = new LadderGameBoard(players, new LaddersAndPrizes(laddersGenerator, 1, prizes));

        assertThat(board.raffle("all"))
                .isEqualTo(Prizes.generate("5000, 꽝, 3000, 꽝"));
    }
}

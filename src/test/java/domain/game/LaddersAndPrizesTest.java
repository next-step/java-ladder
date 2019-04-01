package domain.game;

import domain.prize.Prizes;
import generator.ladder.LaddersGenerator;
import generator.ladder.impl.FixingLineLaddersGenerator;
import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LaddersAndPrizesTest {

    LaddersGenerator laddersGenerator;

    @Before
    public void setup() {
        laddersGenerator = new FixingLineLaddersGenerator();
    }

    @Test
    public void test_크기() {
        final Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(5, prizes);
        assertThat(laddersAndPrizes.size())
                .isEqualTo(4);
    }

    @Test
    public void test_사다리와_경품_출력() {
        final Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(laddersGenerator, 5, prizes);
        assertThat(laddersAndPrizes.beautify())
                .isEqualTo(
                    "    |-----|     |-----|\n" +
                    "    |-----|     |-----|\n" +
                    "    |-----|     |-----|\n" +
                    "    |-----|     |-----|\n" +
                    "    |-----|     |-----|\n" +
                    "    꽝  5000     꽝  3000"
                );
    }

    @Test
    public void test_개별_추첨_결과_높이1() {
        final Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        //    |-----|     |-----|
        // 꽝    5000  꽝    3000
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(laddersGenerator, 1, prizes);

        assertThat(laddersAndPrizes.raffle(0))
                .isEqualTo(Prizes.generate("5000"));
        assertThat(laddersAndPrizes.raffle(1))
                .isEqualTo(Prizes.generate("꽝"));
        assertThat(laddersAndPrizes.raffle(2))
                .isEqualTo(Prizes.generate("3000"));
        assertThat(laddersAndPrizes.raffle(3))
                .isEqualTo(Prizes.generate("꽝"));
    }

    @Test
    public void test_개별_추첨_결과_높이2() {
        final Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        //    |-----|     |-----|
        //    |-----|     |-----|
        // 꽝    5000  꽝    3000
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(laddersGenerator, 2, prizes);

        assertThat(laddersAndPrizes.raffle(0))
                .isEqualTo(Prizes.generate("꽝"));
        assertThat(laddersAndPrizes.raffle(1))
                .isEqualTo(Prizes.generate("5000"));
        assertThat(laddersAndPrizes.raffle(2))
                .isEqualTo(Prizes.generate("꽝"));
        assertThat(laddersAndPrizes.raffle(3))
                .isEqualTo(Prizes.generate("3000"));
    }

    @Test
    public void test_전체_추첨_결과_높이1() {
        final Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        //    |-----|     |-----|
        // 꽝    5000  꽝    3000
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(laddersGenerator, 1, prizes);

        assertThat(laddersAndPrizes.raffle(0, 1, 2, 3))
                .isEqualTo(Prizes.generate("5000,꽝,3000,꽝"));
    }
}
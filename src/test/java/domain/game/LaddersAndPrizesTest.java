package domain.game;

import domain.ladder.Ladders;
import domain.prize.Prizes;
import generator.ladders.LaddersGenerator;
import generator.ladders.impl.ProbabilityBasedLineGenerator;
import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LaddersAndPrizesTest {

    LaddersGenerator laddersGenerator;

    @Before
    public void setup() {
        laddersGenerator = new ProbabilityBasedLineGenerator(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_생성실패_사다리와_경품의_넓이가_다름() {
        final Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        final Ladders ladders = laddersGenerator.generate(5, 5);

        new LaddersAndPrizes(ladders, prizes);
    }

    @Test
    public void test_크기() {
        final Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        final Ladders ladders = laddersGenerator.generate(5, prizes.size());
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(ladders, prizes);

        assertThat(laddersAndPrizes.lineSize())
                .isEqualTo(4);
    }

    @Test
    public void test_사다리와_경품_출력() {
        final Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        final Ladders ladders = laddersGenerator.generate(5, prizes.size());
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(ladders, prizes);

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
        //    |-----|     |-----|
        // 꽝    5000  꽝    3000
        final Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        final Ladders ladders = laddersGenerator.generate(1, prizes.size());
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(ladders, prizes);

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
        //    |-----|     |-----|
        //    |-----|     |-----|
        // 꽝    5000  꽝    3000
        final Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        final Ladders ladders = laddersGenerator.generate(2, prizes.size());
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(ladders, prizes);

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
        //    |-----|     |-----|
        // 꽝    5000  꽝    3000
        final Prizes prizes = Prizes.generate("꽝,5000,꽝,3000");
        final Ladders ladders = laddersGenerator.generate(1, prizes.size());
        LaddersAndPrizes laddersAndPrizes = new LaddersAndPrizes(ladders, prizes);

        assertThat(laddersAndPrizes.raffle(0, 1, 2, 3))
                .isEqualTo(Prizes.generate("5000,꽝,3000,꽝"));
    }
}
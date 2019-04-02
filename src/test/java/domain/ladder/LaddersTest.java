package domain.ladder;

import generator.ladders.LaddersGenerator;
import generator.ladders.impl.ProbabilityBasedLineGenerator;
import org.junit.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LaddersTest {

    LaddersGenerator laddersGenerator;

    @Before
    public void setup() {
        laddersGenerator = new ProbabilityBasedLineGenerator(100);
    }

    @Test
    public void test_크기() {
        //    |-----|     |-----|
        Ladders ladders = laddersGenerator.generate(1, 4);
        assertThat(ladders.lineSize())
                .isEqualTo(4);
    }

    @Test
    public void test_개별_이동_결과_높이1() {
        //    |-----|     |-----|
        Ladders ladders = laddersGenerator.generate(1, 4);

        assertThat(ladders.move(0))
                .isEqualTo(1);
        assertThat(ladders.move(1))
                .isEqualTo(0);
        assertThat(ladders.move(2))
                .isEqualTo(3);
        assertThat(ladders.move(3))
                .isEqualTo(2);
    }

    @Test
    public void test_전체_이동_결과_높이1() {
        //    |-----|     |-----|
        Ladders ladders = laddersGenerator.generate(1, 4);
        assertThat(ladders.move(0, 1, 2, 3))
                .isEqualTo(Arrays.asList(1, 0, 3, 2));
    }

    @Test
    public void test_개별_이동_결과_높이2() {
        //    |-----|     |-----|
        //    |-----|     |-----|
        Ladders ladders = laddersGenerator.generate(2, 4);
        assertThat(ladders.move(0))
                .isEqualTo(0);
        assertThat(ladders.move(1))
                .isEqualTo(1);
        assertThat(ladders.move(2))
                .isEqualTo(2);
        assertThat(ladders.move(3))
                .isEqualTo(3);
    }

    @Test
    public void test_전체_이동_결과_높이2() {
        //    |-----|     |-----|
        //    |-----|     |-----|
        Ladders ladders = laddersGenerator.generate(2, 4);
        assertThat(ladders.move(0, 1, 2, 3))
                .isEqualTo(Arrays.asList(0, 1, 2, 3));
    }

    @Test
    public void test_사다리_출력() {
        Ladders ladders = laddersGenerator.generate(2, 8);

        assertThat(ladders.beautify())
                .isEqualTo("    |-----|     |-----|     |-----|     |-----|\n"+
                           "    |-----|     |-----|     |-----|     |-----|");
    }
}

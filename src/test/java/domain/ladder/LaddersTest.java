package domain;

import generator.ladder.LaddersGenerator;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LaddersTest {
    @Test(expected = UnsupportedOperationException.class)
    public void test_변경불가() {
        Ladders ladders = new Ladders(new ArrayList<>(Arrays.asList()));
        ladders.getLadders().remove(0);
    }

    @Test
    public void test_이동_결과_확인() {
        LaddersGenerator laddersGenerator = (height, size) ->
                new Ladders(IntStream.range(0, height)
                        .mapToObj(i -> new Ladder(size, () -> true))
                        .collect(Collectors.toList()));

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
}

package step2.study;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {

    @Test
    public void randomTest() {
        Random random = new Random();
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            integers.add(random.nextInt(2));
        }

        assertThat(integers).contains(0, 1);
    }
}

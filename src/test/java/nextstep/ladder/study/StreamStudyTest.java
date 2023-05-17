package nextstep.ladder.study;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StreamStudyTest {

    @Test
    void generate() {
        List<Integer> collect = Stream.generate(() -> (int) (Math.random() * 100))
                .distinct()
                .limit(10)
                .sorted()
                .collect(Collectors.toList());

        assertThat(collect.size()).isEqualTo(10);
    }
}

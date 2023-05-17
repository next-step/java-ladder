package nextstep.ladder.study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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

    @Test
    void unmodifiableList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> unmodifiableList = list.stream().collect(Collectors.toUnmodifiableList());

        assertThatThrownBy(() -> unmodifiableList.add(1))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}

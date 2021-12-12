package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LineTest {

    @Test
    @DisplayName("마지막 줄의 값을 찾는다.")
    public void findLastLine() {
        List<Integer> list = IntStream.range(0, 2).boxed().collect(Collectors.toList());
        assertThat(Line.beforeLine(list)).isEqualTo(1);
    }
}

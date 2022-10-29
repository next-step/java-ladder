package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @DisplayName("생성할 때")
    @Nested
    class Create {

        @DisplayName("전락과 높이를 받아 생성할 수 있다.")
        @Test
        void of() {
            Line expected = new Line(
                    IntStream.range(0, 3)
                            .mapToObj(index -> new Stick(true))
                            .collect(Collectors.toList())
            );

            Line actual = Line.of(new LadderHeight(3), () -> true);

            assertThat(actual).isEqualTo(expected);
        }
    }
}

package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    void 사다리_높이_너비_생성() {
        Ladder actual = Ladder.of(5, 3);
        assertAll(
            () -> assertThat(actual.height()).isEqualTo(5),
            () -> assertThat(actual.width()).isEqualTo(3)
        );
    }

    @Test
    void 사다리생성_널_빈값() {
        assertAll(
            () -> assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Ladder.of(null))
                .withMessageMatching("사다리는 빈 값일 수 없습니다."),
            () -> assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Ladder.of(List.of()))
                .withMessageMatching("사다리는 빈 값일 수 없습니다.")
        );
    }

    @Test
    void 사다리생성() {
        Line line = Line.of(size -> IntStream.range(0, size).mapToObj(x -> Boolean.FALSE).collect(Collectors.toList())
            ,2);
        assertAll(
            () -> assertThat(Ladder.of(List.of(line, line))).isEqualTo(Ladder.of(List.of(line, line))),
            () -> assertThat(Ladder.of(List.of(line, line)).height()).isEqualTo(2)
        );
    }

}

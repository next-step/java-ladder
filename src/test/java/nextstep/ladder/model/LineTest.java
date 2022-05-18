package nextstep.ladder.model;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    void create() {
        int length = 10;
        String line = IntStream
                .range(0, length)
                .mapToObj(i -> "|")
                .reduce((prev, next) -> String.join(System.lineSeparator(), prev, next))
                .orElseThrow();

        assertThat(Line.create(length).draw()).isEqualTo(line);
    }
}

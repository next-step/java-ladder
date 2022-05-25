package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    void sizeReturn5() {
        assertThat(
                new Players(Stream.iterate(0, i -> i + 1)
                        .map(i -> new Player(i + ""))
                        .limit(5)
                        .collect(Collectors.toList()))
                        .size()
        ).isEqualTo(5);
    }
}

package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {
    @Test
    void ofTest() {
        assertThat(GameResults.of("a,b,c,d,e").get(2)).isEqualTo("c");
    }
}

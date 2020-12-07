package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultsTest {
    @Test
    @DisplayName("스태틱 팩터리 메서드 테스트")
    void ofTest() {
        assertThat(GameResults.of("a,b,c,d,e").get(2)).isEqualTo("c");
    }
}

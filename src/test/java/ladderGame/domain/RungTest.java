package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 계단")
class RungTest {

    @Test
    @DisplayName("라인 생성")
    public void create() {
        Rung rung = Rung.of(true);
        assertThat(rung.value()).isTrue();
    }

    @Test
    @DisplayName("빈라인 생성")
    public void createEmpty() {
        Rung rung = Rung.of(false);
        assertThat(rung.value()).isFalse();
    }

}
package ladderGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 계단")
class RungTest {

    @Test
    @DisplayName("라인 생성")
    public void create() {
        Rung rung = Rung.newDrawLine();
        assertThat(rung.value()).isTrue();
    }

    @Test
    @DisplayName("빈라인 생성")
    public void createEmpty() {
        Rung rung = Rung.newEmptyLine();
        assertThat(rung.value()).isFalse();
    }

    @Test
    @DisplayName("계단 생성 확인")
    public void hasRung() {
        Rung rung = Rung.newEmptyLine();
        assertThat(rung.isEmpty()).isTrue();
    }
}
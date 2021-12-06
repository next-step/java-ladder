package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RungTest {

    @DisplayName("Rung은 LadderPart의 구현체")
    @Test
    void create() {
        assertThat(Rung.rung()).isInstanceOf(LadderPart.class);
        assertThat(Rung.emptyRung()).isInstanceOf(LadderPart.class);
    }

    @DisplayName("생성메서드 Rung.rung() 확인")
    @Test
    void rung() {
        assertThat(Rung.rung().value()).isEqualTo("-----");
    }

    @DisplayName("생성메서드 Rung.emptyRung() 확인")
    @Test
    void emptyRung() {
        assertThat(Rung.emptyRung().value()).isEqualTo("     ");
    }

}

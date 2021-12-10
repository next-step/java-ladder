package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RungTest {

    @DisplayName("Rung은 LadderPart의 구현체")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void create(boolean isSet) {
        Assertions.assertThat(Rung.from(isSet)).isInstanceOf(LadderPart.class);
    }

    @DisplayName("생성메서드 Rung.rung(true) 확인")
    @Test
    void rung() {
        assertThat(Rung.from(true).value()).isEqualTo("-----");
    }

    @DisplayName("생성메서드 Rung.rung(false) 확인")
    @Test
    void emptyRung() {
        assertThat(Rung.from(false).value()).isEqualTo("     ");
    }

    @DisplayName("emptyRung, Rung == 확인")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void same(boolean isSet) {
        assertThat(Rung.from(isSet) == Rung.from(isSet)).isTrue();
    }

}

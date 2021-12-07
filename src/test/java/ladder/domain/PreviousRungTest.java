package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PreviousRungTest {

    private final PreviousRung previousRung = PreviousRung.of(false);

    @DisplayName("기본 생성은 이전 Rung은 isSet false")
    @Test
    void create() {
        assertThat(previousRung.isSet()).isFalse();
    }

    @DisplayName("LadderPart가 Rung. 해당 Rung에 따라 isSet이 다름.")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void changeRung_rung(boolean isSet) {
        PreviousRung changedRung = previousRung.changedRung(Rung.rung(isSet));

        assertThat(changedRung.isSet()).isEqualTo(isSet);
    }

    @DisplayName("LadderPart가 null")
    @Test
    void changeRung_rail() {
        PreviousRung changedRung = previousRung.changedRung(Rail.rail());

        assertThat(changedRung.isSet()).isFalse();
    }

    @DisplayName("LadderPart가 null")
    @Test
    void changeRung_null() {
        PreviousRung changedRung = previousRung.changedRung(null);

        assertThat(changedRung.isSet()).isFalse();
    }

    @DisplayName("캐싱 확인")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void cash(boolean set) {
        assertThat(PreviousRung.of(set) == PreviousRung.of(set)).isTrue();
    }

    @DisplayName("isSet 확인")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void isSet(boolean set) {
        assertThat(PreviousRung.of(set).isSet()).isEqualTo(set);
    }

}

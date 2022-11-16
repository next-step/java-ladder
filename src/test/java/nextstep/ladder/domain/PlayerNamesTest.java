package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class PlayerNamesTest {

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmpty(final List<PlayerName> names) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new PlayerNames(names));
    }

    @Test
    void tooFewNames() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new PlayerNames(Collections.singletonList(PlayerName.valueOf("foo"))));
    }

    @Test
    void duplicatedNames() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> new PlayerNames(List.of(PlayerName.valueOf("foo"), PlayerName.valueOf("foo"))));
    }

    @Test
    void validNames() {
        assertThatCode(() -> new PlayerNames(List.of(PlayerName.valueOf("foo"), PlayerName.valueOf("bar"))))
            .doesNotThrowAnyException();
    }


}
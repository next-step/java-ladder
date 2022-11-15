package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @DisplayName("높이는 1 이상이어야 한다.")
    @Test
    public void spec01() {
        Assertions.assertAll(
                () -> assertThatIllegalArgumentException().isThrownBy(() -> new Height(0)),
                () -> assertThatNoException().isThrownBy(() -> new Height(10))
        );
    }

    @DisplayName("높이는 조회 가능하다.")
    @ParameterizedTest
    @ValueSource(ints =  { 1, 3, 7, 11})
    public void spec02(final int height) {
        assertThat(new Height(height).height()).isEqualTo(height);
    }
}

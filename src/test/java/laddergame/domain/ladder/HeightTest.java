package laddergame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class HeightTest {
    @DisplayName("높이가 1 보다 작으면 IllegalArgumentException Throw")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void validateHeight(int height) {
        assertThatThrownBy(() -> new Height(height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이는 1 이상이어야 합니다. - " + height);
    }
}
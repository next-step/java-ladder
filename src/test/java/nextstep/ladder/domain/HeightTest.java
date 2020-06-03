package nextstep.ladder.domain;

import nextstep.ladder.exception.InputValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {
    
    private Height height = Height.newInstance(5);
    
    @DisplayName("높이가 1보다 작으면 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = { 0, -1 })
    void canNotCreateHeightIfLessThan1Height(int height) {
        assertThatThrownBy(() -> Height.newInstance(height))
                .isInstanceOf(InputValueException.class);
    }

    @DisplayName("높이를 생성할 수 있다.")
    @Test
    void canCreateHeight() {
        assertThat(this.height).isInstanceOf(Height.class);
    }

    @DisplayName("높이를 얻을 수 있다.")
    @Test
    void canGetHeight() {
        assertThat(this.height.getHeight()).isEqualTo(5);
    }

    @DisplayName("높이가 같으면 같은 객체이다.")
    @Test
    void canSameHeight() {
        Height sameHeight = Height.newInstance(this.height.getHeight());

        assertThat(this.height.getHeight()).isEqualTo(sameHeight.getHeight());
        assertThat(this.height).isEqualTo(sameHeight);
        assertThat(this.height.hashCode()).isEqualTo(sameHeight.hashCode());
    }
}

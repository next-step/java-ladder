package nextstep.ladder.module;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    @DisplayName("높이가 1 보다 작으면 에러")
    void givenHeightLessThanOne_whenCreateHeight_thenThrowException() {
        assertThatThrownBy(() -> new Height(0)).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("높이는 1 이상이어야 합니다.");
    }

    @Test
    @DisplayName("높이가 1 과 같거나 크면 통과")
    void givenHeightGreaterThanOrEqualToOne_whenCreateHeight_thenPass() {
        assertThat(new Height(1).value()).isEqualTo(1);
    }

}

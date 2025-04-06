package nextstep.ladder.module;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PointXTest {

    @Test
    @DisplayName("x가 0 미만이면 에러")
    void givenXLessThanZero_whenCreatePointX_thenThrowException() {
        assertThatThrownBy(() -> new PointX(-1, new Ladder())).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("x는 0 이상이어야 합니다.");
    }
    
    @Test
    @DisplayName("x가 0 이상이면 통과")
    void givenXGreaterThanOrEqualToZero_whenCreatePointX_thenPass() {
        assertThat(new PointX(0, new Ladder()).value()).isEqualTo(0);
    }
        
}

package nextstep.ladder.model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class HeightTest {
    
    @Test
    @DisplayName("높이 생성 테스트")
    void createHeight() {
        Height height = new Height(5);
        assertThat(height.getValue()).isEqualTo(5);
    }
    
    @Test
    @DisplayName("0 또는 음수 높이 생성 시 예외 발생 테스트")
    void createZeroOrNegativeHeight() {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Height(0))
            .withMessageContaining("높이는 양수여야 합니다");
            
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Height(-1))
            .withMessageContaining("높이는 양수여야 합니다");
    }
    
    @Test
    @DisplayName("높이 동등성 테스트")
    void heightEquality() {
        Height height1 = new Height(5);
        Height height2 = new Height(5);
        Height height3 = new Height(10);
        
        assertThat(height1).isEqualTo(height2);
        assertThat(height1).isNotEqualTo(height3);
    }
} 

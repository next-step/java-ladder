package nextstep.ladder.model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class HeightTest {
    
    @Test
    @DisplayName("높이 생성 테스트")
    void createHeight() {
        Height height = new Height(5);
        assertThat(height.getValue()).isEqualTo(5);
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    @DisplayName("0 또는 음수 높이 생성 시 예외 발생 테스트")
    void createZeroOrNegativeHeight(int invalidHeight) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> new Height(invalidHeight))
            .withMessageContaining("높이는 양수여야 합니다");
    }
    
    @ParameterizedTest
    @CsvSource(value = {"5,5,true", "5,10,false", "10,5,false"})
    @DisplayName("높이 동등성 테스트")
    void heightEquality(int height1Value, int height2Value, boolean expectedEquality) {
        Height height1 = new Height(height1Value);
        Height height2 = new Height(height2Value);
        
        assertThat(height1.equals(height2)).isEqualTo(expectedEquality);
    }
} 

package ladder.model.stringas;

import ladder.model.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAsHeightTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("입력받은 값으로 Height 객체 생성 테스트")
    void createHeightByInputTest(int height) {
        StringAsHeight stringAsHeight = new StringAsHeight(String.valueOf(height));
        assertThat(stringAsHeight.get()).isEqualTo(new Height(height));
    }
}
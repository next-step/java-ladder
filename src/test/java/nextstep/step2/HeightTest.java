package nextstep.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.Height;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @ParameterizedTest
    @DisplayName("입력받은 높이 제대로 리턴되는지 테스트")
    @ValueSource(ints = {4,6,7,8,10})
    void countHeightTest(int ladderHeight){
        Height height = Height.of(ladderHeight);
        assertThat(height.getHeight()).isEqualTo(ladderHeight);
    }

    @ParameterizedTest
    @DisplayName("높이 유효성 테스트")
    @ValueSource(ints = {0,-1})
    void InvalidHeightTest(int ladderHeight){
        assertThatThrownBy(() -> Height.of(ladderHeight))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Height.LADDER_MINIMUM_EXCEPTION);
    }
}

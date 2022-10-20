package nextstep.ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class RewardTest {

    private static final String NORMAL_NAME = "mojh";

    @Test
    @DisplayName("보상을 생성할 때 정상적인 값을 넣었을 때 정상적으로 생성되어지는지에 대한 테스트")
    public void constructorSuccessTest() {
        assertThat(new Reward(NORMAL_NAME)).isEqualTo(new Reward(NORMAL_NAME));
    }

    @ParameterizedTest(name = "보상을 생성할 때 Null 혹은 빈값을 넣을 경우 에러를 발생한다.")
    @NullAndEmptySource
    void constructorTestNullOrBlank(String text) {
        assertThatThrownBy(() -> new Reward(text)).isInstanceOf(IllegalArgumentException.class);
    }
}
package ladder;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputResultTest {

    @Test
    void 생성() {
        InputResult inputResult = new InputResult(new String[] {"꽝", "5000", "꽝", "3000"});

        assertThat(inputResult).isEqualTo(new InputResult(new String[] {"꽝", "5000", "꽝", "3000"}));
    }

    @Test
    void 플레이어_수와_같은지_확인한다() {
        int playerSize = 3;
        InputResult inputResult = new InputResult(new String[] {"꽝", "5000", "꽝", "3000"});

        assertThatThrownBy(() -> inputResult.validSize(playerSize))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 해당_위치의_결과값을_반환한다() {
        InputResult inputResult = new InputResult(new String[] {"꽝", "5000", "꽝", "3000"});

        String result = inputResult.get(0);

        assertThat(result).isEqualTo("꽝");
    }
}
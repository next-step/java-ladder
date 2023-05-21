package ladder.Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {
    @Test
    @DisplayName("실행 결과 입력 시 size와 다르게 입력하면 에러")
    public void results_not_same_size() {
        String input = "aaa,bbb,ccc";

        assertThatThrownBy(() -> new Results(input, 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실행 결과 입력 시 size와 같게 입력하면 정상 리턴")
    public void results_same_size() {
        String input = "aaa,bbb,ccc";

        int expected = 3;
        int actual = new Results(input, 3).of().size();

        assertThat(actual).isEqualTo(expected);
    }

}
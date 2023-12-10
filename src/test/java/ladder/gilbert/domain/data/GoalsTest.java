package ladder.gilbert.domain.data;

import ladder.gilbert.domain.exception.LadderException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GoalsTest {

    @Test
    void get() {
        Goals goals = goals();
        assertThat(goals.get(0)).isEqualTo(new Goal("a"));
    }

    @Test
    void 공백_입력() {
        assertThatThrownBy(() -> new Goals("", ""))
            .isInstanceOf(LadderException.class)
            .hasMessage("실행 결과가 공백입니다.");
    }

    private Goals goals() {
        return new Goals("a", "b", "c");
    }
}

package step2;

import org.junit.jupiter.api.Test;
import step2.model.Results;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultsTest {
    @Test
    public void 결과값_빈값_null() {
        assertThatThrownBy(() -> new Results(null, 4))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Results("", 4))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Results("꽝, 꽝, 꽝, ,", 4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 결과값수와_참여자수가_같은지_검사() {
        assertThatThrownBy(() -> new Results("꽝, 꽝, 꽝", 4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

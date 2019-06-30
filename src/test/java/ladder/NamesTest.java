package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {
    @Test
    @DisplayName("Names.of 로 스트링을 초기화 할 수 있다.")
    void of() {
        Names names = Names.of("1,2");
        assertThat(names.getNames()).contains(
                new Name("1"),
                new Name("2")
        );
    }
}

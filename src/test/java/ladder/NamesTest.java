package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesTest {
    @Test
    @DisplayName("String List 를 받아서 Names 로 초기화 한다")
    void constructor() {
        Names names = new Names(Arrays.asList("1", "2"));
        assertThat(names.getNames()).contains(
                new Name("1"),
                new Name("2")
        );
    }
}

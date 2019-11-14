package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderRecordTest {

    @Test
    @DisplayName("유저수와 결과수 같게 입력해야 한다.")
    void checkSize() {

        List<String> users = Arrays.asList("a", "b", "c");
        List<String> outcomes = Arrays.asList("1", "2", "4", "5");

        assertThatThrownBy(() -> {
            new LadderRecord(users, outcomes);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유저수와 결과수를 같게 입력해주세요");
    }
}

package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @DisplayName("Line은 참가자의 수만큼 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void create(int userCount) {
        assertThat(LadderLine.of(userCount).getLinkCount()).isEqualTo(userCount);
    }
}

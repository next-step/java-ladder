package nextstep.ladder.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeightTest {
    @Test
    @DisplayName("사다리의 세로 길이를 생성합니다.")
    void create() {
        assertThat(Height.create()).isEqualTo("|");
    }
}

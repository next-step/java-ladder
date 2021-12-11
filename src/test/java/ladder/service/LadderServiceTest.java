package ladder.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderServiceTest {
    @Test
    @DisplayName("LadderService 생성자 테스트")
    void constructor() {
        assertThat(new LadderService(new String[]{"aaa", "bbb"}, "1"))
        .isEqualTo(new LadderService(new String[]{"aaa", "bbb"}, "1"));
    }
}

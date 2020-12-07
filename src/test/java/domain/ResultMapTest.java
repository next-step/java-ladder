package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultMapTest {
    @Test
    @DisplayName("스태틱 팩터리 메서드 테스트")
    void createTest() {
        assertThat(ResultMap.create()).isInstanceOf(ResultMap.class);
    }
}

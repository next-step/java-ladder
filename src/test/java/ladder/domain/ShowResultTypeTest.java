package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShowResultTypeTest {
    @Test
    @DisplayName("결과 출력 타입 가져오기 테스트")
    public void getShowResultTypeTest() {
        assertThat(ShowResultType.get("all")).isEqualTo(ShowResultType.ALL);
        assertThat(ShowResultType.get("이름")).isEqualTo(ShowResultType.INDIVIDUAL);
        assertThat(ShowResultType.get("name")).isEqualTo(ShowResultType.INDIVIDUAL);
    }
}
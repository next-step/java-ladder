package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 한 행을 표현하는 로우 클래스에 대한 테스트")
class RowTest {

    @DisplayName("사다리 한 행은 사다리의 폭을 가지고 초기화 한다")
    @Test
    void init() {
        assertThat(Row.init(5)).isInstanceOf(Row.class);
    }
}

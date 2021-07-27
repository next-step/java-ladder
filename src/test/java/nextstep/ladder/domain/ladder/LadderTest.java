package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.Fixture.LADDER_INIT_INFO_2_X_2;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리를 표현하는 클래스 테스트")
class LadderTest {

    @DisplayName("사다리는 사라디 초기화 정보를 가지고 초기화한다")
    @Test
    void init() {
        assertThat(Ladder.init(LADDER_INIT_INFO_2_X_2)).isInstanceOf(Ladder.class);
    }

}

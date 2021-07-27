package nextstep.ladder.domain.init;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.Fixture.ALWAYS_GENERATE_STRATEGY;
import static nextstep.ladder.domain.Fixture.LADDER_SIZE_2_X_2;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리 초기화 정보를 담은 클래스 테스트")
class LadderInitInfoTest {

    @DisplayName("사다리 초기화 정보는 사다리 크기와 발판 생성 전략을 가지고 생성한다")
    @Test
    void init() {
        assertThat(LadderInitInfo.init(LADDER_SIZE_2_X_2, ALWAYS_GENERATE_STRATEGY)).isInstanceOf(LadderInitInfo.class);
    }
}

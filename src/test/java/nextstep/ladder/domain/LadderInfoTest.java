package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderInfoTest {

    @DisplayName("사다리 가로 세로 길이를 받는 정보 클래스")
    @Test
    void create() {
        assertThat(new LadderInfo(1,2))
                .isEqualTo(new LadderInfo(1,2));
    }

    @DisplayName("사다리를 만들수 있는 사다리 정보인지 판별하는 메서드")
    @Test
    void rightInfo(){
        assertThat(new LadderInfo(1,0).isRightLadderInfo(1)).isFalse();
    }
}
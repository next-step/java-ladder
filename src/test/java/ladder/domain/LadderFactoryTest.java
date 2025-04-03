package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderFactoryTest {

    @Test
    @DisplayName("사다리 게임에 참여하는 사람의 이름은 최대 5글자이다.")
    void validateNameLengthShouldBeLessThan5() {
        assertThatThrownBy(() -> new LadderFactory("sunny,universe", 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 게임에 입력하는 사다리 높이는 양수여야 한다.")
    void validateLadderHeightShouldBeLargerThan0() {
        assertThatThrownBy(() -> new LadderFactory("sunny,univ", -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
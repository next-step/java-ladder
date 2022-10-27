package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Names;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LadderControllerTest {

    @Test
    public void 실행결과_개수가_참여자수와_동일한지() {
        LadderController controller = new LadderController();
        assertThatThrownBy(() -> controller.checkValidationOfResultsNumber(4, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("실행 결과의 갯수는 참여하는 사람의 수와 동일해야 합니다.");
    }

}
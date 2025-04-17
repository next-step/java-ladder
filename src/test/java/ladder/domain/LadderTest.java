package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LadderTest {

    @Test
    @DisplayName("사다리 게임에 입력하는 사다리 높이는 양수여야 한다.")
    void validateLadderHeightShouldBeLargerThan0() {
        assertThatThrownBy(() -> new Ladder(List.of("sunny", "univ"), -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 타기는 (참여하는 사람의 수 - 1) 만큼 라인이 생성된다.")
    void getLadder() {
        Lines lines = new Ladder(List.of("red", "blue"), 2, () -> true).getLadder();
        assertTrue(lines.hasSameHeight(2));
        assertTrue(lines.hasSameWidth(1));
    }

    @Test
    @DisplayName("사다리 타기는 라인이 겹치지 않는다.")
    void lineShouldNotOverlap() {
        Lines lines = new Ladder(List.of("red", "blue", "green"), 3, () -> true).getLadder();
        assertThat(lines.getLines()).allMatch(width -> !width.equals(List.of(true, true)));
    }

    @Test
    @DisplayName("사다리 타기 참여자의 이름을 얻는다.")
    void getNames() {
        assertThat(new Ladder(List.of("red", "blue", "green"), 1).getNames()).isEqualTo(new Names("red", "blue", "green"));
    }
}


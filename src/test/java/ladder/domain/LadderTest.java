package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LadderTest {

    @Test
    @DisplayName("사다리 게임에 입력하는 사다리 높이는 양수여야 한다.")
    void validateLadderHeightShouldBeLargerThan0() {
        assertThatThrownBy(() -> new Ladder(List.of("sunny", "univ"), List.of("3000", "5000"), -1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 게임에 입력하는 참가자 수와 결과 수는 동일해야한다.")
    void validateHaveSameNamesAndResultsSize() {
        assertThatCode(() -> new Ladder(List.of("sunny", "univ"), List.of("3000", "5000"), 1)).doesNotThrowAnyException();
        assertThrows(IllegalArgumentException.class, () -> new Ladder(List.of("sunny", "univ"), List.of("3000"), 1));
    }

    @Test
    @DisplayName("사다리 타기는 (참여하는 사람의 수 - 1) 만큼 라인이 생성된다.")
    void getLines() {
        Ladder ladder = new Ladder(List.of("red", "blue"), List.of("3000", "5000"), 2, () -> true);
        assertThat(ladder.getLines()).isEqualTo(new Lines(new Line(true), new Line(true)));
    }

    @Test
    @DisplayName("사다리 타기는 라인이 겹치지 않는다.")
    void lineShouldNotOverlap() {
        Lines lines = new Ladder(List.of("red", "blue", "green"), List.of("3000", "5000", "꽝"), 3, () -> true).getLines();
        assertThat(lines.getLines()).allMatch(width -> !width.equals(List.of(true, true)));
    }

    @Test
    @DisplayName("사다리 타기 참여자의 이름을 얻는다.")
    void getNames() {
        assertThat(new Ladder(List.of("red", "blue", "green"), List.of("3000", "5000", "꽝"), 1).getNames()).isEqualTo(new Names("red", "blue", "green"));
    }

    @Test
    @DisplayName("사다리 타기를 실행하여 결과를 받는다.")
    void getResultsLadder() {
        Ladder ladder = new Ladder(List.of("red", "blue", "green"), List.of("3000", "5000", "꽝"), 1, () -> true);
        Results result = ladder.getResults();
        assertThat(result.getResult("red")).isEqualTo("5000");
        assertThat(result.getResult("blue")).isEqualTo("3000");
        assertThat(result.getResult("green")).isEqualTo("꽝");
    }
}


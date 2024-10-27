package nextstep.ladder;

import nextstep.ladder.model.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class LadderTest {

    @Test
    void 사다리_높이와_인원에_따른_라인_수_확인() {
        int height = 5;
        int countOfPerson = 3;
        Ladder ladder = new Ladder(height, countOfPerson);

        assertEquals(height, ladder.getLines().size());
    }

    @Test
    void 사다리_높이가_0일_때_IllegalArgumnetException이_발생() {
        assertThatThrownBy(() -> new Ladder(0, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 0보다 커야 합니다.");
    }

    @Test
    void 사다리_라인이_정상적으로_생성되는지_확인() {
        Ladder ladder = new Ladder(2, 2);
        assertFalse(ladder.getLines().isEmpty());
    }
}

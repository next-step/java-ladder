package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("성공 - 사다리가 만들어진다")
    void success_generate_ladder() {
        Height height = new Height(5);
        int countOfPerson = 4;

        Ladder ladder = new Ladder(height, countOfPerson);

        List<Line> lines = ladder.lines();

        assertThat(lines)
                .hasSize(height.height())
                .allSatisfy(line -> assertThat(line.size()).isEqualTo(countOfPerson));
    }

    @Test
    @DisplayName("성공 - 사다리를 탄 후 결과값의 범위에 맞는지 확인한다.")
    void success_ladder_climb_final_position_range() {
        Height height = new Height(5);
        int countOfPerson = 4;

        Ladder ladder = new Ladder(height, countOfPerson);

        int finalPosition = ladder.climb(0);
        assertThat(finalPosition).isBetween(0, countOfPerson - 1);
    }

}

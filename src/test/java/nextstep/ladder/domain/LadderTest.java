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

}

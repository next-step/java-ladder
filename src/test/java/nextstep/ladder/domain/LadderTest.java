package nextstep.ladder.domain;

import nextstep.ladder.strategy.TestDirectionStrategy;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.domain.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("성공 - 사다리가 만들어진다")
    void success_generate_ladder() {
        Height height = new Height(1);
        int countOfPerson = 4;

        Ladder ladder = new Ladder(new TestDirectionStrategy(Lists.newArrayList(RIGHT, STAY, STAY)), height, countOfPerson);

        List<Line> lines = ladder.lines();

        assertThat(lines)
                .hasSize(height.height())
                .allSatisfy(line -> assertThat(line.size()).isEqualTo(countOfPerson));
    }

    @Test
    @DisplayName("성공 - 참여자가 1명이면 만들어진 사다리는 일자이다.")
    void success_generate_ladder_single_participant() {
        Height height = new Height(5);
        int countOfPerson = 1;

        Ladder ladder = new Ladder(new TestDirectionStrategy(Lists.newArrayList(RIGHT, LEFT, STAY)), height, countOfPerson);

        List<Line> lines = ladder.lines();

        assertThat(lines)
                .hasSize(height.height())
                .allSatisfy(line -> assertThat(line).isEqualTo(new Line((STAY))));
    }

    @Test
    @DisplayName("성공 - 사다리를 탄 후 결과값을 검증한다.")
    void success_ladder_climb_final_position_range() {
        Height height = new Height(1);
        int countOfPerson = 4;

        Ladder ladder = new Ladder(new TestDirectionStrategy(Lists.newArrayList(RIGHT, STAY, STAY)), height, countOfPerson);

        int finalPosition = ladder.climb(0);
        assertThat(finalPosition).isEqualTo(1);
    }

}

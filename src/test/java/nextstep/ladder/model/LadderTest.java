package nextstep.ladder.model;

import nextstep.ladder.model.value.Line;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LadderTest {

    @Test
    @DisplayName("참석자가 한명이어도 게임이 진행되어야 한다.")
    void participantsOneUserTest() {
        assertThatCode(() -> Ladder.of(5, 1))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Ladder 생성시, 생성되는 각 높이는 입력된 값이고, Line의 갯수는 참가자의 수 -1 이다.")
    void createLineInPointSizeTest() {

        int participantsCount = 10;
        Ladder ladder = Ladder.of(5, participantsCount);

        List<Line> lines = ladder.getLines();
        assertThat(lines).hasSize(5);
        assertThat(lines.get(0).getPoints()).hasSize(participantsCount - 1);
    }
}

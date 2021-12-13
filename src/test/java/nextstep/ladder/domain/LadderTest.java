package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {


    @Test
    @DisplayName("참석자가 한명이어도 게임이 진행되어야 한다.")
    void participantsOneUserTest() {
        assertThatCode(() -> Ladder.create(PositiveNumber.create(5), 1))
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Ladder 생성시, 전달한 갯수만큼 lines 생성되어야 한다.")
    void createHeightSizeTest() {
        Ladder ladder = Ladder.create(PositiveNumber.create(5), 10);

        List<Line> lines = ladder.getLines();

        assertThat(lines).hasSize(5);
        assertThat(lines.get(0).getPoints()).hasSize(9);
        System.out.println(ladder);
    }

    @Test
    @DisplayName("Ladder 생성시, 생성되는 각 Line의 갯수는, 참가자의 수 -1 이다.")
    void createLineInPointSizeTest() {

        int participantsCount = 10;
        Ladder ladder = Ladder.create(PositiveNumber.create(5), participantsCount);

        List<Line> lines = ladder.getLines();

        assertThat(lines.get(0).getPoints()).hasSize(participantsCount - 1);
    }


    @Test
    @DisplayName("사다리 구조대로, 위치가 잘 움직인다.")
    void executeTest() {
        Ladder ladder = Ladder.create(PositiveNumber.create(2), 3, drawLineRandomMock());

        /*
         *  0     1      2
         *  |-----|      |
         *  |-----|      |
         */

        assertThat(ladder.execute(Position.of(0))).isEqualTo(Position.of(0));
        assertThat(ladder.execute(Position.of(1))).isEqualTo(Position.of(1));
        assertThat(ladder.execute(Position.of(2))).isEqualTo(Position.of(2));
    }

    private Random drawLineRandomMock() {
        return new Random() {
            @Override
            public boolean nextBoolean() {
                return true;
            }
        };
    }
}

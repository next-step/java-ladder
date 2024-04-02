package nextstep.ladder.domain;

import nextstep.ladder.data.StepType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("사다리 정보를 반환한다.")
    @Test
    void getLadderInfo() {
        // given
        List<String> users = List.of("yang", "gang", "eee");
        List<String> winningProducts = List.of("1등", "2등", "3등");

        // when
        Ladder ladder = Ladder.of(7, users.size(), new RandomLineStrategy());
        List<Line> ladderInfo = ladder.getLadderInfo();

        // then
        assertThat(ladderInfo).hasSize(7);
    }

    @DisplayName("최종 위치를 반환한다.")
    @Test
    void getDestinationPosition() {
        // given
        LineStrategy customStrategy = (count) -> Line.of(List.of(StepType.STEP, StepType.EMPTY, StepType.STEP, StepType.EMPTY));

        // when
        Ladder ladder = Ladder.of(1, 5, customStrategy);

        // then
        Assertions.assertAll(
                () -> assertThat(ladder.destinationPosition(0)).isEqualTo(1),
                () -> assertThat(ladder.destinationPosition(1)).isEqualTo(0),
                () -> assertThat(ladder.destinationPosition(2)).isEqualTo(3),
                () -> assertThat(ladder.destinationPosition(3)).isEqualTo(2),
                () -> assertThat(ladder.destinationPosition(4)).isEqualTo(4)
        );
    }
}

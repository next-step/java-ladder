package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderTest {

    @Test
    @DisplayName("[성공] 사다리를 생성한다.")
    void 사다리_생성() {
        Ladder ladder = Ladder.of(List.of(
                Line.of(List.of(true, false, true)),
                Line.of(List.of(false, true, false)),
                Line.of(List.of(true, false, false)),
                Line.of(List.of(false, true, false)),
                Line.of(List.of(true, false, true))
        ));
        Assertions.assertThat(ladder.getHeight()).isEqualTo(5);
    }

}

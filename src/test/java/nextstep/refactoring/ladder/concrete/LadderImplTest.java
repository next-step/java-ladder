package nextstep.refactoring.ladder.concrete;

import nextstep.refactoring.ladder.concrete.TestLadder;
import nextstep.refactoring.ladder.engine.Ladder;
import nextstep.refactoring.ladder.engine.LadderResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static nextstep.refactoring.ladder.engine.Position.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderImplTest {

    @Test
    @DisplayName("특정 위치에서 사다리를 탔을 때 결과를 매핑하여 반환한다.")
    void getResultOfLadder() {
        Ladder ladder = TestLadder.ladder();

        assertAll(
            () -> assertThat(ladder.run(of(0))).isEqualTo(new LadderResult(of(0), of(0))),
            () -> assertThat(ladder.run(of(1))).isEqualTo(new LadderResult(of(1), of(3))),
            () -> assertThat(ladder.run(of(2))).isEqualTo(new LadderResult(of(2), of(2))),
            () -> assertThat(ladder.run(of(3))).isEqualTo(new LadderResult(of(3), of(1)))
        );
    }
    
}

package nextstep.step4.model;

import nextstep.step4.api.Ladder;
import nextstep.step4.api.LadderCreator;
import org.junit.jupiter.api.Test;

import static nextstep.step4.model.SimpleLadderCreator.MIN_HEIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class SimpleLadderCreatorTest {

    @Test
    void create() {
        LadderCreator ladderCreator = new SimpleLadderCreator(new SimpleLineCreator());
        Ladder ladder = ladderCreator.create(3, 3);
        assertThat(ladder)
                .isInstanceOf(SimpleLadder.class);
    }

    @Test
    void 최소높이1미만인경우_예외를_던진다() {
        LadderCreator ladderCreator = new SimpleLadderCreator(new SimpleLineCreator());
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ladderCreator.create(0, 2))
                .withMessage("최소 높이는 " + MIN_HEIGHT + " 입니다");
    }
}

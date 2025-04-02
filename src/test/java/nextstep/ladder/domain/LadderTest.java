package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchIllegalArgumentException;


class LadderTest {

    @Test
    void ladder의_모든_legs는_height가_같아야_한다() {
        Leg test1 = new Leg("test1", 5);
        Leg test2 = new Leg("test2", 4);

        IllegalArgumentException e = catchIllegalArgumentException(() -> new Ladder(Arrays.asList(test1, test2)));

        assertThat(e).hasMessage("사다리의 모든 다리는 같은 높이를 가져야 합니다.");
    }

    @Test
    void ladder의_모든_legs는_name이_달라야_한다() {
        Leg test1 = new Leg("test1", 5);
        Leg test2 = new Leg("test1", 5);

        IllegalArgumentException e = catchIllegalArgumentException(() -> new Ladder(Arrays.asList(test1, test2)));

        assertThat(e).hasMessage("사다리의 모든 다리는 이름이 달라야 합니다.");
    }

    @Test
    void ladder의_legs는_비어있을_수_없다() {

        IllegalArgumentException e = catchIllegalArgumentException(() -> new Ladder(Collections.emptyList()));

        assertThat(e).hasMessage("사다리의 다리는 null이거나 비어있을 수 없습니다.");
    }

    @Test
    void ladder의_legs는_null일_수_없다() {
        IllegalArgumentException e = catchIllegalArgumentException(() -> new Ladder(null));

        assertThat(e).hasMessage("사다리의 다리는 null이거나 비어있을 수 없습니다.");
    }

}

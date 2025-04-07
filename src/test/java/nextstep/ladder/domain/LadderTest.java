package nextstep.ladder.domain;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchIllegalArgumentException;


class LadderTest {

    @Test
    void ladder의_모든_legs는_height가_같아야_한다() {
        Leg leg1 = new LegBuilder().height(5).build();
        Leg leg2 = new LegBuilder().height(4).build();

        IllegalArgumentException e = catchIllegalArgumentException(() -> new Ladder(List.of(leg1, leg2)));

        assertThat(e).hasMessage("사다리의 모든 다리는 같은 높이를 가져야 합니다.");
    }

    @Test
    void ladder의_모든_legs는_name이_달라야_한다() {
        List<String> names = List.of("t1", "t1");
        List<String> results = List.of("1", "2");
        List<Leg> legs = Leg.createLegs(names, results, 5);

        IllegalArgumentException e = catchIllegalArgumentException(() -> new Ladder(legs));

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

    @Test
    void applyRungs_메서드는_한번만_실행된다() {
        List<String> names = List.of("1", "2", "3");
        List<String> results = List.of("1", "2", "3");
        int height = 5;
        int linkCount = (names.size() - 1) * height;

        List<Leg> legs = Leg.createLegs(names, results, height);
        Ladder ladder = new Ladder(legs);

        MockRungStrategy mockRungStrategy = new MockRungStrategy();

        for (int i = 0; i < 10; i++) {
            ladder.applyRungs(mockRungStrategy);
            assertThat(mockRungStrategy.getApplyCallCount()).isEqualTo(linkCount);
        }
    }
}

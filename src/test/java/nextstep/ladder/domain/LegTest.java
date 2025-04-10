package nextstep.ladder.domain;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchIllegalArgumentException;
import static org.assertj.core.api.Assertions.catchIndexOutOfBoundsException;

class LegTest {

    @Test
    void leg_name_height_테스트() {
        String name = "이름";
        int height = 5;

        Leg leg = new LegBuilder()
            .name(name)
            .height(height)
            .build();

        assertThat(leg.getName()).isEqualTo(new ParticipantName(name));
        assertThat(leg.getHeight()).isEqualTo(height);
    }

    @Test
    void height_만큼_junction이_생성된다() {
        int height = 5;

        Leg leg = new LegBuilder()
            .height(height)
            .build();

        for (int i = 0; i < height; i++) {
            assertThat(leg.getJunction(i)).isNotNull();
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -99})
    void height가_음수이거나_0이면_leg의_height는_0이다(int height) {
        Leg leg = new LegBuilder()
            .height(height)
            .build();

        assertThat(leg.getHeight()).isEqualTo(0);
    }

    @Test
    void ladder의_height를_벗어나는_junction을_가져오면_예외가_발생한다() {
        String name = "이름";
        int height = 5;

        Leg leg = new Leg(name, "", height);

        IndexOutOfBoundsException e = catchIndexOutOfBoundsException(() -> leg.getJunction(height));

        assertThat(e).isNotNull();
    }

    @Test
    void 참여자의_이름과_실행결과의_수는_같아야_합니다() {
        List<String> names = List.of("1", "2");
        List<String> results = List.of("1");
        IllegalArgumentException e = catchIllegalArgumentException(() -> Leg.createLegs(names, results, 5));
        assertThat(e).hasMessage("참여할 사람의 수와 실행 결과의 수가 다릅니다.");
    }

    public static List<Leg> createLegsByNames(List<String> names) {
        return Leg.createLegs(names, names, 5);
    }
}

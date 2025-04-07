package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JunctionTest {

    @Test
    public void junction은_오른쪽으로_연결할_수_있다() {
        Junction junction = createJunction1();
        Junction rightJunction = createJunction1();

        junction.connectRight(rightJunction);

        assertThat(junction.hasLeft()).isFalse();
        assertThat(junction.hasRight()).isTrue();
        assertThat(junction.hasLeftOrRight()).isTrue();
        assertThat(rightJunction.hasLeft()).isTrue();
        assertThat(rightJunction.hasRight()).isFalse();
        assertThat(rightJunction.hasLeftOrRight()).isTrue();
    }

    @Test
    public void junction은_아래쪽으로_연결할_수_있다() {
        Junction junction = createJunction1();
        Junction downJunction = createJunction1();

        junction.connectDown(downJunction);

        assertThat(junction.hasDown()).isTrue();
        assertThat(junction.getDown()).isEqualTo(downJunction);
    }

    @Test
    void 이동할_곳이_없으면_제자리다() {
        ParticipantName name = new ParticipantName("1");
        Junction junction = createJunction1();

        Junction result = junction.moveToResult(name);

        assertThat(result).isEqualTo(junction);
    }

    public static Junction createJunction1() {
        Leg leg = LegTest.createLeg1();
        return new Junction(leg);
    }

    public static List<Junction> createJunctions1(int size) {
        Leg leg = LegTest.createLeg1();
        return IntStream.range(0, size)
            .mapToObj(i -> new Junction(leg))
            .collect(Collectors.toList());
    }

}

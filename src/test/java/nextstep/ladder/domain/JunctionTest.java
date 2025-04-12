package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JunctionTest {

    @Test
    public void junction은_오른쪽으로_연결할_수_있다() {
        Junction junction = createJunction();
        Junction rightJunction = createJunction();

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
        Junction junction = createJunction();
        Junction downJunction = createJunction();

        junction.connectDown(downJunction);

        assertThat(junction.hasDown()).isTrue();
    }

    @Test
    void 이동할_곳이_없으면_제자리다() {
        ParticipantName name = new ParticipantName("1");
        Junction junction = createJunction();

        Junction result = junction.moveToResult(name);

        assertThat(result).isEqualTo(junction);
    }

    @Test
    void 방문한_곳은_갈_수_없다() {
        ParticipantName name = new ParticipantName("1");
        Junction junction = createJunction();
        Junction rightJunction = createJunction();

        junction.connectRight(rightJunction);
        rightJunction.visit(name);

        Junction result = junction.moveToResult(name);

        assertThat(result).isEqualTo(junction);
    }

    @Test
    void 이동할_곳이_있다면_이동한다() {
        ParticipantName name = new ParticipantName("1");
        Junction junction = createJunction();
        Junction rightJunction = createJunction();
        Junction rightDownJunction = createJunction();

        rightJunction.connectDown(rightDownJunction);
        junction.connectRight(rightJunction);

        Junction result = junction.moveToResult(name);

        assertThat(result).isEqualTo(rightDownJunction);
    }

    public static Junction createJunction() {
        Leg leg = new LegBuilder().build();
        return new Junction(leg);
    }

    public static List<Junction> createJunctions(int size) {
        Leg leg = new LegBuilder().build();
        return IntStream.range(0, size)
            .mapToObj(i -> new Junction(leg))
            .collect(Collectors.toList());
    }

}

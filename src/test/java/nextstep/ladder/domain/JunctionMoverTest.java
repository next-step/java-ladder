package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.JunctionTest.createJunction;
import static org.assertj.core.api.Assertions.assertThat;

public class JunctionMoverTest {

    @Test
    void 이동할_곳이_없으면_제자리다() {
        ParticipantName name = new ParticipantName("1");
        Junction junction = createJunction();

        Junction result = JunctionMover.moveToResult(junction, name);

        assertThat(result).isEqualTo(junction);
    }

    @Test
    void 방문한_곳은_갈_수_없다() {
        ParticipantName name = new ParticipantName("1");
        Junction junction = createJunction();
        Junction rightJunction = createJunction();

        junction.connectRight(rightJunction);
        rightJunction.visit(name);

        Junction result = JunctionMover.moveToResult(junction, name);

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

        Junction result = JunctionMover.moveToResult(junction, name);

        assertThat(result).isEqualTo(rightDownJunction);
    }

}

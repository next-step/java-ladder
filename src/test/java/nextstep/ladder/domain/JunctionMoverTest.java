package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static nextstep.ladder.domain.JunctionTest.createJunction;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchIllegalStateException;

public class JunctionMoverTest {

    private final JunctionMover mover = new JunctionMover();

    @Test
    void 이동할_곳이_없으면_예외발생() {
        ParticipantName name = new ParticipantName("1");
        Junction junction = createJunction();

        assertThat(mover.canMove(junction, name)).isFalse();

        IllegalStateException e = catchIllegalStateException(() -> mover.move(junction, name));
        assertThat(e).hasMessage("이동할 수 없습니다.");
    }

    @Test
    void 방문한_곳은_갈_수_없다() {
        ParticipantName name = new ParticipantName("1");
        Junction junction = createJunction();
        Junction rightJunction = createJunction();

        junction.connectRight(rightJunction);
        mover.visit(rightJunction, name);

        assertThat(mover.canMove(junction, name)).isFalse();
        IllegalStateException e = catchIllegalStateException(() -> mover.move(junction, name));

        assertThat(e).hasMessage("이동할 수 없습니다.");
    }

    @Test
    void 좌우를_우선_이동한다() {
        ParticipantName name = new ParticipantName("1");
        Junction junction = createJunction();
        Junction rightJunction = createJunction();
        Junction downJunction = createJunction();

        junction.connectDown(downJunction);
        junction.connectRight(rightJunction);

        Junction result = mover.move(junction, name);

        assertThat(result).isEqualTo(rightJunction);
    }

    @Test
    void 더이상_이동할_수_없을때까지_이동한다() {
        ParticipantName name = new ParticipantName("1");
        Junction curr = createJunction();
        Junction right = createJunction();
        Junction rightDown = createJunction();

        curr.connectRight(right);
        right.connectDown(rightDown);

        Junction result = mover.moveToEnd(curr, name);

        assertThat(result).isEqualTo(rightDown);
    }

}

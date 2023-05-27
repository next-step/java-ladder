package ladder.domain.pointer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.line.Line;
import ladder.domain.moving.Moving;
import ladder.domain.moving.FlowMoving;
import ladder.domain.name.Name;
import ladder.domain.name.Names;
import ladder.domain.position.Position;
import org.junit.jupiter.api.Test;

class PointersTest {
    @Test
    void 사다리타기() {
        Pointers actual = Pointers.of(Names.of("a,b,c,d,e"));
        Ladder ladder = Ladder.of(List.of(
            Line.of(x -> List.of(true, false, false, true), 5),
            Line.of(x -> List.of(false, true, false, false), 5),
            Line.of(x -> List.of(false, true, false, true), 5),
            Line.of(x -> List.of(true, false, false, true), 5),
            Line.of(x -> List.of(true, false, true, false), 5),
            Line.of(x -> List.of(false, false, true, false), 5),
            Line.of(x -> List.of(true, false, true, false), 5),
            Line.of(x -> List.of(true, false, true, false), 5),
            Line.of(x -> List.of(false, false, false, true), 5),
            Line.of(x -> List.of(true, false, true, false), 5))
        );

        Pointers expected = Pointers.of(List.of(
            Pointer.of(Name.of("a"), Position.of(10, 0)),
            Pointer.of(Name.of("b"), Position.of(10, 1)),
            Pointer.of(Name.of("c"), Position.of(10, 3)),
            Pointer.of(Name.of("d"), Position.of(10, 2)),
            Pointer.of(Name.of("e"), Position.of(10, 4))
        ));

        assertThat(actual.destinationOf(FlowMoving.instance(), ladder)).isEqualTo(expected);
    }

    @Test
    void 포인터_사다리타기() {
        Pointers actual = Pointers.of(Names.of("a,b,c"));
        Ladder ladder = Ladder.of(List.of(Line.of(x -> List.of(false, false), 3)));

        Pointers expected = Pointers.of(List.of(
            Pointer.of(Name.of("a"), Position.of(1, 0)),
            Pointer.of(Name.of("b"), Position.of(1, 1)),
            Pointer.of(Name.of("c"), Position.of(1, 2))
        ));
        assertThat(actual.destinationOf((x,i) -> Moving.FORWARD, ladder)).isEqualTo(expected);
    }

    @Test
    void 포인터리스트_생성() {
        assertThat(Pointers.of(Names.of("a,b,c"))).isEqualTo(Pointers.of(Names.of("a,b,c")));
    }

}
package ladder.domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import java.util.Map;
import ladder.domain.Ladder;
import ladder.domain.position.Position;
import ladder.domain.line.Line;
import ladder.domain.moving.FlowMoving;
import ladder.domain.name.Name;
import ladder.domain.name.Names;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void 게임결과_이름() {
        Map<Name, Position> map = Map.of(
            Name.of("a"), Position.of(1, 0),
            Name.of("b"), Position.of(1, 1),
            Name.of("c"), Position.of(1, 2),
            Name.of("d"), Position.of(1, 3)
        );
        GameResult gameResult = GameResult.of(map);
        assertAll(
            () -> assertThat(gameResult.resultOf(Name.of("a"))).isEqualTo(0),
            () -> assertThat(gameResult.resultOf(Name.of("b"))).isEqualTo(1),
            () -> assertThat(gameResult.resultOf(Name.of("c"))).isEqualTo(2),
            () -> assertThat(gameResult.resultOf(Name.of("d"))).isEqualTo(3)
        );
    }

    @Test
    void 게임결과생성() {
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
            Line.of(x -> List.of(true, false, true, false), 5)
        ));
        Names names = Names.of("a,b,c,d,e");
        Map<Name, Position> map = Map.of(
            Name.of("a"), Position.of(10, 0),
            Name.of("b"), Position.of(10, 1),
            Name.of("c"), Position.of(10, 3),
            Name.of("d"), Position.of(10, 2),
            Name.of("e"), Position.of(10, 4)
        );
        assertThat(GameResult.of(FlowMoving.instance(), names, ladder)).isEqualTo(GameResult.of(map));
    }

}
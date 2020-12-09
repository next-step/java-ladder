package ladder.ladder;

import ladder.model.group.Users;
import ladder.model.ladder.Bridge;
import ladder.model.ladder.Ladder;
import ladder.model.ladder.Line;
import ladder.model.move.Point;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    private final static List<Bridge> MOVABLE_BRIDGE = IntStream.rangeClosed(1,3)
            .mapToObj(idx -> Bridge.createMovableBridge(Point.bridgePoint(idx,0)))
            .collect(Collectors.toList());

    private final static List<Bridge> NON_MOVABLE_BRIDGE = IntStream.rangeClosed(1,3)
            .mapToObj(idx -> Bridge.createNonMovableBridge(Point.bridgePoint(idx,0)))
            .collect(Collectors.toList());

    @Test
    public void 음수_높이_사다리() {
        assertThatThrownBy(() -> Ladder.of("-1", 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 높이가_없는_사다리() {
        assertThatThrownBy(() -> Ladder.of("0", 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 정상_사다리() {
        Ladder ladder = Ladder.of("1", 2);
        assertThat(ladder.getLadder().size()).isEqualTo(1);
    }

    @Test
    public void 이동_정상_결과(){
        Users users = Users.from("a,b");
        List<Line> lines = Collections.singletonList(Line.from(Arrays.asList(MOVABLE_BRIDGE.get(0), NON_MOVABLE_BRIDGE.get(1))));

        Ladder ladder = Ladder.from(lines);
        assertThat(ladder.getResults(users).entrySet()).containsExactly(
                new AbstractMap.SimpleEntry<>("a", Point.of(2,1)),
                new AbstractMap.SimpleEntry<>("b", Point.of(0,1))
        );
    }

    @Test
    public void 이동없는_정상_결과(){
        Users users = Users.from("a,b");
        List<Line> lines = Collections.singletonList(Line.from(Arrays.asList(NON_MOVABLE_BRIDGE.get(0), NON_MOVABLE_BRIDGE.get(1))));

        Ladder ladder = Ladder.from(lines);
        assertThat(ladder.getResults(users).entrySet()).containsExactly(
                new AbstractMap.SimpleEntry<>("a", Point.of(0,1)),
                new AbstractMap.SimpleEntry<>("b", Point.of(2,1))
        );
    }
}

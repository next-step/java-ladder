package nextstep.ladder;

import nextstep.ladder.domain.LadderBoard;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameLogicTest {

    @Test
    @DisplayName("사다리 게임 로직 중 재귀 정상 동작 테스트")
    void ladderGameLogicTest() {
        List<Line> lines = List.of(
                new Line(List.of(new Point(true), new Point(false), new Point(true))),
                new Line(List.of(new Point(false), new Point(true), new Point(false))),
                new Line(List.of(new Point(true), new Point(false), new Point(false))),
                new Line(List.of(new Point(false), new Point(true), new Point(false))),
                new Line(List.of(new Point(true), new Point(false), new Point(true)))
        );
        LadderBoard ladderBoard = new LadderBoard(lines);

        List<GameUser> gameUsers = List.of(
                new GameUser("pobi",new Position(0)),
                new GameUser("xyz",new Position(1)),
                new GameUser("yz1",new Position(2)),
                new GameUser("zzz",new Position(3))
        );
        LadderGameLogic.logic(ladderBoard, gameUsers);
        List<Integer> resultPosition = gameUsers.stream().map(gameUser -> gameUser.getPosition().getPosition()).collect(Collectors.toList());
        assertThat(resultPosition).containsExactly(0, 3, 2, 1);
    }

}

package nextstep.ladder;

import nextstep.ladder.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameUsersTest {

    @Test
    @DisplayName("사다리 게임 결과 정상 동작 테스트")
    void ladderGameResultTest() {
        List<GameUser> gameUserList = List.of(
                new GameUser("pobi", new Position(0)),
                new GameUser("xyz", new Position(1)),
                new GameUser("yz1", new Position(2)),
                new GameUser("zzz", new Position(3))
        );
        List<String> executionResult = List.of("꽝", "5000", "꽝", "3000");
        GameUsers gameUsers = new GameUsers(gameUserList);
        LadderGameResult result = gameUsers.makeResult(executionResult);
        assertThat(result.getSingleResult("pobi")).isEqualTo("꽝");
        assertThat(result.getSingleResult("xyz")).isEqualTo("5000");
        assertThat(result.getSingleResult("yz1")).isEqualTo("꽝");
        assertThat(result.getSingleResult("zzz")).isEqualTo("3000");
    }

    @Test
    @DisplayName("사다리 게임 로직 정상 동작 테스트")
    void ladderGameLogicTest() {
        List<Line> lines = List.of(
                new Line(List.of(new Point(true), new Point(false), new Point(true))),
                new Line(List.of(new Point(false), new Point(true), new Point(false))),
                new Line(List.of(new Point(true), new Point(false), new Point(false))),
                new Line(List.of(new Point(false), new Point(true), new Point(false))),
                new Line(List.of(new Point(true), new Point(false), new Point(true)))
        );
        Ladder ladder = new Ladder(lines);

        List<GameUser> gameUserList = List.of(
                new GameUser("pobi", new Position(0)),
                new GameUser("xyz", new Position(1)),
                new GameUser("yz1", new Position(2)),
                new GameUser("zzz", new Position(3))
        );
        GameUsers gameUsers = new GameUsers(gameUserList);
        ladder.play(gameUsers);
        List<Integer> resultPosition = gameUsers.getResultPosition();
        assertThat(resultPosition).containsExactly(0, 3, 2, 1);
    }

}

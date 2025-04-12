package nextstep.ladder.module;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.controller.Game;

public class GameTest {
    @Test
    @DisplayName("게임 결과 테스트 #1")
    public void test() {
        NameList nameList = new NameList(Arrays.asList("a", "b", "c"));
        ResultList resultList = new ResultList(Arrays.asList("1", "2", "3"));
        Height height = new Height(3);
        Line line1 = new Line(new PointList(3));
        Line line2 = new Line(new PointList(3));
        Line line3 = new Line(new PointList(3));
        line1.createLeftBridge(1); // |-| |
        line2.createLeftBridge(2); // | |-|
        line3.createLeftBridge(2); // | |-|

        Board board = new Board(Arrays.asList(line1, line2, line3), nameList);

        Game game = new Game(nameList, resultList, height);
        BoardResult boardResult = game.play(board);

        assertThat(boardResult.of(new Name("a"))).isEqualTo(new Result("2"));
        assertThat(boardResult.of(new Name("b"))).isEqualTo(new Result("1"));
        assertThat(boardResult.of(new Name("c"))).isEqualTo(new Result("3"));
    }

    @Test
    @DisplayName("게임 결과 테스트 #2")
    public void test2() {
        NameList nameList = new NameList(Arrays.asList("a", "b", "c", "d"));
        ResultList resultList = new ResultList(Arrays.asList("1", "2", "3", "4"));
        Height height = new Height(4);
        Line line1 = new Line(new PointList(4));
        Line line2 = new Line(new PointList(4));
        Line line3 = new Line(new PointList(4));
        Line line4 = new Line(new PointList(4));
        line1.createLeftBridge(1); // |-| | |
        line2.createLeftBridge(2); // | |-| |
        line3.createLeftBridge(3); // | | |-|
        line4.createLeftBridge(2); // | |-| |

        Board board = new Board(Arrays.asList(line1, line2, line3, line4), nameList);

        Game game = new Game(nameList, resultList, height);
        BoardResult boardResult = game.play(board);

        assertThat(boardResult.of(new Name("a"))).isEqualTo(new Result("4"));
        assertThat(boardResult.of(new Name("b"))).isEqualTo(new Result("1"));
        assertThat(boardResult.of(new Name("c"))).isEqualTo(new Result("3"));
        assertThat(boardResult.of(new Name("d"))).isEqualTo(new Result("2"));
    }
}

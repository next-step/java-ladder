package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import nextstep.ladder.view.ResultView;

class PlayLadderGameTest {
    private static ResultView resultView = ResultView.getResultView();
    private static PlayLadderGame playLadderGame = PlayLadderGame.getPlayLadderGame();
    private Users users;
    private Line line;
    private List<Line> lineList;
    private Ladder ladder;
    private Results results;
    private Users resultUsers;

    @BeforeEach
    void setUp() {

        List<Point> points = Stream.of(new Point(true),
                                       new Point(false),
                                       new Point(true))
                                   .collect(Collectors.toList());

        line = new Line(points);

        List<Point> points2 = Stream.of(new Point(false),
                                        new Point(true),
                                        new Point(false))
                                    .collect(Collectors.toList());

        Line line2 = new Line(points2);

        List<Point> points3 = Stream.of(new Point(true),
                                        new Point(false),
                                        new Point(false))
                                    .collect(Collectors.toList());

        Line line3 = new Line(points3);

        List<Point> points4 = Stream.of(new Point(false),
                                        new Point(true),
                                        new Point(false))
                                    .collect(Collectors.toList());

        Line line4 = new Line(points4);

        List<Point> points5 = Stream.of(new Point(true),
                                        new Point(false),
                                        new Point(true))
                                    .collect(Collectors.toList());

        Line line5 = new Line(points5);

        lineList = Stream.of(line, line2, line3, line4, line5)
                         .collect(Collectors.toList());

        ladder = new Ladder(lineList);

        users = new Users(new ArrayList<>(
                Stream.of(new User("pobi"),
                          new User("honux"),
                          new User("crong"),
                          new User("jk")
                )
                      .collect(Collectors.toList())));

        results = new Results(new ArrayList<>(
                Stream.of(new Result("꽝"),
                          new Result("5000"),
                          new Result("꽝"),
                          new Result("3000")
                )
                      .collect(Collectors.toList())));


    }

    @DisplayName("점의 위치가 첫번째 이고 선이 있을 경우 무조건 index 값이 +1 증가함(이동)")
    @Test
    void plusIndexForFirstPosition() {
        int index = 0;
        boolean isLine = true;
        int plusIndex = playLadderGame.plusIndex(index, isLine);
        assertThat(plusIndex).isEqualTo(index + 1);
    }

    @DisplayName("점의 위치가 마지막이고 선이 있을 경우 무조건 index 값이 -1 증가함(이동)")
    @Test
    void minusIndexForLastPosition() {
        int index = 2;
        boolean isLine = true;
        int minusIndex = playLadderGame.minusIndex(index, isLine);
        assertThat(minusIndex).isEqualTo(index - 1);
    }

    @DisplayName("점의 위치가 처음과 마지막이 아닐 경우는"
                 + "양옆에 왼쪽 또 오른쪽에 선이 있는는 경우에 따라 다르게 이동한다."
                 + "왼쪽으로 이동하는 경우 -1")
    @Test
    void judgeIndexForMiddlePositionAndMovingToLeft() {
        int index = 1;
        boolean isLeftLine = true;
        boolean isRightLine = false;
        int judgeIndex = playLadderGame.judgeIndex(index, isLeftLine, isRightLine);
        assertThat(judgeIndex).isEqualTo(index - 1);

    }

    @DisplayName("점의 위치가 처음과 마지막이 아닐 경우는"
                 + "양옆에 왼쪽 또 오른쪽에 선이 있는는 경우에 따라 다르게 이동한다."
                 + "오른으로 이동하는 경우 +1")
    @Test
    void judgeIndexForMiddlePositionAndMovingToRight() {
        int index = 1;
        boolean isLeftLine = false;
        boolean isRightLine = true;
        int judgeIndex = playLadderGame.judgeIndex(index, isLeftLine, isRightLine);
        assertThat(judgeIndex).isEqualTo(index + 1);

    }

    @DisplayName("사다리 게임에 대한 전체 결과 값을 만든다.")
    @Test
    void GenerateResultsForAllPlayers() {
        resultView.printLadder(users, ladder, results);
        resultUsers = playLadderGame.generateResultsForAllPlayers(users, ladder, results);

        List<User> userList = resultUsers.getUsers();
        assertThat(userList.get(0).getResult()).isEqualTo("꽝");
        assertThat(userList.get(1).getResult()).isEqualTo("3000");
        assertThat(userList.get(2).getResult()).isEqualTo("꽝");
        assertThat(userList.get(3).getResult()).isEqualTo("5000");
    }

}

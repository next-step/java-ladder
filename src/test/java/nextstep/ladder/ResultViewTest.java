package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultViewTest {

    private static ResultView resultView = ResultView.getResultView();
    private Users users;
    private Line line;
    private List<Line> lineList;
    private Ladder ladder;

    @BeforeEach
    void setUp() {
        Point point = new Point();
        point.moveNextPoint();

        Point point2 = new Point();

        Point point3 = new Point();
        point3.moveNextPoint();

        List<Point> points = Stream.of(point, point2, point3)
                                   .collect(Collectors.toList());

        line = new Line(points);
        lineList = Stream.of(line, line)
                         .collect(Collectors.toList());

        ladder = new Ladder(lineList);

        users = new Users(new ArrayList<>(
                Stream.of(new User("pobi"),
                          new User("honux"),
                          new User("crong"),
                          new User("jk")
                )
                      .collect(Collectors.toList())));
    }

    @DisplayName("유저 이름을 출력한다.")
    @Test
    void appendUserNames() {
        String userNames = resultView.appendUserNames(users);
        assertThat(userNames).isEqualTo(" pobi honux crong    jk");
    }

    @DisplayName("사다리의 라인의 해당하는 값을 그린다.")
    @Test
    void appendLine() {
        String line = resultView.appendLine(this.line);
        assertThat(line).isEqualTo("     |-----|     |-----|");
    }

    @DisplayName("입력 받은 사다리를 그린다.")
    @Test
    void drawLadder() {
        String drawLadder = resultView.drawLadder(users,ladder);
        assertThat(drawLadder).isEqualTo(" pobi honux crong    jk\n"
                                         + "     |-----|     |-----|\n"
                                         + "     |-----|     |-----|");

    }
}

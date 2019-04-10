package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LadderGameTest {

    @Test
    public void 유저이름_최대길이_테스트() {
        List<String> players = Arrays.asList("1번", "이번타자애오", "삼번타자임니당", "열글자넘기기귀찮구만요");
        LadderGame ladderGame = new LadderGame(players, 4);
        Assertions.assertThat(ladderGame.maxWidthDrawTimes()).isEqualTo(3);
    }

    @Test
    public void 플레이_결과() {
        List<String> players = Arrays.asList("1번", "이번타자애오");

        Ladder result = new Ladder(2,2);
        Line resultLine1 = new Line(2) {
            @Override
            protected List<Point> initPoints(int countOfPerson) {
                return Arrays.asList(Point.first(false), Point.last(false));
            }
        };

        Line resultLine2 = new Line(2) {
            @Override
            protected List<Point> initPoints(int countOfPerson) {
                return Arrays.asList(Point.first(true), Point.last(true));
            }
        };
        result.setLines(Arrays.asList(resultLine1, resultLine2));

        LadderGame ladderGame = new LadderGame(players, result);
        Assertions.assertThat(ladderGame.play()).isEqualTo(Arrays.asList(new PlayResult("1번", 1),
                new PlayResult("이번타자애오", 0)));
    }

}
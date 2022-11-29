package ladder.domain;

import ladder.util.LadderResultExpression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultsTest {

    @ParameterizedTest
    @CsvSource(value = {"\"꽝,5000,꽝,3000\",3", "\"꽝,5000,꽝,3000\",5"})
    @DisplayName("사다리 실행 결과를 입력한 그 개수와 멤버의 수가 일치하지 않으면 에러 발생한다.")
    void inputLadderResultTest_isNotSameSizeThanMemberCount_occurredException(String results, int memberCount) {
        List<String> ladderResults = LadderResultExpression.validateLadderResult(results);
        assertThatThrownBy(() -> new LadderResults(LadderResults.createResult(ladderResults, memberCount)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 생성하고, 사다리 실행 결과를 넣어 Result를 반환한다.")
    void test() {
        List<Point> points1 = new ArrayList<>();
        points1.add(new Point(0, Direction.first(TRUE)));
        points1.add(new Point(1, Direction.of(TRUE, FALSE)));
        points1.add(new Point(2, Direction.of(FALSE, TRUE)));
        points1.add(new Point(3, Direction.of(TRUE, FALSE)));

        List<Point> points2 = new ArrayList<>();
        points2.add(new Point(points1.get(0).getIndex(), Direction.of(FALSE, FALSE)));
        points2.add(new Point(points1.get(1).getIndex(), Direction.of(FALSE, TRUE)));
        points2.add(new Point(points1.get(2).getIndex(), Direction.of(TRUE, FALSE)));
        points2.add(new Point(points1.get(3).getIndex(), Direction.of(FALSE, FALSE)));

        List<Point> points3 = new ArrayList<>();
        points3.add(new Point(points2.get(0).getIndex(), Direction.of(FALSE, TRUE)));
        points3.add(new Point(points2.get(1).getIndex(), Direction.of(TRUE, FALSE)));
        points3.add(new Point(points2.get(2).getIndex(), Direction.of(FALSE, FALSE)));
        points3.add(new Point(points2.get(3).getIndex(), Direction.of(FALSE, FALSE)));

        List<Point> points4 = new ArrayList<>();
        points4.add(new Point(points3.get(0).getIndex(), Direction.of(FALSE, FALSE)));
        points4.add(new Point(points3.get(1).getIndex(), Direction.of(FALSE, TRUE)));
        points4.add(new Point(points3.get(2).getIndex(), Direction.of(TRUE, FALSE)));
        points4.add(new Point(points3.get(3).getIndex(), Direction.of(FALSE, FALSE)));

        List<Point> points5 = new ArrayList<>();
        points5.add(new Point(points4.get(0).getIndex(), Direction.of(FALSE, TRUE)));
        points5.add(new Point(points4.get(1).getIndex(), Direction.of(TRUE, FALSE)));
        points5.add(new Point(points4.get(2).getIndex(), Direction.of(FALSE, TRUE)));
        points5.add(new Point(points4.get(3).getIndex(), Direction.of(TRUE, FALSE)));

        LadderLine line1 = new LadderLine(points1);
        LadderLine line2 = new LadderLine(points2);
        LadderLine line3 = new LadderLine(points3);
        LadderLine line4 = new LadderLine(points4);
        LadderLine line5 = new LadderLine(points5);
        Ladder ladder = new Ladder(List.of(line1, line2, line3, line4, line5));

        LadderResult result1 = new LadderResult("꽝");
        LadderResult result2 = new LadderResult("5000");
        LadderResult result3 = new LadderResult("꽝");
        LadderResult result4 = new LadderResult("3000");
        LadderResults results = new LadderResults(List.of(result1, result2, result3, result4));
        List<LadderResult> ladderResults = results.playedByMembers(ladder);

        assertThat(ladderResults.get(0)).isEqualTo(new LadderResult(0, "꽝"));
        assertThat(ladderResults.get(1)).isEqualTo(new LadderResult(3, "5000"));
        assertThat(ladderResults.get(2)).isEqualTo(new LadderResult(2, "꽝"));
        assertThat(ladderResults.get(3)).isEqualTo(new LadderResult(1, "3000"));
    }
}

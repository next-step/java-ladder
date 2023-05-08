package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class ResultMatchTest {

    @Test
    @DisplayName("ResultMatch 의 match 테스트")
    void test01() {
        Result result = new Result(List.of("1", "꽝", "2"));
        Members members = getMembers("name1", "name2", "name3");
        Ladder ladder = new Ladder(members, getLines());
        ResultMatch resultMatch = new ResultMatch(result, ladder);

        String match = resultMatch.match("name1");

        assertThat(match).isEqualTo("1");
    }

    private static Members getMembers(String... names) {
        List<Member> members = Arrays.stream(names).map(Member::new).collect(Collectors.toList());
        return new Members(members);
    }

    // |   |---|   |
    // |   |---|   |
    private static List<Line> getLines() {
        return List.of(new Line(false, true, false),
                       new Line(false, true, false));
    }

}

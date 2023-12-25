package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.domain.LineDirection.LEFT;
import static nextstep.ladder.domain.LineDirection.RIGHT;
import static nextstep.ladder.domain.LineDirection.STRAIGHT;
import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("결과확인기능 / 멤버, 사다리, 상품 / 성공")
    void getResults() {
        /*
        a     b     c     d     e
        |     |-----|     |-----|
        |-----|     |-----|     |
        c     a     e     b     d
        "꽝", "5000", "꽝", "6000", "7000"
         */
        Member a = new Member("a");
        Member b = new Member("b");
        Member c = new Member("c");
        Member d = new Member("d");
        Member e = new Member("e");
        Line line1 = new Line(List.of(STRAIGHT, RIGHT, LEFT, RIGHT, LEFT));
        Line line2 = new Line(List.of(RIGHT, LEFT, RIGHT, LEFT, STRAIGHT));
        JoinMembers joinMembers = new JoinMembers(List.of(a, b, c, d, e));
        Ladder ladder = new Ladder(joinMembers.countOfMembers(), List.of(line1, line2));

        LadderResult results = ladder.getResults(joinMembers, List.of("꽝", "5000", "꽝", "6000", "7000"));

        assertThat(results.getResult(a)).isEqualTo("5000");
        assertThat(results.getResult(b)).isEqualTo("6000");
        assertThat(results.getResult(c)).isEqualTo("꽝");
        assertThat(results.getResult(d)).isEqualTo("7000");
        assertThat(results.getResult(e)).isEqualTo("꽝");
    }
}
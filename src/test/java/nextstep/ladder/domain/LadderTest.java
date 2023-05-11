package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    @DisplayName("Ladder 높이와 사람 수를 가지고 생성한다.")
    void test01() {
        Ladder ladder = new Ladder(getMembers("rang1", "rang2"), 4);

        assertThat(ladder.lines()).hasSize(4);
    }

    @Test
    @DisplayName("사다리의 마지막 위치를 가져온다.")
    void test02() {
        Ladder ladder = new Ladder(getMembers("rang1", "rang2", "rang3"),
                                   getLines());

        assertThat(ladder.move("rang1")).isEqualTo(new Position(0));
        assertThat(ladder.move("rang2")).isEqualTo(new Position(1));
        assertThat(ladder.move("rang3")).isEqualTo(new Position(2));
    }

    private static Members getMembers(String... names) {
        List<Member> members = Arrays.stream(names).map(Member::new).collect(Collectors.toList());
        return new Members(members);
    }

    private static List<Line> getLines() {
        return List.of(new Line(false, true, false),
                       new Line(false, true, false));
    }
}

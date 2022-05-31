package nextstep.ladder.domain.line;

import nextstep.ladder.domain.member.MembersTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    public static Line create(List<Boolean> booleans) {
        return new Line(booleans);
    }

    private static Line create(boolean aBoolean) {
        return new Line(MembersTest.members, () -> aBoolean);
    }

    @Nested
    class getPoint_메서드는 {

        @Test
        void 라인_문자열을_리턴한다() {
            Line line = create(List.of(true, false, false, true));

            assertThat(line.getPoint()).isEqualTo("|-----|     |     |-----|\n");

            line = create(true);
            assertThat(line.getPoint()).isEqualTo("|-----|     |-----|\n");

            line = create(false);
            assertThat(line.getPoint()).isEqualTo("|     |     |     |\n");
        }
    }
}

package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.LineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void testValidLadder() {
        int height = 4;
        int numberOfUser = 5;
        LineGenerator testLineGenerator = count -> Collections.nCopies(numberOfUser, Boolean.FALSE);

        Ladder ladder = new Ladder(height, numberOfUser, testLineGenerator);
        assertThat(ladder.getHeight()).isEqualTo(height);
        assertThat(ladder.getLines()).hasSize(height);
        assertContainLines(ladder, new Line(numberOfUser, testLineGenerator), numberOfUser);
    }

    private void assertContainLines(Ladder ladder, Line expectLine, int numberOfUser) {
        List<Line> lines = ladder.getLines();

        lines.forEach(line -> {
            assertThat(line.getLine())
                    .hasSize(numberOfUser)
                    .containsExactlyElementsOf(expectLine.getLine());

            assertThat(line.getLength()).isEqualTo(numberOfUser);
        });
    }
}

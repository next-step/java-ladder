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

    private List<String> ladderResults = Collections.nCopies(6, "test");
    private int length = 5;
    private int height = 4;

    @Test
    @DisplayName("사다리 생성 테스트")
    void testValidLadder() {
        LineGenerator testLineGenerator = count -> Collections.nCopies(length, Boolean.FALSE);

        Ladder ladder = new Ladder(height, length, testLineGenerator, ladderResults);
        assertThat(ladder.getHeight()).isEqualTo(height);
        assertThat(ladder.getLines()).hasSize(height);
        assertThat(ladder.getLadderResult()).hasSize(length+1).containsExactlyElementsOf(ladderResults);
        assertContainLines(ladder, new Line(length, testLineGenerator), length);
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

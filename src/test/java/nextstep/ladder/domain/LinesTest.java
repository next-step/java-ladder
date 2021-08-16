package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    @DisplayName("높이 5, 사람 4명일때의 사다리")
    void view() {
        Lines lines = Lines.of(Height.of(5), Names.of("a,b,c,d"));

        for (Line line : lines.getLines()) {
            assertThat(line.getPoints().get(0).isLeft()).isEqualTo(false);

            line.getPoints().forEach(point -> {
                System.out.print(point.isLeft() + " ");
            });

            System.out.println();
        }

        assertThat(lines.getLines().size()).isEqualTo(5);
    }

}

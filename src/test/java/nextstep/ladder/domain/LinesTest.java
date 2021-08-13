package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LinesTest {
    @Test
    @DisplayName("높이 5, 사람 4명일때의 사다리")
    void view() {
        Lines lines = Lines.of(Height.of(5), Names.of("a,b,c,d"));

        for (Line line : lines.getLines()) {
            line.getPoints().forEach(point -> {
                System.out.print(point.isLeft() + " ");
            });
            System.out.println();
        }

        assertThat(lines.getLines().size()).isEqualTo(5);
    }

}

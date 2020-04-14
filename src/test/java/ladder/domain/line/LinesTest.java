package ladder.domain.line;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    @Test
    void createLadderLineTest() {
        int personOfCount = 5;
        Lines ladderLine = new Lines(personOfCount);
        assertThat(ladderLine.showLines().size()).isEqualTo(5);
        System.out.println(ladderLine.showLines());
    }
}

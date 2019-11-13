package ladder;

import ladder.domain.Lines;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    private Lines lines;

    @BeforeEach
    void setUp() {
        lines = new Lines(5, 4);
    }

    @Test
    void Lines테스트() {
        assertThat(lines.getLadderLines()).hasSize(5);
    }

    @Test
    void 파라미터있을때_생성자_테스트() {
        String input = "a,b,c,d";
        Lines lines1 = new Lines(5, input);
        assertThat(lines1.getPersons()).hasSize(4);
        assertThat(lines1.getPersons()).containsExactly("a", "b", "c","d");
    }
}

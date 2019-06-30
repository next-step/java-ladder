package nextstep.ladder.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private final int COUNT_OF_HEIGHT = 2;
    private final int COUNT_OF_PERSON = 3;
    private final int LENGTH_OF_POINT = 5;
    private final int LENGTH_OF_PIPELINE = 1;

    private Ladder ladder;

    @BeforeEach
    void setUp() {
        ladder = new Ladder(COUNT_OF_HEIGHT, COUNT_OF_PERSON);
    }

    @DisplayName("실행결과 Line의 문자열 총 길이 체크")
    @Test
    void getFormattedLineTest() {
        assertThat(ladder.getFormattedLine().length()).isEqualTo((COUNT_OF_PERSON * (LENGTH_OF_POINT + LENGTH_OF_PIPELINE) + LENGTH_OF_PIPELINE) * COUNT_OF_HEIGHT);
    }
}

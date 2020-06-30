package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MakeLineWithRandomTest {

    private MakeLineWithRandom makeLineWithRandom;

    @BeforeEach
    public void setUp() {
        makeLineWithRandom = new MakeLineWithRandom();
    }

    @DisplayName("이전값이 true이면 그다음값은 무조건 false")
    @Test
    void createLine() {
        Boolean line = makeLineWithRandom.createLine(true);
        assertThat(line).isEqualTo(false);
    }
}
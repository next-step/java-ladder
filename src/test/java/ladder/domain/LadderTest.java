package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    private Names names;
    private Ladder ladder;

    @BeforeEach
    public void setup() {
        names = new Names(Arrays.asList("aaa", "bbb", "ccc"));
        ladder = new Ladder(names, new Height(5));
    }

    @Test
    @DisplayName("입력된 높이만큼 사다리 줄 생성")
    public void createLadder() {
        assertThat(ladder.size()).isEqualTo(5);
    }

}

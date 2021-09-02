package nextstep.ladder2;

import nextstep.ladder2.domain.Ladder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {
    Ladder ladder;

    @BeforeEach
    void init() {
        int height = 5;
        int countOfPerson = 3;
        ladder = Ladder.of(height, countOfPerson);
    }

    @Test
    @DisplayName("사다리 생성")
    void createLadder() {
        int height = 5;
        assertThat(ladder.getHeightValue()).isEqualTo(height);
    }

    @Test
    @DisplayName("사다리 높이 유효값 체크")
    void createLadderExceptionTest() {
        int height = 0;
        assertThatThrownBy(() -> {
            Ladder ladder = Ladder.of(height, 3);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 전체 생성")
    void createLadderBodyTest() {
        int height = 5;
        int personOfCount = 3;
        Ladder ladder = Ladder.of(height, personOfCount);
        assertThat(ladder.getHeightValue()).isEqualTo(height);
    }
}

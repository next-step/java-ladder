package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @DisplayName("높이를 가지는 사다리 객체를 생성할 수 있다.")
    @Test
    void createLadder() {
        final Height height = Height.of("1");
        Ladder expect = new Ladder(height);

        Ladder actual = new Ladder(height);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("높이당 하나의 라인을 가진다.")
    @Test
    void createLadder2() {
        Height height = Height.of("2");
        Ladder expect = new Ladder(height);

        Ladder actual = new Ladder(height);

        assertThat(actual.lines()).isEqualTo(expect.lines());
    }
}
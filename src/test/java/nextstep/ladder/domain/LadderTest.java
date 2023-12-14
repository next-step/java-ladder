package nextstep.ladder.domain;

import nextstep.ladder.exception.CannotMakeLadderException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    @DisplayName("사다리 높이가 1보다 작은 경우 Exception Throw")
    void ladder_Height_Exception_Test() {
        assertThrows(CannotMakeLadderException.class, () -> Ladder.generate(new LadderInfo(0, 3)));
    }

    @Test
    @DisplayName("높이 만큼 사다리 높이가 생성된다.")
    void line_Vertical_Test() {
        Ladder ladder = Ladder.generate(new LadderInfo(3, 4));
        System.out.println("ladder.toString() = " + ladder.toString());

        assertThat(ladder.getHeight()).isEqualTo(3);
    }
}

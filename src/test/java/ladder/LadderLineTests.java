package ladder;

import ladder.model.LadderLine;
import ladder.model.LadderPole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 라인(가로) 테스트")
public class LadderLineTests {

    @DisplayName("라인 생성 테스트")
    @Test
    public void generateLadderLineTests() {
        assertThatCode(() -> LadderLine.init(7)).doesNotThrowAnyException();
    }

    @DisplayName("라인 생성 - 비정상 테스트")
    @Test
    public void generateLadderLineAbnormalTests() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderLine.init(-13))
                .withMessageContaining("Ladder Pole count must be greater than zero.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderLine.init(0))
                .withMessageContaining("Ladder Pole count must be greater than zero.");
    }

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(LadderPole.of(0)));
    }
}

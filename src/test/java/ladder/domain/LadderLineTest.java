package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class LadderLineTest {
    @Test
    @DisplayName("생성 테스트")
    public void init() {
        int sizeOfPerson = 5;
        assertThatCode(() -> LadderLine.init(sizeOfPerson)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("move 실행 테스트")
    public void move() {
        LadderLine line = LadderLine.init(2);
        assertThatCode(() -> line.move(0)).doesNotThrowAnyException();
    }

}

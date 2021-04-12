package nextstep.ladder.hint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class HintLadderLineTest {

    @DisplayName("LadderLine 인원 수 값으로 초기화 및 생성 테스트")
    @Test
    void init() {
        int sizeOfPerson = 5;
        assertThatCode(() -> HintLadderLine.init(sizeOfPerson)).doesNotThrowAnyException();
    }

    @DisplayName("LadderLine 2명 참여 시 첫 번째 참여자의 이동 테스트")
    @Test
    void move() {
        HintLadderLine line = HintLadderLine.init(2);
        assertThatCode(() -> line.move(0)).doesNotThrowAnyException();
    }
}

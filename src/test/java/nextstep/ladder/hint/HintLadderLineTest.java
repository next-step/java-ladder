package nextstep.ladder.hint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HintLadderLineTest {

    @DisplayName("LadderLine 인원 수 값으로 초기화 및 생성 테스트")
    @Test
    void init() {
        int sizeOfPerson = 5;
        HintLadderLine init = HintLadderLine.init(sizeOfPerson);
        System.out.println(init);
    }

    @DisplayName("LadderLine 2명 참여 시 첫 번째 참여자의 이동 테스트")
    @Test
    void move() {
        HintLadderLine line = HintLadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}

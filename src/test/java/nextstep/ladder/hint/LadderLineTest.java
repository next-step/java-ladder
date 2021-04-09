package nextstep.ladder.hint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderLineTest {

    @DisplayName("LadderLine 인원 수 값으로 초기화 및 생성 테스트")
    @Test
    void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @DisplayName("LadderLine 2명 참여 시 첫 번째 참여자의 이동 테스트")
    @Test
    void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}

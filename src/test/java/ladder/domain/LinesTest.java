package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinesTest {

    @Test
    @DisplayName("참가자 수에 맞게 사다리 라인 생성 확인")
    public void 참가자_사다리_정상적으로_생성되었는지() {
        String names = "yura,yiyi,yoyo";
        Participants ladderMaker = Participants.of(names);
        Lines lines = Lines.of(ladderMaker.getNames().size());
        assertEquals(lines.getLines().size(), 2);
    }
}

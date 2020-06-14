package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderLineTest {
    @Test
    @DisplayName("LadderLine 생성")
    public void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = LadderLine.init(sizeOfPerson);
        assertThat(ladderLine.getPoints().size()).isEqualTo(sizeOfPerson);
    }

    @Test
    @DisplayName("LadderLine 이동")
    public void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}

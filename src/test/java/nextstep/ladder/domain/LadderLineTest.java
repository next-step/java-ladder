package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = LadderLine.init(sizeOfPerson);

        assertThat(ladderLine).isNotNull();
        assertThat(ladderLine.size()).isEqualTo(sizeOfPerson);
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}
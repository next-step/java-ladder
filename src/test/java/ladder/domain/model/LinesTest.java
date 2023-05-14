package ladder.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class LinesTest {
    public Lines ladderGame;

    @BeforeEach
    public void setLadderGame() {
        this.ladderGame = new Lines(4,5 );
    }

    @Test
    public void 테스트() {
        List<Line> lines = ladderGame.getLines();
        for (Line line : lines) {
            System.out.println(line);
        }
    }
}

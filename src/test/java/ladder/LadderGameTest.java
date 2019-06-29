package ladder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderGameTest {
    @Test
    void generate() {
        String names = "pobi,honux,crong,jk";
        int height = 1;
        LadderGame ladder = new LadderGame(names, height);
        LineStrategy strategy = new LineDefaultStrategy.LineEvenStrategy();

        Line line = new Line(4, new LineDefaultStrategy.LineEvenStrategy());
        ArrayList<Line> ladderForm = new ArrayList<>();
        ladderForm.add(line);

        assertThat(ladder.generate(strategy)).isEqualTo(ladderForm);
    }
}

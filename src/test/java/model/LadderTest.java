package model;

import generator.LineGenerator;
import org.junit.Test;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LadderTest {
    @Test
    public void asd() {
        //Ladder ladder = new Ladder("poni,honux,crong,jk", "5", new LineGenerator());

        List<Participant> participants = new LineGenerator().getParticipants("poni,honux,crong,jk");
        ArrayList<Line> lines = new ArrayList<Line>();

        lines.add(Line.of(5, new int[]{0,2}));
        lines.add(Line.of(5, new int[]{1}));
        lines.add(Line.of(5, new int[]{0}));
        lines.add(Line.of(5, new int[]{1}));
        lines.add(Line.of(5, new int[]{0,2}));

        ResultView.printResult(participants, lines);
    }

}

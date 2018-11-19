package model;

import generator.AutoLadderGenerator;
import generator.LadderGenerator;
import org.junit.Test;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LadderTest {
    @Test
    public void asd() {


        List<Participant> participants = Participant.getParticipants("poni,honux,crong,jk");
        ArrayList<Line> lines = new ArrayList<Line>();

        lines.add(Line.of(4, Arrays.asList(Positive.of(0), Positive.of(2))));
        lines.add(Line.of(4, Arrays.asList(Positive.of(1))));
        lines.add(Line.of(4, Arrays.asList(Positive.of(0))));
        lines.add(Line.of(4, Arrays.asList(Positive.of(1))));
        ResultView.printResult(participants, lines);
    }

}

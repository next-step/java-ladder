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
	
	    lines.add(Line.of(4, Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT)));
	    lines.add(Line.of(4, Arrays.asList(Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT)));
	    lines.add(Line.of(4, Arrays.asList(Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT, Direction.STRAIGHT)));
	    lines.add(Line.of(4, Arrays.asList(Direction.STRAIGHT, Direction.RIGHT, Direction.LEFT, Direction.STRAIGHT)));
        ResultView.printResult(participants, lines, Result.getResults("꽝,2000,꽝2,3000"));
    }

}

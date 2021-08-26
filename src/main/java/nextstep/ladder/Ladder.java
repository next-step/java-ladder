package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private Participants participants;
    private List<Line> lines;
    private RandomPoint randomPoint;

    private Ladder(Participants participants, RandomPoint randomPoint, int depth) {
        this.participants = participants;
        this.randomPoint = randomPoint;
        lines = new ArrayList<>();
        for (int high = 0; high < depth; high++) {
            lines.add(Line.of(participants.size() - 1, randomPoint));
        }
        System.out.println(lines);

    }

    public static Ladder of(Participants participants, RandomPoint randomPoint, int depth) {
        return new Ladder(participants, randomPoint, depth);
    }

    public static Ladder of(LadderInput input) {
        return new Ladder(input.getParticipants(), input.getRandomPoint(), input.getDepth());
    }


    public int getDepth() {
        return lines.size();
    }

    public int getParticipantsCount() {
        return participants.size();
    }

    public List<String> getNames() {
        return participants.getNames();
    }

    public int getLineSize(){
        return lines.get(0).getSize();
    }
}

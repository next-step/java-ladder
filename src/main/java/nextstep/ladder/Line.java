package nextstep.ladder;

import nextstep.ladder.participant.Participant;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    private Line(int size, MiddleLadder random) {
        for (int i = 0; i < size; i++) {
            points.add(random.makeBoolean());
        }
        random.resetLine();
    }

    public static Line of(int size, MiddleLadder random) {
        return new Line(size, random);
    }


    public int getSize() {
        return points.size();
    }

    public List<Boolean> pointLists() {
        return new ArrayList<Boolean>(points);
    }


}

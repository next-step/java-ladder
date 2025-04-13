package nextstep.ladder.domain;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderNavigator {

    private final Ladder ladder;
    private final JunctionMover mover = new JunctionMover();

    public LadderNavigator(Ladder ladder) {
        this.ladder = ladder;
    }

    public LadderResults navigate() {
        Map<ParticipantName, String> results = new LinkedHashMap<>();

        for (Leg leg : ladder.getLegs()) {
            ParticipantName name = leg.getName();
            Junction start = leg.getStart();
            Junction result = mover.moveToEnd(start, name);

            results.put(name, result.getResult());
        }

        return new LadderResults(results);
    }

}

package nextstep.ladder.domain;

import java.util.Collections;

public class LadderExecutor {

    private Lines lines;
    private Participants participants;

    public LadderExecutor(Lines lines, Participants participants) {
        this.lines = lines;
        this.participants = participants;
    }

    public MachingResult play() {
        MachingResult results = new MachingResult(Collections.emptyMap());
        for (int i = 0; i < participants.size(); i++) {
            Position position = new Position(i, 0);
            moveAndCollectResult(results, position);
        }
        return results;
    }

    private void moveAndCollectResult(MachingResult results, Position position) {
        for (Line line : lines.getLines()) {
            Point point = PointFactory.generatePoint(position.getX(), line);
            position.move(point.getDirection());
        }
        results.addResult(position.getInitialX(), position.getX());
    }

}

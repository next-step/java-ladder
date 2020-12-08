package ladder.domain;


import ladder.domain.ladder.LineGenerator;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LadderGame {

    private LineGenerator mover;

    public LadderGame(LineGenerator mover) {
        this.mover = mover;
    }

    public Participants participatePeople(List<String> people) {
        List<Participant> persons = people.stream()
                .map(userName -> new Participant(userName))
                .collect(Collectors.toList());

        return new Participants(persons);
    }

    public Ladder makeLadder(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = mover.generateLine(width);
            lines.add(line);
        };
        return new Ladder(lines);
    }


}

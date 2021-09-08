package nextstep.labber;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final int ladderHeight;
    private final List<Line> ladder;
    private final List<User> participants;

    public Ladder(int ladderHeight, List<User> participants) {
        this.ladderHeight = ladderHeight;
        this.participants = participants;
        this.ladder = this.createLadder();
    }

    public Ladder(int ladderHeight, List<Line> ladder, List<User> participants) {
        this.ladderHeight = ladderHeight;
        this.ladder = ladder;
        this.participants = participants;
    }

    private List<Line> createLadder() {
        return Stream.generate(() -> new Line(this.participants.size()))
                .limit(this.ladderHeight)
                .collect(Collectors.toList());
    }

    public Map<String, Integer> findAllResult() {
        Map<String, Integer> result = new HashMap<>();

        IntStream.range(0 , this.participants.size())
                .forEach(index -> {
                    result.put(this.participants.get(index).toString(), this.findProductNumber(index));
                });
        return result;
    }

    private int findProductNumber(int location) {
        for (int i = 0; i < this.ladder.size(); i++) {
            Line line = this.ladder.get(i);
            location = this.move(location, line);
        }
        return location;
    }

    private int move(int location, Line line) {
        if (line.move(location) == Compass.RIGHT) {
            return location + 1;
        }

        if (line.move(location) == Compass.LEFT) {
            return location -1 ;
        }
        return location;
    }

    public List<Line> ladder() {
        return this.ladder;
    }
}

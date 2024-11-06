package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladders {
    private final int height;
    private final List<Lines> ladder;

    public Ladders(int height, int numberOfPlayers) {
        this.height = height;
        this.ladder = createLadders(height, numberOfPlayers);
    }

    public Ladders(int height, List<Lines> ladders) {
        this.height = height;
        this.ladder = ladders;
    }

    private List<Lines> createLadders(int height, int numberOfPlayers) {
        return IntStream.rangeClosed(1, height)
                .mapToObj(i -> new Lines(numberOfPlayers))
                .collect(Collectors.toList());
    }

    public void createLines() {
        ladder.forEach(Lines::generateConnections);
    }

    public int traverseLadderDown(int playerIndex) {
        int location = playerIndex;
        for (int i = 0; i < height; i++) {
            Lines lines = ladder.get(i);
            Line line = lines.getLineOfSpecificLocation(location);
            location = line.tryMove(location);
        }
        return location;
    }

    public String getLadderState() {
        return ladder.stream()
                .map(Lines::getLinesState)
                .collect(Collectors.joining());
    }

    public int getLadderHeight() {
        return ladder.size();
    }

}

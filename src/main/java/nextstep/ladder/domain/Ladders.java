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

    private List<Lines> createLadders(int height, int numberOfPlayers) {
        return IntStream.rangeClosed(1, height)
                .mapToObj(i -> new Lines(numberOfPlayers))
                .collect(Collectors.toList());
    }

    public void createLines() {
        ladder.forEach(Lines::generateConnections);
    }

    public String getLadderState() {
        return ladder.stream()
                .map(Lines::getLinesState)
                .collect(Collectors.joining());
    }

}

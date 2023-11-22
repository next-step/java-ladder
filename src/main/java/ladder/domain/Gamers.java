package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gamers {

    private final Names names;
    private final Positions positions;

    public Gamers(Names names, Positions positions) {
        this.names = names;
        this.positions = positions;
    }

    public static Gamers createGamers(Names names) {
        List<Integer> positions = IntStream.range(0, names.countPlayers())
                .boxed()
                .collect(Collectors.toList());

        return new Gamers(names, Positions.createBasePositions(positions));
    }

    public int countGamers() {
        return names.countPlayers();
    }

    public void recordEndPosition(List<Position> endPositions) {
        this.positions.recordEndPosition(endPositions);
    }

    public Names getNames() {
        return this.names;
    }

    public Name findName(int index) {
        return this.names.getName(index);
    }

    public Position findPosition(int index) {
        return this.positions.getPosition(index);
    }
}

package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> ladder;
    private final int numberOfPlayers;

    private final PointFactory pointFactory = new DefaultPointFactory();

    public Ladder(int numberOfPlayers, LineCreator lineCreator) {
        this.numberOfPlayers = numberOfPlayers;
        this.ladder = lineCreator.createLine(numberOfPlayers, pointFactory);
    }

    public MoveResult movePlayer(int playerIndex) {
        MoveResult moveResult = new MoveResult();

        moveResult.put(playerIndex, move(playerIndex));

        return moveResult;
    }

    public MoveResult movePlayer() {
        MoveResult moveResult = new MoveResult();

        for (int playerIndex = 0; playerIndex < numberOfPlayers; playerIndex++) {
            moveResult.put(playerIndex, move(playerIndex));
        }

        return moveResult;
    }

    private int move(int index) {
        for (Line line : ladder) {
            index = line.move(index);
        }

        return index;
    }

    @Override
    public String toString() {
        return linesToString();
    }

    private String linesToString() {
        return ladder.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }


}

package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> ladder;
    private final int numberOfPlayers;

    private final PointFactory pointFactory = new DefaultPointFactory();

    public Ladder(int ladderHeight, int numberOfPlayers) {
        checkLadderHeight(ladderHeight);

        this.numberOfPlayers = numberOfPlayers;
        this.ladder = createLine(ladderHeight);
    }

    public Ladder(List<Line> ladder, int numberOfPlayers) {
        this.ladder = ladder;
        this.numberOfPlayers = numberOfPlayers;
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

    private List<Line> createLine(int ladderHeight) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(this.numberOfPlayers, pointFactory));
        }

        return lines;
    }

    private void checkLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException("높이는 1 이상으로 설정 하세요");
        }
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

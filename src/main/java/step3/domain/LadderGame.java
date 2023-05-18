package step3.domain;

import java.util.stream.IntStream;

public class LadderGame {
    private final Ladder ladder;
    private Position[] positions;

    public LadderGame(Ladder ladder, int countOfPlayers) {
        this.ladder = ladder;
        this.positions = new Position[countOfPlayers];
    }

    public Position[] getPosition() {
        initPosition();
        ladder.getPosition(positions);
        return positions;
    }

    private void initPosition() {
        Line firstLine = ladder.ladderStream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사다리의 line 이 없습니다."));
        IntStream.range(0, firstLine.size())
                .forEach(idx -> {
                    positions[idx] = new Position(idx, firstLine.getPoints().get(idx));
                    positions[idx].position = positions[idx].move();
                });
        ladder.removeByIndex(0);
    }
}

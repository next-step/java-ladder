package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    public final Players players;
    private final PointFactory pointFactory = new DefaultPointFactory();

    public final List<Line> ladder;

    public Ladder(int ladderHeight, Players players) {
        checkLadderHeight(ladderHeight);

        this.players = players;

        this.ladder = createLine(ladderHeight);
    }

    @Override
    public String toString() {
        return players.toString() + "\n" + linesToString();
    }

    private String linesToString() {
        return ladder.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }

    private List<Line> createLine(int ladderHeight) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < ladderHeight; i++) {
            lines.add(new Line(players.numberOfPlayers(), pointFactory));
        }

        return lines;
    }

    private void checkLadderHeight(int ladderHeight) {
        if (ladderHeight <= 0) {
            throw new IllegalArgumentException("높이는 1 이상으로 설정 하세요");
        }
    }
}

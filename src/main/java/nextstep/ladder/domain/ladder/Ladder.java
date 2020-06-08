package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exceptions.InvalidLadderHeightException;
import nextstep.ladder.domain.player.Player;
import nextstep.ladder.domain.player.Players;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int MIN_HEIGHT = 1;

    private List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public static Ladder create(int ladderHeight, int countOfPerson, PointAddStrategy pointAddStrategy) {
        validateLadderHeight(ladderHeight);
        List<Line> lines = IntStream.range(0, ladderHeight)
                .mapToObj(num -> LineFactory.create(countOfPerson, pointAddStrategy))
                .collect(Collectors.toList());
        return new Ladder(lines);
    }

    public int getHeight() {
        return lines.size();
    }

    public List<Line> getLines() {
        return new ArrayList<>(this.lines);
    }

    private static void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_HEIGHT) {
            throw new InvalidLadderHeightException("Ladder height must exceed zero");
        }
    }

    public void playGame(Player player) {
        lines.stream()
                .map(line -> line.whereToMove(player.move(HorizontalMoveStrategy.STAY).parseIndexNumber()))
                .forEach(player::move);
    }

    public void playGameWithAllPlayers(Players players) {
        players.playLadderGame(this);
    }
}

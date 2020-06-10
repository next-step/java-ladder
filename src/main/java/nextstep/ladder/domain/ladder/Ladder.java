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

    private List<LadderLine> ladderLines;

    private Ladder(List<LadderLine> ladderLines) {
        this.ladderLines = new ArrayList<>(ladderLines);
    }

    public static Ladder create(int ladderHeight, int countOfPerson, PointAddStrategy pointAddStrategy) {
        validateLadderHeight(ladderHeight);
        List<LadderLine> ladderLines = IntStream.range(0, ladderHeight)
                .mapToObj(num -> LadderLineFactory.create(countOfPerson, pointAddStrategy))
                .collect(Collectors.toList());
        return new Ladder(ladderLines);
    }

    public int getHeight() {
        return ladderLines.size();
    }

    public List<LadderLine> getLadderLines() {
        return new ArrayList<>(this.ladderLines);
    }

    private static void validateLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_HEIGHT) {
            throw new InvalidLadderHeightException("Ladder height must exceed zero");
        }
    }

    public void playGame(Player player) {
        ladderLines.stream()
                .map(ladderLine -> ladderLine.move(player.move(HorizontalMoveStrategy.STAY).parseIndexNumber()))
                .forEach(player::move);
    }

    public void playGameWithAllPlayers(Players players) {
        players.playLadderGame(this);
    }
}

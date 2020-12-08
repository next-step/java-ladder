package nextstep.ladder.entity.ladder;

import nextstep.ladder.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<LadderLine> ladderLines = new ArrayList<>();
    private Users users;
    private GameResults gameResults;

    public static Ladder init(LadderHeight ladderHeight, int sizeOfPerson) {
        Ladder ladder = new Ladder();
        for (int count = 0; count < ladderHeight.getValue(); count++) {
            ladder.addLadderLine(LadderLine.init(sizeOfPerson));
        }
        return ladder;
    }

    private void addLadderLine(LadderLine ladderLine) {
        this.ladderLines.add(ladderLine);
    }

    public int goDown(int startPosition) {

        int currentPosition = startPosition;

        for (int currentLine = 0; currentLine < ladderLines.size(); currentLine++) {
            currentPosition = ladderLines
                    .get(currentLine)
                    .move(currentPosition);
        }

        return currentPosition;
    }

    public GameResult goDown(User user) {
        int startPosition = users.getPosition(user);
        int arrivalPosition = goDown(startPosition);
        gameResults.map(user, arrivalPosition);
        return gameResults.getGameResult(user);
    }

    public LadderLine on(int floor) {
        return this.ladderLines.get(floor);
    }

    public LadderHeight getHeight() {
        return new LadderHeight(this.ladderLines.size());
    }

    public void participants(Users users) {
        this.users = users;
    }

    public void gameResults(GameResults gameResults) {
        this.gameResults = gameResults;
    }
}

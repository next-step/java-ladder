package ladder.model;

import java.util.*;

public class GameResult {
    private final List<GameResultItem> gameResultItems = new ArrayList<>();

    public GameResult() {}

    public void addResult(Participant participant, ResultItem resultItem) {
        gameResultItems.add(new GameResultItem(participant, resultItem));
    }

    public List<GameResultItem> getGameResultItems() {
        return Collections.unmodifiableList(gameResultItems);
    }

    public GameResultItem getResult(String name) {
        return gameResultItems.stream()
                .filter(gameResultItem -> gameResultItem.isMatchParticipant(name))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

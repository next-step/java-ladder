package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {

    private final LadderData ladderData;
    private final List<Line> lines;
    private final LadderResult ladderResult;

    public Ladder(LadderData ladderData) {
        this.ladderData = ladderData;
        int nameLength = ladderData.getPlayerCount();

        lines = Stream.generate(() -> new Line(nameLength, RandomSingleton::nextBoolean))
                .limit(ladderData.getHeight())
                .collect(Collectors.toList());

        ladderResult = new LadderResult(ladderData, lines);
    }

    public List<String> getNames() {
        return ladderData.getPlayerNames();
    }

    public List<String> getLadderString() {
        return lines.stream()
                .map(line -> lineToString(line.getPoints()))
                .collect(Collectors.toList());
    }

    private String lineToString(List<String> line) {
        return String.join("", line);
    }

    public String searchReward(String playerName) {
        int playerIndex = ladderData.getPlayerIndex(playerName);
        int rewardIndex = ladderResult.searchRewardIndex(playerIndex);
        return ladderData.getReward(rewardIndex);
    }
}

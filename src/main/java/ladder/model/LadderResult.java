package ladder.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LadderResult {

    private static final String ALL_USERNAME = "all";

    private final LadderSlotsPair ladderSlotsPair;
    private final Map<Integer, Integer> relations;

    public LadderResult(LadderSlotsPair ladderSlotsPair, Map<Integer, Integer> relations) {
        this.ladderSlotsPair = ladderSlotsPair;
        this.relations = relations;
    }

    public boolean hasUserName(String name) {
        return ALL_USERNAME.equals(name) || ladderSlotsPair.hasUserName(name);
    }

    public String getGameResult(String targetName) {
        if (ALL_USERNAME.equals(targetName)) {
            return getAllUserResults();
        }

        return getResultName(targetName);
    }

    private String getAllUserResults() {
        List<String> userNames = ladderSlotsPair.getUserNames();
        return userNames.stream()
                .map(user -> user + " : " + getResultName(user))
                .collect(Collectors.joining("\n"));
    }

    private String getResultName(String targetName) {
        int upperSlotIndex = ladderSlotsPair.userNameIndex(targetName);
        int lowerSlotIndex = relations.get(upperSlotIndex);
        return ladderSlotsPair.indexedResult(lowerSlotIndex);
    }
}

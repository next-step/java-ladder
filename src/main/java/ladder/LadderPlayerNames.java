package ladder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LadderPlayerNames {
    private final List<LadderPlayerName> ladderPlayerNames;

    private LadderPlayerNames(List<LadderPlayerName> ladderPlayerNames) {
        this.ladderPlayerNames = ladderPlayerNames;
    }

    public static LadderPlayerNames of(String playerNamesString) {
        String[] playerNameStrings = playerNamesString.split(",");

        List<LadderPlayerName> ladderPlayerNames = Arrays.stream(playerNameStrings)
                                                         .map(String::trim)
                                                         .map(LadderPlayerName::of)
                                                         .collect(Collectors.toList());

        return new LadderPlayerNames(ladderPlayerNames);
    }

    public int size() {
        return this.ladderPlayerNames.size();
    }

    @Override
    public String toString() {
        return this.ladderPlayerNames.stream()
                                     .map(LadderPlayerName::toString)
                                     .collect(Collectors.joining(" "));
    }
}

package ladder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public int countOfPerson() {
        return this.ladderPlayerNames.size();
    }

    public List<Integer> getIndexesOf(String personName) {
        if ("all".equals(personName)) {
            return Collections.unmodifiableList(getLadderIndexes());
        }

        int indexOf = indexOf(personName);

        if (indexOf == -1) {
            throw new IllegalArgumentException("the person name \"" + personName +"\" is not contained");
        }

        return Collections.singletonList(indexOf);
    }

    public String getPlayerName(int index) {
        if (index < 0 || index >= countOfPerson()) {
            throw new IllegalArgumentException("the range of index should between 0 and " + (countOfPerson() - 1));
        }

        return this.ladderPlayerNames.get(index)
                                     .getName();
    }

    public List<String> getPlayerNames() {
        return this.ladderPlayerNames.stream()
                                     .map(LadderPlayerName::getName)
                                     .collect(Collectors.toList());
    }

    private List<Integer> getLadderIndexes() {
        return IntStream.range(0, countOfPerson())
                        .boxed()
                        .collect(Collectors.toList());
    }

    private int indexOf(String personName) {
        return IntStream.range(0, countOfPerson())
                        .filter(index -> isEqualsNameAt(personName, index))
                        .findFirst()
                        .orElse(-1);

    }

    private boolean isEqualsNameAt(String personName, int index) {
        LadderPlayerName playerName = this.ladderPlayerNames.get(index);
        return playerName.isEquals(personName);
    }

    @Override
    public String toString() {
        return this.ladderPlayerNames.stream()
                                     .map(LadderPlayerName::toString)
                                     .collect(Collectors.joining(" "));
    }
}

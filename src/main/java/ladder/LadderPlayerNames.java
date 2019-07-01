package ladder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    public int size() {
        return this.ladderPlayerNames.size();
    }

    public List<Integer> getIndexesOf(String personName) {
        if (personName.equals("all")) {
            return Collections.unmodifiableList(getLadderIndexes());
        }

        int indexOf = indexOf(personName);

        if (indexOf == -1) {
            throw new IllegalArgumentException("the person name " + personName +" is not contained");
        }

        return Collections.singletonList(indexOf);
    }

    @Override
    public String toString() {
        return this.ladderPlayerNames.stream()
                                     .map(LadderPlayerName::toString)
                                     .collect(Collectors.joining(" "));
    }

    private List<Integer> getLadderIndexes() {
        return IntStream.range(0, size())
                        .boxed()
                        .collect(Collectors.toList());
    }

    private int indexOf(String personName) {
        return IntStream.range(0, size())
                        .filter(index -> {
                            LadderPlayerName playerName = this.ladderPlayerNames.get(index);
                            String sPlayerName = playerName.getName();
                            return Objects.equals(personName, sPlayerName);
                        })
                        .findFirst()
                        .orElse(-1);

    }
}

package domain.ladder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ladders {

    private final List<Ladder> ladders;

    public Ladders(List<Ladder> ladders) {
        this.ladders = Collections.unmodifiableList(ladders);
    }

    public int height() {
        return this.ladders.size();
    }

    public List<Integer> move(int... lineIndexes) {
        return Arrays.stream(lineIndexes)
                .mapToObj(this::move)
                .collect(Collectors.toList());
    }

    public int move(int lineIndex) {
        int nextIndex = lineIndex;
        for (Ladder ladder : this.ladders) {
            nextIndex = ladder.move(nextIndex);
        }
        return nextIndex;
    }

    public String beautify() {
        return ladders.stream()
                .map(Ladder::beautify)
                .collect(Collectors.joining("\n"));
    }
}

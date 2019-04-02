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

    public List<Integer> move(int... positions) {
        return Arrays.stream(positions)
                .mapToObj(this::move)
                .collect(Collectors.toList());
    }

    public int move(int position) {
        int nextIndex = position;
        for (Ladder ladder : this.ladders) {
            nextIndex = ladder.move(nextIndex);
        }
        return nextIndex;
    }

    public String beautify() {
        return this.ladders.stream()
                .map(Ladder::beautify)
                .collect(Collectors.joining("\n"));
    }

    public int size() {
        if (this.ladders.isEmpty()) {
            return 0;
        }

        return this.ladders.get(0).size();
    }

}

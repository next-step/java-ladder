package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladders {

    private final List<Ladder> ladders;

    private Ladders(List<Ladder> ladders) {
        this.ladders = Collections.unmodifiableList(ladders);
    }

    public static Ladders generate(int height, int size) {
        List<Ladder> ladders = IntStream.range(0, height)
                .mapToObj(i -> new Ladder(size))
                .collect(Collectors.toList());

        return new Ladders(ladders);
    }

    public int height() {
        return this.ladders.size();
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    @Override
    public String toString() {
        return ladders.stream()
                .map(Ladder::toString)
                .collect(Collectors.joining("\n"));
    }
}

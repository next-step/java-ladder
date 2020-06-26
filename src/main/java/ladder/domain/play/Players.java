package ladder.domain.play;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Players extends Items {
    public static final String PLAYERS_ALL = "all";

    private Players(List<String> items) {
        super(items);
    }

    public static Players of(List<String> names) {
        return new Players(names);
    }

    public List<Integer> findIndexesBy(String name) {
        if (name.equals(PLAYERS_ALL)) {
            return IntStream.range(0, this.size())
                    .boxed()
                    .collect(Collectors.toList());
        }

        return Arrays.asList(super.findIndexBy(name));
    }
}
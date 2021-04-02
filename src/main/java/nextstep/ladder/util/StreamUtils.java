package nextstep.ladder.util;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class StreamUtils {

    private StreamUtils() {
    }

    public static <T> Stream<Pair<T, T>> pairStream(List<T> elements) {
        if (elements.size() < 2) {
            return Stream.empty();
        }

        return IntStream.range(0, elements.size() - 1)
                        .mapToObj(i -> new Pair<>(elements.get(i), elements.get(i + 1)));
    }

}

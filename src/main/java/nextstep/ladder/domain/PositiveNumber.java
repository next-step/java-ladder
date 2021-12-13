package nextstep.ladder.domain;

import static nextstep.ladder.utils.IntegerUtils.getNumberIfPositive;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class PositiveNumber {

    private static final Map<Integer, PositiveNumber> cache = new HashMap<>();

    private static final int CACHE_MIN_NUMBER = 1;
    private static final int CACHE_MAX_NUMBER = 100;

    private final int number;

    static {
        IntStream.range(CACHE_MIN_NUMBER, CACHE_MAX_NUMBER)
            .forEach(number -> cache.put(number, new PositiveNumber(number)));
    }

    private PositiveNumber(int number) {
        this.number = getNumberIfPositive(number);
    }

    public static PositiveNumber create(int number) {
        return cache.getOrDefault(number, new PositiveNumber(number));
    }

    public int getNumber() {
        return number;
    }

}

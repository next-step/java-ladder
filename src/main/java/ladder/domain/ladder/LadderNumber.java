package ladder.domain.ladder;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderNumber {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create LadderNo failed. number must be at least %d : number=%d";
    private static final int MINIMUM_NUMBER = 0;
    private int number;

    private static final Map<Integer, LadderNumber> numberMap;

    static { //10개 캐싱으로 넣어둠.
        numberMap = IntStream.range(MINIMUM_NUMBER, 10)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), LadderNumber::new));
    }

    private LadderNumber(int number) {
        this.number = number;
    }

    public static LadderNumber of(int number) {
        return Optional.of(number)
                .filter(v -> v >= MINIMUM_NUMBER)
                .map(numberMap::get)
                .orElseGet(() -> Optional.of(number)
                        .filter(v -> v >= MINIMUM_NUMBER)
                        .map(LadderNumber::new)
                        .map(instance -> numberMap.putIfAbsent(number, instance)) //캐시에 없으면 캐시에 추가하는 부분
                        .orElseThrow(() -> throwIllegalArgumentException(number)));
    }

    private static IllegalArgumentException throwIllegalArgumentException(int number) {
        return new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, MINIMUM_NUMBER, number));
    }

    int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "LadderNumber{" +
                "number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderNumber ladderNumber1 = (LadderNumber) o;
        return number == ladderNumber1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}

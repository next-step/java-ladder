package step2.model;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class PrizeLocation {
    public static final int ZERO_VALUE = 0;
    private final List<String> prizePoistion;

    private PrizeLocation(List<String> prizePoistion) {
        this.prizePoistion = prizePoistion;
    }

    public static PrizeLocation of(List<String> prizePoistion) {
        return new PrizeLocation(prizePoistion);
    }

    public static PrizeLocation of(String[] prizePosition) {
        return Stream
                .of(prizePosition)
                .collect(collectingAndThen(toList(), PrizeLocation::of))
                ;
    }

    public String getPrizeIntoLocation(int position) {
        validatePositionNumber(position);
        return Optional.of(prizePoistion.get(position))
                .orElseThrow(IllegalArgumentException::new)
                ;
    }

    private void validatePositionNumber(int position) {
        if (position >= prizePoistion.size() || position < ZERO_VALUE) {
            throw new IllegalArgumentException();
        }
    }
}

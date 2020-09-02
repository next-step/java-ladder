package nextstep.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AllDrawTransverseBarStrategy implements TransverseBarStrategy {

    private static final boolean ALL_DRAW = true;

    @Override
    public List<Boolean> draw(int countOfPerson) {
        return IntStream.range(0, countOfPerson - 1)
                .mapToObj(count -> ALL_DRAW)
                .collect(Collectors.toList());
    }

}

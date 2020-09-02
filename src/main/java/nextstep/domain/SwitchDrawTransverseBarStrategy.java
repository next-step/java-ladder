package nextstep.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SwitchDrawTransverseBarStrategy implements TransverseBarStrategy {

    public static final int DIVIDE_EVEN = 2;
    public static final int ZERO = 0;

    @Override
    public List<Boolean> draw(int countOfPerson) {
        return IntStream.range(0, countOfPerson)
                .mapToObj(count -> count % DIVIDE_EVEN == ZERO)
                .collect(Collectors.toList());
    }

}

package nextstep.ladder.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ResultsTest {
    public static final Results RESULTS = new Results(new ArrayList<>(
            Stream.of(new Result("꽝"),
                      new Result("5000"),
                      new Result("꽝"),
                      new Result("3000")
            )
                  .collect(Collectors.toList())));

    public static final Results RESULTS2 = new Results(new ArrayList<>(
            Stream.of(new Result("꽝"),
                      new Result("5000"),
                      new Result("꽝"),
                      new Result("3000"),
                      new Result("꽝")
            )
                  .collect(Collectors.toList())));
}

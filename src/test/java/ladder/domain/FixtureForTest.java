package ladder.domain;

import ladder.view.InputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FixtureForTest {

    public static List<String> namesFixture(String names){
        return Stream.of(names.split(InputView.SPLIT_DELIMITER)).collect(Collectors.toList());
    }

}

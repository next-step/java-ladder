package nextstep.step2.vo;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class Names {

    private static final String NULL_OR_LESS_SIZE_MESSAGE = "최소 두명 이상의 플레이어가 필요합니다.";
    private static final int MIN_PLAYER_COUNT = 2;

    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names create(List<Name> names) {

        if (names == null || names.size() < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(NULL_OR_LESS_SIZE_MESSAGE);
        }

        return new Names(names);
    }

    public static Names createWithString(String input) {

        if (input == null) {
            throw new IllegalArgumentException(NULL_OR_LESS_SIZE_MESSAGE);
        }

        return Arrays.stream(input.split(","))
                .map(Name::create)
                .collect(collectingAndThen(toList(), Names::new));
    }

    public int size() {
        return names.size();
    }
}

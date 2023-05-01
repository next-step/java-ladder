package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Participants {

    private static final int ZERO = 0;

    private final List<Name> names;

    private Participants(List<Name> names) {
        this.names = names;
    }

    public static Participants init(String[] splitNames) {
        hasName(splitNames.length);
        hasSameName(splitNames);

        List<Name> names = initNameList(splitNames);
        return new Participants(names);
    }

    private static List<Name> initNameList(String[] splitNames) {
        return Arrays.stream(splitNames)
                .map(Name::from)
                .collect(Collectors.toList());
    }

    private static void hasName(int numberOfName) {
        if (numberOfName == ZERO) {
            throw new IllegalArgumentException("참가자 이름을 입력해주세요");
        }
    }

    private static void hasSameName(String[] names) {
        Set<String> distinctNames = new HashSet<>(List.of(names));
        if (names.length != distinctNames.size()) {
            throw new IllegalArgumentException("같은 이름을 입력했습니다.");
        }
    }

    @Override
    public String toString() {
        return "" + names;
    }
}

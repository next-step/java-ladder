package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderParser {

    private LadderParser() {
        throw new AssertionError();
    }

    public static List<Person> people(String[] names) {
        return IntStream.range(0, names.length)
                .mapToObj(sequence -> new Person(names[sequence]))
                .collect(Collectors.toUnmodifiableList());
    }

    public static String appendWhiteSpaceInside(String text, int length) {
        return String.format(new StringBuilder()
                .append("%")
                .append(length)
                .append("s")
                .toString(), text);
    }
}

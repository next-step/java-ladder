package ladder.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Names {

    private final List<Name> names;

    public Names(String names) {
        this(ValidNames.toNameList(names));
    }

    public Names(List<Name> names) {
        //null이면 안됨. size 0도 안됨
        this.names = names;
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }

    private static class ValidNames {

        private static final String NAMES_DELIMITER = ",";
        private static final String NULL_MESSAGE = "입력이 null일 수 없습니다.";

        private final String value;

        public ValidNames(String names) {
            if (names == null) {
                throw new IllegalArgumentException(NULL_MESSAGE);
            }
            value = names;
        }

        public static List<Name> toNameList(String names) {
            ValidNames validNames = new ValidNames(names);
            return Arrays.stream(validNames.value.split(NAMES_DELIMITER))
                    .map(Name::new)
                    .collect(Collectors.toList());
        }
    }

}

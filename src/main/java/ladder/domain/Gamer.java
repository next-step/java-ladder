package ladder.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Gamer {
    private static final String NAME_SEPARATOR = ",";
    public static final int MIN_GAMER_COUNT = 2;
    public static final int MAX_GAMER_NAME_LENGTH = 5;

    private List<String> names;

    private Gamer(List<String> names) {
        this.names = names;
    }

    public static Gamer nameOf(String name) throws IllegalArgumentException {
        List<String> names = Arrays.stream(name.split(NAME_SEPARATOR))
                .filter(t -> !StringUtils.isBlank(t) && t.length() <= MAX_GAMER_NAME_LENGTH)
                .collect(Collectors.toList());
        if (names.size() < MIN_GAMER_COUNT) {
            throw new IllegalArgumentException("쉼표로 구분되며 최대 다섯글자 이름을 가지는 게임 참여자를 두명 이상 입력해주세요!");
        }
        return new Gamer(names);
    }

    public List<String> getNames() {
        return names;
    }
}

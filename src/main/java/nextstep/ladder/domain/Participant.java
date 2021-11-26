package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Participant {

    protected static final String ILLEGAL_LENGTH_ERROR_MESSAGE = "이름의 길이는 1이상 5이하만 가능합니다.";
    protected static final int MIN_LENGTH = 1;
    protected static final int MAX_LENGTH = 5;

    private final String name;

    public static List<Participant> listOf(List<String> names) {
        List<Participant> list = new ArrayList<>();
        for (String name : names) {
            Participant participant = new Participant(name);
            list.add(participant);
        }
        return unmodifiableList(list);
    }

    public Participant(String name) {
        checkLength(name);
        this.name = name;
    }

    private void checkLength(String name) {
        if (name == null || name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ILLEGAL_LENGTH_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}

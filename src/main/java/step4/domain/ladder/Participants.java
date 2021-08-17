package step4.domain.ladder;

import java.util.Collections;
import java.util.List;

public class Participants {
    private final List<String> names;

    private Participants(List<String> names) {
        this.names = names;
    }

    public static Participants of(List<String> names) {
        return new Participants(names);
    }

    public List<String> inline() {
        return Collections.unmodifiableList(names);
    }

    public int findPositionOf(String name) {
        if (nameIsNotInTheList(name)) {
            throw new RuntimeException("해당 이름이 참가자중에 없습니다.");
        }
        return names.indexOf(name);
    }

    private boolean nameIsNotInTheList(String name) {
        return !names.contains(name);
    }

    public int size() {
        return names.size();
    }
}


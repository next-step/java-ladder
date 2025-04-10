package nextstep.ladder;

import java.util.List;

public class Names {

    private final List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names of(List<Name> names) {
        return new Names(names);
    }

    public int getLength() {
        return names.size();
    }

    public int getIndex(Name name) {
        int index = names.indexOf(name);
        if (index == -1) {
            throw new IllegalArgumentException("이름이 존재하지 않습니다.");
        }
        return index;
    }

    public List<Name> getListNames() {
        return names;
    }
}

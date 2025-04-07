package nextstep.ladder.module;

import java.util.List;

public class NameList implements Iterable<String> {
    private final List<String> names;

    public NameList(List<String> names) {
        validate(names);
        this.names = names;
    }

    public List<String> value() {
        return names;
    }

    public int size() {
        return names.size();
    }

    @Override
    public java.util.Iterator<String> iterator() {
        return names.iterator();
    }

    private void validate(List<String> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("이름 리스트는 비어있을 수 없습니다.");
        }

        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("이름 리스트는 중복된 이름을 포함할 수 없습니다.");
        }

        if (names.size() < 2) {
            throw new IllegalArgumentException("이름 리스트는 최소 2개의 이름을 포함해야 합니다.");
        }
    }
}

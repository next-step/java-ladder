package ladder.name;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Names {
    private static final int ZERO = 0;
    private final List<Name> names;

    public Names(List<String> names) {
        Set<String> uniqueNames = new HashSet<>(names);
        if (uniqueNames.size() != names.size()) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
        }

        this.names = names.stream()
                .map(Name::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Name> getNames() {
        return names;
    }

    public boolean hasDifferentSize(int size) {
        return names.size() != size;
    }

    public int getSize() {
        return names.size();
    }

    public Name getName(int index) {
        if (index < ZERO || index >= names.size()) {
            throw new IllegalArgumentException("찾을 수 없는 이름입니다");
        }
        return names.get(index);
    }
    public String getNameOf(int index) {
        if (index < ZERO || index >= names.size()) {
            throw new IllegalArgumentException("찾을 수 없는 이름입니다");
        }
        return names.get(index).getName();
    }
}

package ladder.name;

import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final int ZERO = 0;
    private final List<Name> names;

    public Names(List<String> names) {
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

    public String getNameOf(int index) {
        if(index < ZERO || index >= names.size()) {
            throw new IllegalArgumentException("찾을 수 없는 이름입니다");
        }
        return names.get(index).getName();
    }
}

package ladder.domain.core.line.name;

import java.util.List;

import static java.util.stream.Collectors.toList;

public abstract class Names<T extends Name> {

    private final List<T> names;

    Names(List<T> names) {
        this.names = names;
    }

    int indexOf(T name) {
        return names.indexOf(name);
    }

    int getCount() {
        return names.size();
    }

    public List<String> getPrimitiveNames(){
        return names.stream()
                    .map(Name::getName)
                    .collect(toList());
    }

    String get(int index) {
        return names.get(index)
                    .getName();
    }
}

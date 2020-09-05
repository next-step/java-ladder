package nextstep.entity;

import java.util.List;
import java.util.stream.Collectors;

public class Entries implements TryCatchable {

    private final List<Entry> entries;

    public Entries(List<Entry> entries) {
        this.entries = entries;
    }

    public List<String> getNames() {
        return this.entries.stream()
                .map(Entry::getName)
                .collect(Collectors.toList());
    }
}

package nextstep.entity;

import java.util.List;
import java.util.stream.Collectors;

public class Entries {

    private final List<Entry> entries;

    private Entries(List<Entry> entries) {
        this.entries = entries;
    }

    public int getPersonnel() {
        return entries.size();
    }

    public static Entries of(List<String> names) {
        List<Entry> entries = names.stream()
                .map(Entry::of)
                .collect(Collectors.toList());
        return new Entries(entries);
    }
}

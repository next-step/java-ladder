package nextstep.entity;

import java.util.List;
import java.util.stream.Collectors;

public class Entries {

    private final List<Entry> entries;

    private Entries(List<Entry> entries) {
        validate(entries);
        this.entries = entries;
    }

    private void validate(List<Entry> entries) throws IllegalArgumentException {
        Set<Entry> set = new HashSet<>(entries);
        if (set.size() != entries.size()) {
            throw new IllegalArgumentException("중복된 이름이 있어요.");
        }
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

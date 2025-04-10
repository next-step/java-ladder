package nextstep.ladder.player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Entries {
    private List<Entry> entries;

    public Entries(String[] names) {
        this(Stream.of(names)
                .map(Entry::new)
                .collect(Collectors.toList()));
    }

    public Entries(List<Entry> entries) {
        validateEmpty(entries);
        this.entries = entries;
    }

    private void validateEmpty(List<Entry> entries) {
        if (entries == null || entries.isEmpty()) {
            throw new IllegalArgumentException("사람 목록은 null 또는 빈 목록일 수 없습니다.");
        }
    }

    public int size() {
        return entries.size();
    }

    @Override
    public String toString() {
        return entries.stream()
                .map(Entry::toStringWithBlank)
                .collect(Collectors.joining());
    }
}

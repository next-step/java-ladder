package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Results {
    private List<Entry> entries;

    private Results(List<Entry> entries) {
        this.entries = entries;
    }

    public static Results of(String[] names, Location height) {
        List<Entry> entries = toEntries(names, height);
        validateEmpty(entries);

        return new Results(entries);
    }

    public int size() {
        return entries.size();
    }

    public Map<Entry, Entry> getResults(Players players) {
        return entries.stream()
                .collect(Collectors.toMap(players::getSamePosition, entry -> entry));
    }

    @Override
    public String toString() {
        return entries.stream()
                .map(Entry::toStringWithBlank)
                .collect(Collectors.joining());
    }

    private static List<Entry> toEntries(String[] names, Location height) {
        List<Entry> entries = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            entries.add(new Entry(names[i], new Position(i, height)));
        }
        return entries;
    }

    private static void validateEmpty(List<Entry> entries) {
        if (entries == null || entries.isEmpty()) {
            throw new IllegalArgumentException("사람 목록은 null 또는 빈 목록일 수 없습니다.");
        }
    }
}

package nextstep.ladder;

import nextstep.ladder.line.Line;
import nextstep.ladder.line.Lines;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Players {
    private List<Entry> entries;

    public static Players of(String[] names) {
        List<Entry> entries = toEntries(names);
        validateEmpty(entries);

        return new Players(entries);
    }

    private static List<Entry> toEntries(String[] names) {
        List<Entry> entries = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            entries.add(new Entry(names[i], new Position(i, 0)));
        }
        return entries;
    }

    private Players(List<Entry> entries) {
        this.entries = entries;
    }

    private static void validateEmpty(List<Entry> entries) {
        if (entries == null || entries.isEmpty()) {
            throw new IllegalArgumentException("사람 목록은 null 또는 빈 목록일 수 없습니다.");
        }
    }

    public int size() {
        return entries.size();
    }

    public boolean contains(Name name) {
        return entries.stream()
                .anyMatch(entry -> entry.getName().equals(name));
    }

    public boolean notContains(Name name) {
        return !contains(name);
    }

    public void move(Lines lines) {
        for (int i = 0; i < lines.size(); i++) {
            move(lines.get(i), i);
        }
    }

    private void move(Line line, int height) {
        for (int i = 0; i < this.entries.size(); i++) {
            Entry entry = get(new Position(i, height));
            entry.move(line.getDirection(i));
        }
    }

    public Entry get(Position position) {
        return entries.stream()
                .filter(entry -> entry.isSamePosition(position))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Entry not found"));
    }

    public Entry get(Name name) {
        return entries.stream()
                .filter(entry -> entry.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Entry not found"));
    }

    public Entry getSamePosition(Entry entry) {
        return entries.stream()
                .filter(e -> e.isSamePosition(entry))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Entry not found"));
    }

    @Override
    public String toString() {
        return entries.stream()
                .map(Entry::toStringWithBlank)
                .collect(Collectors.joining());
    }
}

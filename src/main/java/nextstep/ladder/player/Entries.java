package nextstep.ladder.player;

import nextstep.ladder.Position;
import nextstep.ladder.line.Line;
import nextstep.ladder.line.Lines;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Entries {
    private List<Entry> entries;

    public static Entries of(String[] names) {
        List<Entry> entries = toEntries(names);
        validateEmpty(entries);

        return new Entries(entries);
    }

    private static List<Entry> toEntries(String[] names) {
        List<Entry> entries = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            entries.add(new Entry(names[i], new Position(i)));
        }
        return entries;
    }

    private Entries(List<Entry> entries) {
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

    @Override
    public String toString() {
        return entries.stream()
                .map(Entry::toStringWithBlank)
                .collect(Collectors.joining());
    }

    public void move(Lines lines) {
        for (int i = 0; i < lines.size(); i++) {
            move(lines.get(i));
        }
    }

    private void move(Line line) {
        for (int i = 0; i < entries.size(); i++) {
            Entry entry = entries.get(i);
            entry.move(line.getDirection(i));
        }
    }
}

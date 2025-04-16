package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private List<Name> names;

    private Names(List<Name> names) {
        this.names = names;
    }

    public static Names of(String[] namesArr) {
        List<Name> names = toNames(namesArr);
        validateEmpty(names);

        return new Names(names);
    }

    public int size() {
        return names.size();
    }

    public boolean contains(Name name) {
        return names.stream()
                .anyMatch(player -> player.equals(name));
    }

    public boolean notContains(Name name) {
        return !contains(name);
    }

    public Name get(int index) {
        return names.get(index);
    }

    @Override
    public String toString() {
        return names.stream()
                .map(Name::toStringWithBlank)
                .collect(Collectors.joining());
    }

    private static List<Name> toNames(String[] namesArr) {
        List<Name> names = new ArrayList<>();

        for (String name : namesArr) {
            names.add(new Name(name));
        }

        return names;
    }

    private static void validateEmpty(List<Name> names) {
        if (names == null || names.isEmpty()) {
            throw new IllegalArgumentException("사람 목록은 null 또는 빈 목록일 수 없습니다.");
        }
    }
}

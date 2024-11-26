package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Players {

    public static final String DELIMITER = ",";
    private final List<Name> names;

    public Players(List<Name> names) {
        this.names = names;
    }

    public Players(String names) {
        this(toNames(names));
    }

    public int size() {
        return names.size();
    }

    private static List<Name> toNames(String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList())
                .stream()
                .map(Name::new)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Players players = (Players) o;
        return Objects.equals(names, players.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }

    public List<Name> names() {
        return Collections.unmodifiableList(names);
    }

    public Players moveLine(Line line) {
        List<Name> result = new ArrayList<>();
        names.forEach(name -> {
            int index = names.indexOf(name);
            Point point = line.getPoints().get(index);
            int movePoint = point.move().value();
            result.add(names.get(index + movePoint));
        });
        return new Players(result);
    }
}

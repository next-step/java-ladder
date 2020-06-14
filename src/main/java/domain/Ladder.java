package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Person> players;
    private List<Line> lines;

    public Ladder(List<String> players, int height) {
        this.players = players.stream()
                .map(Person::new)
                .collect(Collectors.toList());

        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(players.size()))
                .collect(Collectors.toList());
    }


    public String getPlayerNames() {
        return players.stream()
                .map(Person::toString)
                .collect(Collectors.joining());
    }
}

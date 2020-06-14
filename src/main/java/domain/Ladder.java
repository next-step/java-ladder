package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private List<Person> players;
    private List<Line> lines;

    public Ladder(String[] players, int height) {
        this.players = Arrays.stream(players)
                .map(Person::new)
                .collect(Collectors.toList());

        this.lines = IntStream.range(0, height)
                .mapToObj(i -> new Line(players.length))
                .collect(Collectors.toList());
    }


    public String getPlayerNames() {
        return players.stream()
                .map(Person::toString)
                .collect(Collectors.joining());
    }

    public List<Line> getLines() {
        return lines;
    }
}

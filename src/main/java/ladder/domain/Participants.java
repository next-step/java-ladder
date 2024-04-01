package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {

    private final List<Gamer> gamers;

    public Participants(String inputText) {
        this(inputText.split(","));
    }

    public Participants(String[] names) {
        this(generateGamers(names));
    }

    private static List<Gamer> generateGamers(String[] names) {
        return IntStream.range(0, names.length).mapToObj(num -> new Gamer(names[num], num)).collect(Collectors.toList());
    }

    public Participants(List<Gamer> gamers) {
        this.gamers = gamers;
    }

    public List<Gamer> getNames() {
        return Collections.unmodifiableList(gamers);
    }

    public List<Gamer> startGame(Ladder ladder) {
        return gamers.stream().map(gamer -> gamer.climb(ladder)).collect(Collectors.toUnmodifiableList());
    }

}

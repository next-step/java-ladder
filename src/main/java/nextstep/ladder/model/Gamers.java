package nextstep.ladder.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Gamers {
    private static final String DELIMITER = ",";
    private final List<Gamer> gamers = new ArrayList<>();

    public Gamers(String name) {
        Arrays.stream(name.split(DELIMITER))
                .map(Gamer::new)
                .forEach(gamers::add);
    }

    public int getCountOfPerson() {
        return gamers.size();
    }

    public String getGamers() {
        return gamers.stream()
                .map(Gamer::getName)
                .collect(Collectors.joining(DELIMITER));
    }
}

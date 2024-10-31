package nextstep.ladder.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gamers {
    private static final String DELIMITER = ",";
    private final List<Gamer> gamers;

    public Gamers(String name) {
        this.gamers = Arrays.stream(name.split(DELIMITER))
                .map(Gamer::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean contains(String gamer) {
        return gamers.contains(gamer);
    }

    public int getCountOfPerson() {
        return gamers.size();
    }

    public List<String> getGamerNames() {
        return IntStream.range(0, gamers.size())
                .mapToObj(this::getGamerNameByPosition)
                .collect(Collectors.toList());
    }


    public String getGamerNameByPosition(int position) {
        return gamers.get(position).getName();
    }
}

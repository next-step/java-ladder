package ladder.domain.content.user;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Gamers {
    private static final String DELIMITER = ",";
    private final List<Gamer> gamers;
    
    public Gamers(String names) {
        gamers = Arrays.stream(names.split(DELIMITER))
          .map(Gamer::of)
          .collect(Collectors.toList());
    }
    
    public static Gamers of(String names) {
        return new Gamers(names);
    }
    
    public int getSize() {
        return gamers.size();
    }
}

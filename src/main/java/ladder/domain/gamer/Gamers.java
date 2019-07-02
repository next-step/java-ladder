package ladder.domain.gamer;

import ladder.domain.gamer.info.Gamer;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gamers {
    private static final String DELIMITER = ",";
    private final List<Gamer> gamers;
    
    private Gamers(String names) {
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

    public Stream<Gamer> getStream() {
        return gamers.stream();
    }
    
    public List<String> getGamerNames() {
        return gamers.stream()
          .map(gamer -> gamer.getName())
          .collect(Collectors.toList());
    }
}

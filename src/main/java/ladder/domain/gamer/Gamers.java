package ladder.domain.gamer;

import ladder.domain.gamer.info.Gamer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Gamers {
    private static final String DELIMITER = ",";
    private static final int START_NUMBER = 0;
    
    private final Map<Gamer, Integer> gamers;
    
    private Gamers(String names) {
        gamers = new HashMap<>();
        String[] gamerNames = names.split(DELIMITER);
        IntStream.range(START_NUMBER, gamerNames.length)
          .forEach(index -> gamers.put(Gamer.of(gamerNames[index]), index));
    }
    
    public static Gamers of(String names) {
        return new Gamers(names);
    }
    
    public int getSize() {
        return gamers.keySet().size();
    }

    public List<String> getGamerNames() {
        return gamers.keySet().stream()
          .map(Gamer::getName)
          .collect(Collectors.toList());
    }
}

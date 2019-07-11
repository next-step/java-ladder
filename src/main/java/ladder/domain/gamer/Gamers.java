package ladder.domain.gamer;

import ladder.domain.gamer.info.Gamer;
import ladder.domain.gamer.message.ErrorMessages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Gamers {
    private static final String DELIMITER = ",";
    private final static String FIND_ALL = "all";
    private static final int START_NUMBER = 0;
    
    private final Map<Gamer, Integer> gamers;
    
    private Gamers() {
        this.gamers = new LinkedHashMap<>();
    }
    
    public static Gamers newInstance() {
        return new Gamers();
    }
    
    public List<String> getGamerNames() {
        return gamers.keySet().stream()
            .map(Gamer::getName)
            .collect(Collectors.toList());
    }
    
    public int getLineNumber(Gamer gamer) {
        Integer lineNumber = gamers.get(gamer);
        if (lineNumber == null) {
            throw new IllegalArgumentException(ErrorMessages.NOT_FIND_GAMER.message());
        }
        return lineNumber;
    }
    
    public void addGamers(String gamerNames) {
        String[] names = gamerNames.split(DELIMITER);
        IntStream.range(START_NUMBER, names.length)
          .forEach(index -> gamers.put(Gamer.from(names[index]), index));
    }
    
    public boolean isSameSize(int size) {
        return size == gamers.size();
    }
    
    public boolean isGamerNamesNeeded() {
        return gamers.isEmpty();
    }
    
    public boolean isGamerNameAll(String gamerName) {
        return FIND_ALL.equals(gamerName);
    }
    
    public Stream<Gamer> keyStream() {
        return gamers.keySet().stream();
    }
    
    public int getSize() {
        return gamers.size();
    }
}

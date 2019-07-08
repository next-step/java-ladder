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
    private static final int START_NUMBER = 0;
    
    private final Map<Gamer, Integer> gamers;
    
    public static Gamers newInstance() {
        return new Gamers();
    }
    
    private Gamers() {
        this.gamers = new LinkedHashMap<>();
    }
    
    public int getSize() {
        return gamers.size();
    }
    
    public List<String> getGamerNames() {
        return gamers.keySet().stream()
            .map(Gamer::getName)
            .collect(Collectors.toList());
    }
    
    public int getLineNumber(String gamerName) {
        return getLineNumber(Gamer.from(gamerName));
    }
    
    private int getLineNumber(Gamer gamer) {
        Integer lineNumber = gamers.get(gamer);
        if (lineNumber == null) {
            throw new IllegalArgumentException(ErrorMessages.NOT_FIND_GAMER.message());
        }
        return lineNumber;
    }
    
    public Stream<Gamer> keyStream() {
        return gamers.keySet().stream();
    }
    
    public void addGamers(String gamerNames) {
        String[] names = gamerNames.split(DELIMITER);
        IntStream.range(START_NUMBER, names.length)
          .forEach(index -> gamers.put(Gamer.from(names[index]), index));
    }
    
    public boolean isSameSize(int size) {
        return size == gamers.size();
    }
}

package ladder.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;

public class Ladder {
    
    private final List<Layer> layers;

    private Ladder(List<Layer> layers) {
        this.layers = layers;
    }

    public static Ladder of(List<Layer> layers) {
        return new Ladder(layers);
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public static Ladder create(Height height, int countOfPerson){
        return Stream.generate(() -> Layer.of(countOfPerson))
                     .limit(height.getHeight())
                     .collect(collectingAndThen(Collectors.toList(),Ladder::new));
    }

    public int findPrizePosition(int personPosition) {
        int prizePosition = personPosition;
        for (Layer layer : layers){
            prizePosition = layer.move(prizePosition);
        }
        return prizePosition;
    }

    public Map<String, String> findPrize(LadderGameSetting ladderGameSetting) {
        Persons persons = ladderGameSetting.getPersons();
        Prizes prizes = ladderGameSetting.getPrizes();
        return persons.prizeResult(this, prizes);
    }
}

package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;

public class Ladder {

    private static final String INIT_LINE_SPACE = "      ";
    private static final String NEW_LINE = System.lineSeparator();

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

    public List<ResultPrize> findPrize(LadderGameSetting ladderGameSetting) {
        List<ResultPrize> results = new ArrayList<>();
        int personsCount = ladderGameSetting.getPersonsCount();
        for (int position = 0; position < personsCount; position++){
            int prizeLocation = findPrizePosition(position);
            String personName = ladderGameSetting.getPersonName(position);
            String prizeValue = ladderGameSetting.getPrizeValue(prizeLocation);
            results.add(ResultPrize.of(personName, prizeValue));
        }
        return results;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Layer layer : layers){
            stringBuilder.append(INIT_LINE_SPACE);
            stringBuilder.append(layer.toString());
            stringBuilder.append(NEW_LINE);
        }
        return stringBuilder.toString();
    }
}

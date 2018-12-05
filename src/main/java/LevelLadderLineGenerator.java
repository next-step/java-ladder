import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LevelLadderLineGenerator implements LadderLineGenerator {
    public static final int MAX = 100;
    private Level level;

    private LevelLadderLineGenerator() {
        throw new IllegalStateException();
    }

    public LevelLadderLineGenerator(Level level) {
        this.level = level;
    }

    @Override
    public boolean generatePoint() {
        return RANDOM.nextInt(MAX) < level.getProbability().getValue();
    }

    @Override
    public List<LadderLine> getLadderLines(int sizeOfPerson) {
        return IntStream.range(0, level.getHeight().getValue())
                .mapToObj(i-> LadderLine.init(sizeOfPerson, this))
                .collect(Collectors.toList());
    }
}

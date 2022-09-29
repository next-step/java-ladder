package ladder.step2.domain.strategy;

import ladder.step2.domain.PartLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomLineCreateStrategy implements LineCreateStrategy {
    @Override
    public List<PartLine> addPartLine(int countOfPlayers) {
        List<PartLine> partLines = new ArrayList<>();
        addPartLines(countOfPlayers, partLines);
        return partLines;
    }
    
    private void addPartLines(int countOfPlayers, List<PartLine> partLines) {
        IntStream.range(0, countOfPlayers)
                .forEach(index -> partLines.add(createPartLine(index, partLines)));
    }
    
    private PartLine createPartLine(int index, List<PartLine> partLines) {
        if (index == 0 || partLines.get(index - 1).equals(new PartLine(true))) {
            return new PartLine(false);
        }
        
        return new PartLine(randomBoolean());
    }
    
    private boolean randomBoolean() {
        return new Random().nextBoolean();
    }
}

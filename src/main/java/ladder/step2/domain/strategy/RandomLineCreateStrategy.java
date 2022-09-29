package ladder.step2.domain.strategy;

import ladder.step2.domain.PartLine;

import java.util.List;
import java.util.Random;

public class RandomLineCreateStrategy implements LineCreateStrategy {
    @Override
    public void addPartLine(List<PartLine> partLines, int countOfPlayers) {
        if (partLines.size() == 0 || partLines.get(partLines.size() - 1).equals(new PartLine(true))) {
            partLines.add(new PartLine(false));
            return;
        }
        
        partLines.add(new PartLine(createRandomBoolean()));
    }
    
    private static boolean createRandomBoolean() {
        return new Random().nextBoolean();
    }
}

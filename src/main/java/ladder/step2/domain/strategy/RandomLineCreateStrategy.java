package ladder.step2.domain.strategy;

import java.util.List;
import java.util.Random;

public class RandomLineCreateStrategy implements LineCreateStrategy {
    @Override
    public void addPartLine(List<Boolean> partLines, int countOfPlayers) {
        if (partLines.size() == 0 || partLines.get(partLines.size() - 1)) {
            partLines.add(false);
            return;
        }
        
        partLines.add(createRandomBoolean());
    }
    
    private static boolean createRandomBoolean() {
        return new Random().nextBoolean();
    }
}

package nextstep.ladder.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomStrategy implements LadderStrategy {

    @Override
    public List<Boolean> makeLadder(int size) {
        Random random = new Random();
        List<Boolean> line = new ArrayList<>();
        int initialRandomNumber = random.nextInt(10);
        if (initialRandomNumber >= 5) {
            line.add(true);
        }
        if (initialRandomNumber < 5) {
            line.add(false);
        }
        IntStream.range(1, size - 1).
                forEach(index -> {
                    int randomNumber = random.nextInt(10);
                    if (randomNumber >= 5 && line.get(index - 1) == false) {
                        line.add(true);
                    }
                    if (randomNumber < 5 || line.get(index - 1) == true) {
                        line.add(false);
                    }
                });
        return line;
    }
}

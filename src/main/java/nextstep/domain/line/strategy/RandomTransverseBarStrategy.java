package nextstep.domain.line.strategy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomTransverseBarStrategy implements TransverseBarStrategy {

    @Override
    public List<Boolean> draw(int countOfPerson) {
        RandomPicker randomPicker = new RandomPicker();
        return IntStream.range(0, countOfPerson - 1)
                .mapToObj(count -> randomPicker.pick())
                .collect(Collectors.toList());
    }

    private static class RandomPicker {

        private static final Random RANDOM = new Random();

        private Boolean previousBoolean = false;

        public Boolean pick() {
            if (previousBoolean) {
                previousBoolean = false;
                return false;
            }
            previousBoolean = RANDOM.nextBoolean();
            return previousBoolean;
        }

    }

}

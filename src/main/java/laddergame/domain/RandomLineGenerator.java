package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLineGenerator implements LadderLineGenerator {
    private static final Random RANDOM = new Random();

    private List<Boolean> points;

    @Override
    public List<Boolean> generate(int size) {
        initialize(size);
        createHorizontalLine();
        return points;
    }

    private void initialize(int lizeSize){
        points = new ArrayList<>();
        for (int i = 0; i < lizeSize; i++) {
            points.add(false);
        }
    }

    private void createHorizontalLine(){
        for (int index = 0; index < points.size(); index++) {
            addHorizontalLine(index);
        }
    }

    private void addHorizontalLine(int index) {
        if(this.canAddHorizontalLine(index)){
            points.set(index, RANDOM.nextBoolean());
        }
    }

    private boolean canAddHorizontalLine(int index) {
        return isFirst(index) || hasNotHorizontalLine(index - 1);
    }

    private static boolean isFirst(int index) {
        return index == 0;
    }

    private boolean hasHorizontalLine(int index) {
        return points.get(index);
    }

    private boolean hasNotHorizontalLine(int index) {
        return !hasHorizontalLine(index);
    }

}

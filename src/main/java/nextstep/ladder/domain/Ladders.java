package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.BooleanStrategy;
import nextstep.ladder.domain.strategy.RandomBooleanStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladders {

    private final List<Ladder> ladders;

    private Ladders(List<Ladder> ladders) {
        this.ladders = ladders;
    }

    public static Ladders of(List<Ladder> ladders) {
        return new Ladders(ladders);
    }

    public static Ladders of(int peopleCount, int heightCount) {
        return of(peopleCount, heightCount, new RandomBooleanStrategy());
    }

    private static Ladders of(int peopleCount, int heightCount, BooleanStrategy booleanStrategy) {
        validate(heightCount);
        List<Ladder> ladders = new ArrayList<>();
        for (int i = 0; i < heightCount; i++) {
            List<Line> lines = createLines(peopleCount - 1, booleanStrategy);
            ladders.add(new Ladder(lines));
        }
        return new Ladders(ladders);
    }

    private static List<Line> createLines(int lineCount, BooleanStrategy booleanStrategy) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < lineCount; i++) {
            lines.add(new Line(isLine(lines, i, booleanStrategy)));
        }
        return lines;
    }

    public int searchIndex(int index) {
        for (int i = 0; i < ladders.size(); i++) {
            index = ladders.get(i).search(index);
        }
        return index;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    private static void validate(int heightCount) {
        if (heightCount < 1) {
            throw new IllegalArgumentException("높이는 0이상이여야 합니다");
        }
    }

    private static Boolean isLine(List<Line> lines, int i, BooleanStrategy booleanStrategy) {
        if (isPerv(lines, i)) {
            return false;
        }
        return booleanStrategy.decide();
    }

    private static boolean isPerv(List<Line> lines, int i) {
        return i != 0 && lines.get(i - 1).isLine();
    }


}

package nextstep.ladder.hint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static nextstep.ladder.generator.RandomValueGenerator.generatePoint;

public class HintLadderLine {
    private final List<HintPoint> hintPoints;

    public HintLadderLine(List<HintPoint> hintPoints) {
        this.hintPoints = hintPoints;
    }

    public int move(int position) {
        return hintPoints.get(position).move();
    }

    public static HintLadderLine init(int sizeOfPerson) {
        List<HintPoint> hintPoints = new ArrayList<>();

        HintPoint hintPoint = initFirst(hintPoints);
        hintPoint = initBody(sizeOfPerson, hintPoints, hintPoint);
        initLast(hintPoints, hintPoint);

        return new HintLadderLine(hintPoints);
    }

    private static HintPoint initBody(int sizeOfPerson, List<HintPoint> hintPoints, HintPoint hintPoint) {
        for (int i = 1; i < sizeOfPerson - 1; i++) {
            hintPoint = hintPoint.next();
            hintPoints.add(hintPoint);
        }
        return hintPoint;
    }

    private static void initLast(List<HintPoint> hintPoints, HintPoint hintPoint) {
        hintPoint = hintPoint.last();
        hintPoints.add(hintPoint);
    }

    private static HintPoint initFirst(List<HintPoint> hintPoints) {
        HintPoint hintPoint = HintPoint.first(generatePoint());
        hintPoints.add(hintPoint);
        return hintPoint;
    }

    public List<HintPoint> points() {
        return Collections.unmodifiableList(hintPoints);
    }

    @Override
    public String toString() {
        return String.valueOf(hintPoints);
    }
}

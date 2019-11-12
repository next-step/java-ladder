package ladder;

import java.util.*;

public class Points {
    private List<Boolean> points = new ArrayList<>();

    public Points(int countOfPerson) {
        this.points = createPoints(countOfPerson);
    }

    public List<Boolean> createPoints(int countOfPerson) {
        points.add(generateShufflePoint());
        for (int i = 1; i < countOfPerson - 1; i++) {
            boolean a = points.stream().min(Comparator.naturalOrder())
                    .map(this::generatePoints)
                    .orElseThrow(() -> new IllegalArgumentException("초기값 에러"));
            System.out.println(a);
            points.add(a);
        }
        return points;
    }

    public boolean generatePoints(boolean currentBoolean) {
        if (currentBoolean) {
            return false;
        }
        return generateShufflePoint();
    }

    public boolean generateShufflePoint() {
        List<Boolean> booleans = Arrays.asList(true, false);
        Collections.shuffle(booleans);
        return booleans.get(0);
    }

    public List<Boolean> getPoints() {
        return new ArrayList<>(points);
    }
}

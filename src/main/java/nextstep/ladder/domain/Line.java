package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Cross> crosses;

    public Line(List<Boolean> connections) {
        this.crosses = createCrosses(connections);
    }

    private List<Cross> createCrosses(List<Boolean> connections) {
        List<Cross> crosses = new ArrayList<>();

        Cross cross = Cross.first(!connections.isEmpty() && connections.getFirst());
        crosses.add(cross);

        for (int i = 1; i < connections.size(); i++) {
            cross = cross.next(connections.get(i));
            crosses.add(cross);
        }

        crosses.add(cross.last());
        return crosses;
    }

    public Line(int countOfPerson) {
        this.crosses = generateCrosses(countOfPerson);
    }

    private List<Cross> generateCrosses(int countOfPerson) {
        List<Cross> crosses = new ArrayList<>();

        Cross cross = Cross.first(generateRandomBoolean(false));
        crosses.add(cross);

        for (int i = 1; i < countOfPerson - 1; i++) {
            cross = cross.next(generateRandomBoolean(cross.hasRightConnection()));
            crosses.add(cross);
        }

        crosses.add(cross.last());
        return crosses;
    }

    private boolean generateRandomBoolean(boolean previousRight) {
        if (previousRight) {
            return false;
        }
        return Math.random() < 0.5;
    }

    public boolean hasConnectionAt(int position) {
        return crosses.get(position).hasRightConnection();
    }

    public int move(int position) {
        return crosses.get(position).move();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("     ");
        for (int i = 0; i < crosses.size() - 1; i++) {
            sb.append("|").append(crosses.get(i).hasRightConnection() ? "-----" : "     ");
        }
        sb.append("|");
        return sb.toString();
    }
}
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

    public Line(int countOfPerson, LineConnectionStrategy strategy) {
        this.crosses = generateCrosses(countOfPerson, strategy);
    }

    private List<Cross> generateCrosses(int countOfPerson, LineConnectionStrategy strategy) {
        List<Cross> crosses = new ArrayList<>();

        Cross cross = Cross.first(strategy.hasConnection(false));
        crosses.add(cross);

        for (int i = 1; i < countOfPerson - 1; i++) {
            cross = cross.next(strategy.hasConnection(cross.hasRightConnection()));
            crosses.add(cross);
        }

        crosses.add(cross.last());
        return crosses;
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
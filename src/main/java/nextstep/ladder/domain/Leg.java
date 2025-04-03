package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leg {
    private final ParticipantName name;
    private final List<Junction> junctions;

    public Leg(String name, int height) {
        this.name = new ParticipantName(name);
        this.junctions = Junction.createJunctions(height);
    }

    public Junction getJunction(int level) {
        return junctions.get(level);
    }

    public int getHeight() {
        return junctions.size();
    }

    public String getName() {
        return name.getValue();
    }
}

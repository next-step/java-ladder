package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Leg {
    private final ParticipantName name;
    private final List<Junction> junctions;

    public Leg(String name, int height) {
        this.name = new ParticipantName(name);
        this.junctions = Junction.createJunctions(height);
    }

    public static List<Leg> createLegs(List<String> names, int height) {
        return names.stream()
            .map(name -> new Leg(name, height))
            .collect(Collectors.toList());
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

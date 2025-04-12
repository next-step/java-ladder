package nextstep.ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Leg {
    private final ParticipantName name;
    private final String result;
    private final List<Junction> junctions;

    public Leg(String name, String result, int height) {
        this.name = new ParticipantName(name);
        this.result = result;
        this.junctions = createJunctions(height);
    }

    public Junction getStart() {
        return junctions.get(0);
    }

    public Junction getJunction(int level) {
        return junctions.get(level);
    }

    public int getHeight() {
        return junctions.size();
    }

    public ParticipantName getName() {
        return name;
    }

    public String getResult() {
        return result;
    }

    private List<Junction> createJunctions(int height) {
        List<Junction> newJunctions = IntStream.range(0, height)
            .mapToObj(i -> new Junction(this))
            .collect(Collectors.toList());

        for (int i = 0; i < newJunctions.size() - 1; i++) {
            Junction curr = newJunctions.get(i);
            Junction down = newJunctions.get(i + 1);
            curr.connectDown(down);
        }

        return newJunctions;
    }

    public static List<Leg> createLegs(List<String> names, List<String> results, int height) {
        if (names.size() != results.size()) {
            throw new IllegalArgumentException("참여할 사람의 수와 실행 결과의 수가 다릅니다.");
        }

        return IntStream.range(0, names.size())
            .mapToObj(i -> {
                String name = names.get(i);
                String result = results.get(i);
                return new Leg(name, result, height);
            })
            .collect(Collectors.toList());
    }
}

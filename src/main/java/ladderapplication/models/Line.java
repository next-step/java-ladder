package ladderapplication.models;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Line {
    private final List<Boolean> hasSteps;

    private Line(List<Boolean> hasSteps) {
        this.hasSteps = hasSteps;
    }

    public List<Boolean> getHasSteps() {
        return hasSteps;
    }

    public static Line of(int playerCount) {
        List<Boolean> hasStep = Stream.generate(() -> Boolean.FALSE)
                .limit(playerCount - 1)
                .collect(Collectors.toList());
        return new Line(hasStep);
    }

    public String getLine() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        hasSteps.forEach(hasStep -> {
            if (hasStep) {
                sb.append("|-----");
                return;
            }

            sb.append("|     ");
        });

        sb.append("|");
        return sb.toString();
    }
}

package ladder.domain;

import ladder.domain.strategy.LadderGeneratorStrategy;
import ladder.domain.strategy.RandomBuildLadder;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<Boolean> points = new ArrayList<>();

    public Line (int countOfPerson) {
        for (int i = 0; i < countOfPerson - 1; i++) {
            Boolean isBuild = isBuild(new RandomBuildLadder());
            if (isBuild) {
                points.add(true);
                if (i != countOfPerson - 2) points.add(false);
                i++;
                continue;
            }
            points.add(false);
        }
    }

    public Boolean isBuild (LadderGeneratorStrategy ladderGenerator) {
        return ladderGenerator.isBuild();
    }

    public String lineToDash() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("    |");
        points.forEach(ladder -> {
            if (ladder) {
                stringBuilder.append("-----");

            } else {
                stringBuilder.append("     ");
            }
            stringBuilder.append("|");
        });
        return stringBuilder.toString();
    }
}

package nextstep.ladder.view;

import nextstep.ladder.model.CoordinateValue;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Leg;
import nextstep.ladder.model.Name;

public class OutputView {
    public static void printLadder(Ladder ladder) {
        System.out.println("실행결과");
        System.out.println(
            ladder.getNames().stream().map(Name::getName).reduce("", (accu, curr) -> accu + String.format("%-6s", curr))
        );
        for (int i = 0; i < ladder.getHeight().getValue(); i++) {
            StringBuilder string = new StringBuilder();
            for (int j = 0; j < ladder.getWidth().getValue() - 1; j++) {
                string.append("|").append(getLineString(ladder.getLegs().get(j), ladder.getLegs().get(j + 1), i));
            }
            System.out.println(string.append("|"));
        }
    }

    private static String getLineString(Leg leftLeg, Leg rightLeg, int heightIndex) {
        if (leftLeg.hasLine(heightIndex) && leftLeg.directlyConnected(rightLeg, new CoordinateValue(heightIndex))) {
            return "-----";
        }
        return "     ";
    }
}

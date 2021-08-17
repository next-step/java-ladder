package nextstep.ladder.view;

import nextstep.ladder.model.CoordinateValue;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Leg;
import nextstep.ladder.model.Name;
import nextstep.ladder.model.Names;

public class OutputView {
    public static void printLadder(Ladder ladder) {
        System.out.println("실행결과");
        printNames(ladder.getNames());
        for (int heightIndex = 0; heightIndex < ladder.getHeight().getValue(); heightIndex++) {
            printHeight(ladder, heightIndex);
        }
    }

    private static void printNames(Names names) {
        System.out.println(
                names.stream().map(Name::getName).reduce("", (accu, curr) -> accu + String.format("%-6s", curr))
        );
    }

    private static void printHeight(Ladder ladder, int heightIndex) {
        StringBuilder string = new StringBuilder();
        for (int widthIndex = 0; widthIndex < ladder.getWidth().getValue() - 1; widthIndex++) {
            string.append("|").append(getLineString(ladder.getLegs().get(widthIndex), ladder.getLegs().get(widthIndex + 1), heightIndex));
        }
        System.out.println(string.append("|"));
    }

    private static String getLineString(Leg leftLeg, Leg rightLeg, int heightIndex) {
        if (leftLeg.hasLine(new CoordinateValue(heightIndex)) && leftLeg.directlyConnected(rightLeg, new CoordinateValue(heightIndex))) {
            return "-----";
        }
        return "     ";
    }
}

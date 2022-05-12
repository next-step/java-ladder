package nextstep.ladder.view;

import static java.lang.System.out;

import java.util.List;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Part;
import nextstep.ladder.domain.Parts;

public class LadderGameOutputCui {

    public void draw(Ladder ladder) {
        out.println("\n 사다리 결과");

        printNames(ladder.getLineNames());
        drawLines(ladder.getLines());
        printResults(ladder.getResults());
    }

    private static String fixedLengthString(String string, int length) {
        return String.format("%1$"+length+ "s", string);
    }

    private void printNames(List<String> names) {
        out.print(" ");
        for (String name : names) {
            out.print(fixedLengthString(name, 6));
        } out.println();
    }

    private void drawLines(Lines lines) {
        for (Parts partPlate : lines.getLines()) {
            drawParts(partPlate.getParts());
        }
    }

    private void drawParts(List<Part> parts) {
        out.print("     ");
        for (Part part : parts) {
            drawLine(part);
        }
        out.println();
    }

    private void drawLine(Part part) {
        if (part.isHorizontalLine()) {
            if (part.isConnected()) {
                out.print("-----");
                return;
            }
            out.print("     ");
            return;
        }

        out.print("|");
    }

    private void printResults(List<String> results) {
        out.print(" ");
        for (String result : results) {
            out.print(fixedLengthString(result, 6));
        } out.println();
    }

    public void printResultOf(String result) {
        if ("all".equals(result)) return;

        out.println("실행 결과\n" + result);
    }

    public void printGameResults(Ladder ladder) {
        out.println("실행 결과");
        List<String> lineNames = ladder.getLineNames();
        for (String lineName : lineNames) {
            out.printf("%s : %s\n", lineName, ladder.checkResultOf(lineName));
        }
    }
}

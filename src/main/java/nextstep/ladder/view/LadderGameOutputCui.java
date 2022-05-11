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

        List<String> names = ladder.getLineNames();

        out.print(" ");
        for (String name : names) {
            out.print(fixedLengthString(name, 6));
        } out.println();

        Lines lines = ladder.getLines();
        for (Parts partPlate : lines.getLines()) {
            drawParts(partPlate.getParts());
        }
    }

    private static String fixedLengthString(String string, int length) {
        return String.format("%1$"+length+ "s", string);
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

}

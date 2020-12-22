package ladder.view;

import ladder.domain.*;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConsoleView {

    private PrintWriter writer = new PrintWriter(System.out);

    private static Map<LadderItem, String> ladderPointSymbols;
    static {
        ladderPointSymbols = new HashMap<>();
        ladderPointSymbols.put(LadderItem.Bar, "|");
        ladderPointSymbols.put(LadderItem.Empty, "      ");
        ladderPointSymbols.put(LadderItem.Step, "------");
    }

    public void printResult(LadderGameResult gameResult) {
        writer.println("사다리 결과");
        writer.println();

        gameResult.getAllLadderMembers().forEach(member -> writer.print(String.format("%1$7s", member.getName())));
        writer.println();

        LadderReader reader = gameResult.getLadderReader();
        List<LadderItem> line;
        while( (line = reader.readLine()) != null ) {
            writer.print("      ");
            line.forEach( point -> writer.print(ladderPointSymbols.get(point)));
            writer.println();
        }

        gameResult.getAllLadderResults().forEach(ladderResult-> writer.print(String.format("%1$7s", ladderResult)));
        writer.println();

        writer.println();
        writer.flush();
    }

    public void printAllMemberResults(Map<LadderMember, LadderResult> ladderResult) {
        ladderResult.keySet()
                .stream()
                .forEach(member -> writer.println(member + ": " + ladderResult.get(member)));
        writer.println();
        writer.flush();
    }

    public void printMemberResult(LadderResult ladderResult) {
        writer.println(ladderResult);
        writer.println();
        writer.flush();
    }

    public void println(String message) {
        writer.println(message);
        writer.flush();
    }


}

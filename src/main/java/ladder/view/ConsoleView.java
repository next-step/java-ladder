package ladder.view;

import ladder.domain.LadderGameResult;

import java.io.PrintWriter;
import java.util.Map;

public class ConsoleView {

    private PrintWriter writer = new PrintWriter(System.out);

    public void printResult(LadderGameResult result) {
        writer.println("사다리 결과");
        writer.println();
        result.printLadder(writer);
        writer.println();
        writer.flush();
    }

    public void printAllMemberResults(String member, Map<String, String> ladderResult) {
        ladderResult.keySet()
                .stream()
                .forEach(name -> writer.println(name + ": " + ladderResult.get(name)));
        writer.println();
        writer.flush();
    }

    public void printMemberResult(String ladderResult) {
        writer.println(ladderResult);
        writer.println();
        writer.flush();
    }

    public void println(String message) {
        writer.println(message);
        writer.flush();
    }


}

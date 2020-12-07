package ladder;

import java.io.PrintWriter;

public class ConsoleView {

    private PrintWriter writer = new PrintWriter(System.out);

    public void printResult(LadderGameResult result){
        writer.println("실행결과");
        writer.println();
        result.printLadder(writer);
    }

}

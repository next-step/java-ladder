import ladder.domain.Ladder;
import ladder.domain.LadderData;
import ladder.ui.Input;
import ladder.ui.Output;

import java.util.List;
import java.util.Scanner;

public class Application {

    private static final String MSG_SEARCH_PLAYER_REWARD = "결과를 보고 싶은 사람은? (all 입력 시 모두, exit 입력 시 종료)";
    private static final String MSG_SEARCH_REWARD_RESULT = "실행 결과";

    private static final String EXIT_COMMAND = "exit";
    private static final String SEARCH_ALL_PLAYER = "all";

    public static void main(String[] args) {

        Input input = new ScannerInput();
        Output output = new StandardOutput();
        LadderData ladderData = new LadderData(input, output);

        Ladder ladder = new Ladder(ladderData);
        printLadder(output, ladder);

        boolean isRun = true;

        while(isRun) {
            isRun = runOutputPrint(input, output, ladder);
        }
    }

    private static boolean runOutputPrint(Input input, Output output, Ladder ladder) {

        input.nextLine();
        output.print(MSG_SEARCH_PLAYER_REWARD);
        String playerName = input.nextLine();

        if (playerName.equals(EXIT_COMMAND)) {
            return false;
        }

        if (playerName.equals(SEARCH_ALL_PLAYER)) {
            output.print(MSG_SEARCH_REWARD_RESULT);
            output.printMultiLine(ladder.searchAllReward());
            return true;
        }

        output.print(MSG_SEARCH_REWARD_RESULT);
        output.print(ladder.searchReward(playerName));

        return true;
    }

    private static void printLadder(Output output, Ladder ladder) {
        output.print(ladder.getNames());
        output.printMultiLine(ladder.getLadderLinesString());
        output.print(ladder.getRewards());
    }

    private static class ScannerInput implements Input {
        private final Scanner scanner = new Scanner(System.in);

        @Override
        public int nextInt() {
            return scanner.nextInt();
        }

        @Override
        public String nextLine() {
            return scanner.nextLine();
        }
    }

    private static class StandardOutput implements Output {
        @Override
        public void print(String line) {
            System.out.println(line);
        }

        @Override
        public void print(List<String> lineList) {
            print(String.join("\t", lineList));
        }

        @Override
        public void printMultiLine(List<String> lineList) {
            lineList.forEach(System.out::println);
        }
    }
}

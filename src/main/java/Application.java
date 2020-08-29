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
    private static final int RUN_CODE = 0;
    private static final int EXIT_CODE = -1;

    public static void main(String[] args) {

        Input input = new ScannerInput();
        Output output = new StandardOutput();
        LadderData ladderData = new LadderData(input, output);

        Ladder ladder = new Ladder(ladderData);
        printLadder(output, ladder);

        int code = RUN_CODE;

        while(code == RUN_CODE) {
            code = runOutputPrint(input, output, ladder);
        }
    }

    private static int runOutputPrint(Input input, Output output, Ladder ladder) {

        input.nextLine();
        output.print(MSG_SEARCH_PLAYER_REWARD);
        String playerName = input.nextLine();

        if (playerName.equals(EXIT_COMMAND)) {
            return EXIT_CODE;
        }

        if (playerName.equals(SEARCH_ALL_PLAYER)) {
            output.print(MSG_SEARCH_REWARD_RESULT);
            output.printMultiLine(ladder.searchAllReward());
            return RUN_CODE;
        }

        output.print(MSG_SEARCH_REWARD_RESULT);
        output.print(ladder.searchReward(playerName));

        return RUN_CODE;
    }

    private static void printLadder(Output output, Ladder ladder) {
        output.print(ladder.getNames());
        output.printMultiLine(ladder.getLadderString());
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

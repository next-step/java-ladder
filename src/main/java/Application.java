import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import ladder.controller.LadderController;
import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.LadderResultCalculator;
import ladder.domain.LadderResultMapper;
import ladder.domain.Participants;
import ladder.domain.Rewards;
import ladder.ui.Input;
import ladder.ui.Output;

public class Application {

    public static void main(String[] args) {

        LadderController ladderController = LadderController.builder()
                                                            .input(new ScannerInput())
                                                            .output(new StandardOutput())
                                                            .build();

        Participants participants = ladderController.makeParticipants();
        Ladder ladder = ladderController.makeLadder();
        Rewards rewards = ladderController.makeRewards();

        ladderController.printLadder(participants, ladder, rewards);

        LadderResult ladderResult = new LadderResult(LadderResultCalculator.calculate(participants.getPlayerCount(), ladder));
        LadderResultMapper ladderResultMapper = new LadderResultMapper(ladderResult, participants, rewards);

        ladderController.printResult(ladderResultMapper);
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

        private static final String BLANK = " ";

        @Override
        public void print(String line) {
            System.out.println(line);
        }

        @Override
        public void print(List<String> lineList) {
            print(lineList.stream()
                          .map(line -> String.format("%-5s", line))
                          .collect(Collectors.joining(BLANK)));
        }

        @Override
        public void printMultiLine(List<String> lineList) {
            lineList.forEach(System.out::println);
        }
    }
}

package game.ui;

import game.domain.ladder.LadderResult;
import game.domain.ladder.Ladders;
import game.domain.ladder.Line;
import game.service.GhostLegService;
import game.service.RandomNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class GhostLegResult {
    private final String DELIMITER = ",";
    private final int MAX_NAME_LENGTH = 5;

    private Ladders ghostLeg;

    public void print() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> people = List.of(InputView.inputString().split(DELIMITER));

        System.out.println();
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> results = List.of(InputView.inputString().split(DELIMITER));

        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightOfLeg = InputView.inputInteger();

        System.out.println();
        System.out.println("실행결과");
        System.out.println();

        printParticipants(people);
        printLeg(heightOfLeg, people.size());
        printResult(people, results);
    }

    private void printParticipants(List<String> people) {
        for (String person : people) {
            StringBuilder stringBuilder = new StringBuilder();
            int totalEmptySpace = MAX_NAME_LENGTH - person.length();
            stringBuilder.append(" ".repeat(Math.max(0, totalEmptySpace)));
            stringBuilder.append(person);
            stringBuilder.append(" ");
            System.out.print(stringBuilder);
        }
        System.out.println();
    }

    private void printLeg(int heightOfLeg, int numOfPeople) {
        GhostLegService ghostLegService = new GhostLegService();

        List<Line> ladders = new ArrayList<>();
        for (int height = 1; height <= heightOfLeg; height++) {
            System.out.print("     |");
            List<Boolean> filteredLines = ghostLegService.filterLines(ghostLegService.generateRandomLines(numOfPeople), new RandomNumberStrategy());
            printLines(filteredLines);
            ladders.add(new Line(filteredLines));
            System.out.println();
        }

        ghostLeg = new Ladders(ladders);
    }

    private void printResult(List<String> people, List<String> results) {
        for (String result : results) {
            StringBuilder stringBuilder = new StringBuilder();
            int totalEmptySpace = MAX_NAME_LENGTH - result.length();
            stringBuilder.append(" ");
            stringBuilder.append(result);
            stringBuilder.append(" ".repeat(Math.max(0, totalEmptySpace)));
            System.out.print(stringBuilder);
        }
        System.out.println();
        System.out.println();

        printGhostLegResult(people, results);
    }

    private void printGhostLegResult(List<String> people, List<String> results) {
        GhostLegService ghostLegService = new GhostLegService();

        System.out.println("결과를 보고 싶은 사람은?");
        String person = InputView.inputString();
        System.out.println();

        List<LadderResult> ladderResults = ghostLegService.findLadderResults(people, person, results, ghostLeg);

        System.out.println("실행 결과");
        printFinalGhostLegResults(ladderResults);
    }

    private void printFinalGhostLegResults(List<LadderResult> ladderResults) {
        for (LadderResult ladderResult : ladderResults) {
            System.out.println(ladderResult.person() + " : " + ladderResult.result());
        }
    }

    public void printLines(List<Boolean> filteredLines) {
        filteredLines.forEach(IS_LADDER -> {
            checkIfIsLadderOrNot(IS_LADDER);
            System.out.print("|");
        });
    }

    private void checkIfIsLadderOrNot(Boolean is_ladder) {
        if (is_ladder) {
            System.out.print("-----");
            return;
        }

        System.out.print("     ");
    }
}

package game.ui;

import game.domain.GhostLegService;
import game.dto.LineDto;

import java.util.List;

public class GhostLegResult implements Result {
    private final String DELIMITER = ",";
    private final int MAX_NAME_LENGTH = 5;

    @Override
    public void print() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> people = List.of(InputView.inputString().split(DELIMITER));

        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int heightOfLeg = InputView.inputInteger();

        System.out.println();
        System.out.println("실행결과");
        System.out.println();

        printParticipants(people);
        printLeg(heightOfLeg, people.size());
    }

    public void printParticipants(List<String> people) {
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

    public void printLeg(int heightOfLeg, int numOfPeople) {
        GhostLegService ghostLegService = new GhostLegService();

        for (int height = 1; height <= heightOfLeg; height++) {
            System.out.print("     |");
            printLines(ghostLegService, numOfPeople);
            System.out.println();
        }
    }

    public void printLines(GhostLegService ghostLegService, int numOfPeople) {
        LineDto lineDto = new LineDto(ghostLegService.generateRandomLines(numOfPeople));
        lineDto.filter(ghostLegService.filterLines(lineDto.getLines()));
        lineDto.getLines().forEach(hasLag -> {
            if (hasLag) System.out.print("-----");
            else System.out.print("     ");
            System.out.print("|");
        });
    }
}

package nextstep.ladder;

import nextstep.ladder.view.ConsoleResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LadderGame {
    public static void main(String[] args) {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String namesInput = scanner.nextLine();
        List<String> names = Arrays.stream(namesInput.split(","))
                .collect(Collectors.toList());
        Participants participants = Participants.from(names);

        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Height height = Height.valueOf(Integer.parseInt(scanner.nextLine()));

        Ladder ladder = Ladder.of(participants, height);

        ConsoleResultView consoleResultView = new ConsoleResultView();
        consoleResultView.printLadder(ladder);
    }
}

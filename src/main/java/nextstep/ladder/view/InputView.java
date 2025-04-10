package nextstep.ladder.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public List<String> getParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String input = SCANNER.nextLine();
        System.out.println();
        String[] names = input.split(",+");
        return List.of(names);
    }

    public List<String> getResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String input = SCANNER.nextLine();
        System.out.println();
        String[] names = input.split(",+");
        return List.of(names);
    }

    public int getLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        String input = SCANNER.nextLine();
        System.out.println();
        return Integer.parseInt(input);
    }

    public String getTargetParticipantName() {
        System.out.println("결과를 보고 싶은 사람은?");
        String input = SCANNER.nextLine();
        System.out.println();
        return input;
    }
}

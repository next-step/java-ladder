package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public List<String> readParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String names = scanner.nextLine();
        return Arrays.stream(names.split(",")).collect(Collectors.toList());
    }

    public int readLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
}

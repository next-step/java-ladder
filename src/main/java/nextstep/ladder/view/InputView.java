package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import nextstep.ladder.domain.Name;

public class InputView {

    private final static Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static List<Name> readParticipantNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        List<String> names = Arrays.asList(SCANNER.nextLine().split(","));
        return names.stream().map(Name::new).collect(Collectors.toList());
    }

    public static int readLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        return Integer.parseInt(SCANNER.nextLine());
    }

}

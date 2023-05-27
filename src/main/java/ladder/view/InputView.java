package ladder.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    public static final String SPLIT_DELIMITER = ",";

    public static List<String> players() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Stream.of(new Scanner(System.in).nextLine().split(SPLIT_DELIMITER)).collect(Collectors.toList());
    }

    public static Integer ladderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        Integer height = new Scanner(System.in).nextInt();
        System.out.println(height + System.lineSeparator());
        return height;
    }
}

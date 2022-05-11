package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> askPlayers() {
        System.out.println("참여할 이름을 입력하세요. 쉽표(,)로 구분해주세요. ex. jack, pobi");
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}

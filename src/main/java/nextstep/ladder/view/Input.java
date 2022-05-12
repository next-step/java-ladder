package nextstep.ladder.view;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MIN_LADDER_HEIGHT = 1;

    public static List<String> askPlayers() {
        System.out.println("참여할 이름을 입력하세요. 쉽표(,)로 구분해주세요. ex. jack, pobi");
        return Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(scanner.nextLine());
        if (height < MIN_LADDER_HEIGHT) {
            throw new LadderException(LadderExceptionCode.INVAILD_LADDER_HEIGHT);
        }
        return height;
    }
}

package nextstep.ladder.view;

import nextstep.ladder.domain.Height;
import nextstep.ladder.domain.Players;
import nextstep.ladder.exception.LadderException;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ",";

    public static List<String> askPlayers() {
        System.out.println("참여할 이름을 입력하세요. 쉽표(,)로 구분해주세요. ex. jack, pobi");
        return splitByDelimiter();
    }

    public static Height askLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        int height = Integer.parseInt(scanner.nextLine());
        return Height.of(height);
    }

    public static List<String> askResults(Players players) {
        System.out.printf("사다리 결과 %d개 를 입력하세요. (결과는 쉼표(,)로 구분하세요) ex. X,3000,X,4000", players.players().size());
        System.out.println();
        List<String> results = splitByDelimiter();
        if (!players.sameLength(results)) {
            throw new LadderException("사다리 결과는 참여자 수와 같아야 합니다.");
        }
        return results;
    }

    private static List<String> splitByDelimiter() {
        return Arrays.stream(scanner.nextLine().split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}

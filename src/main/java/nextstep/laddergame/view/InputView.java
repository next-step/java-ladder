package nextstep.laddergame.view;

import nextstep.laddergame.domain.Gamer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]\\d*(\\.\\d+)?$");

    public static List<Gamer> inputGamerNames() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        Scanner scanner = new Scanner(System.in);
        String gamerNamesString = scanner.nextLine();
        return Arrays
                .stream(gamerNamesString.split(","))
                .map(Gamer::new)
                .collect(Collectors.toList());
    }

    public static Integer inputLadderHeight() {
        System.out.println("\n최대 사다리 높이는 몇 개인가요?");
        Scanner scanner = new Scanner(System.in);
        String ladderHeightString = scanner.nextLine();
        checkValidLadderHeight(ladderHeightString);
        return Integer.parseInt(ladderHeightString);
    }


    private static void checkValidLadderHeight(String heightString) throws IllegalArgumentException {
        if (!isNumber(heightString)) {
            throw new IllegalArgumentException("Wrong Input : Ladder Height is not a number");
        }
    }

    private static boolean isNumber(String numberString) {
        return NUMBER_PATTERN.matcher(numberString).find();
    }

}

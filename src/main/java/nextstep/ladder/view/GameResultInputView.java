package nextstep.ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GameResultInputView extends AbstractView{

    private static final Scanner scanner = new Scanner(System.in);
    private static final String GAME_RESULT_INPUT_MESSAGE = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";


    public static List<String> getGameResult() {
        stringBuilder.append(GAME_RESULT_INPUT_MESSAGE);
        printAndClear();

        String gameResultInput = scanner.nextLine();

        return Arrays.asList(gameResultInput.split(COMMA))
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }
}

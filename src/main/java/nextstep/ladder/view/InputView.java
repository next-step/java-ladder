package nextstep.ladder.view;

import nextstep.ladder.factory.LinesFactory;
import nextstep.ladder.model.Lines;
import nextstep.ladder.model.Players;
import nextstep.ladder.model.Results;
import nextstep.ladder.utils.StringUtils;

import java.util.Scanner;

public class InputView {
    private static final String DELIMITER = ",";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static String nextLine(String message) {
        OutputView.print(message);
        return SCANNER.nextLine();
    }

    public static int nextInt(String message) {
        return Integer.parseInt(nextLine(message));
    }

    public static Players createPlayers() {
        String inputNames = nextLine("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] splitNames = StringUtils.validationNotNullAndEmpty(inputNames).split(DELIMITER);
        return new Players(splitNames);
    }

    public static Results createResults(int sizeOfPlayers) {
        String inputResults = InputView.nextLine("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] splitResults = StringUtils.validationNotNullAndEmpty(inputResults).split(DELIMITER);
        return new Results(splitResults, sizeOfPlayers);
    }

    public static Lines createLines(int sizeOfPlayers) {
        int height = InputView.nextInt("최대 사다리 높이는 몇 개인가요?");
        return LinesFactory.of(sizeOfPlayers, height);
    }

}

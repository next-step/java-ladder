package ladder.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_PLAYER_NAME_MESSAGE = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String INPUT_DELIMITER = ",";
    private static final String INPUT_MAX_HEIGHT_MESSAGE = "\n최대 사다리 높이는 몇 개인가요?";
    private static final String INPUT_AWARDS_MESSAGE = "\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String INPUT_PLAYER_RESULT = "\n결과를 보고 싶은 사람은?";

    private static Scanner scanner = new Scanner(System.in);

    public static String[] inputPlayerNames(){
        System.out.println(INPUT_PLAYER_NAME_MESSAGE);

        return splitInputValues(scanner.next());
    }

    private static String[] splitInputValues(String inputValues) {
        String[] splitInputValues = inputValues.split(INPUT_DELIMITER);

        return splitInputValues;
    }

    public static String inputLadderHeight(){
        System.out.println(INPUT_MAX_HEIGHT_MESSAGE);

        return scanner.next();
    }

    public static String[] inputLadderGameAwards(int ladderCount){
        System.out.println(INPUT_AWARDS_MESSAGE);

        String[] awards = splitInputValues(scanner.next());

        validateAwardsCount(awards, ladderCount);

        return awards;
    }

    private static void validateAwardsCount(String[] awards, int ladderCount) {
        if(awards.length != ladderCount){
            throw new IllegalArgumentException("사다리 갯수만큼 실행결과를 입력하세요.");
        }

    }

    public static String getPlayerResult() {
        System.out.println(INPUT_PLAYER_RESULT);
        return scanner.next();
    }
}

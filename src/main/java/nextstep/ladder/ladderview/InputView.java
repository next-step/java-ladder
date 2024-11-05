package nextstep.ladder.ladderview;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MIN_LADDER_HEIGHT = 1;
    private static final String DELIMITER = ",";
    private static final String LINE_BREAK = "\n";

    public List<String> inputName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return splitedInput(scanner.nextLine(), NameInputSpliter.getInstance());
    }

    public List<String> inputResult(int numberOfPlayer) {
        System.out.println(LINE_BREAK +"실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        List<String> splitedResult = splitedInput(scanner.nextLine(), ResultInputSpliter.getInstance());
        try {
            checkResultCountIsSameAsNumberOfPlayer(numberOfPlayer, splitedResult);
        } catch(IllegalArgumentException e) {
            System.out.println("입력 참가자 수와 입력 결과 수가 같아야 합니다");
            return inputResult(numberOfPlayer);
        }
        return splitedResult;
    }

    private List<String> splitedInput(String input, InputSpliter inputSpliter) {
        return Arrays.stream(input.split(DELIMITER))
                .map(word -> inputSpliter.checkValidInput(word))
                .collect(Collectors.toList());
    }

    private void checkResultCountIsSameAsNumberOfPlayer(int numberOfPlayer, List<String> splitedResult) {
        if(splitedResult.size() < numberOfPlayer) {
            throw new IllegalArgumentException("입력 참가자 수와 입력 결과 수가 같아야 합니다");
        }
    }

    public int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return checkHeightIsValid(Integer.valueOf(scanner.nextLine()));
    }

    public int checkHeightIsValid(int height) {
        if (height < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 1 이상이어야 합니다");
        }
        return height;
    }

}

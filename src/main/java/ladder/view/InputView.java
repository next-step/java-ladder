package ladder.view;

import ladder.domain.*;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PARTICIPANT_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static final String EXPECTED_RESULT_MSG = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)";
    private static final String LADDER_HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";

    private static final String DEFAULT_SPLIT_REGEX = ",";

    private final Scanner scanner = new Scanner(System.in);

    public Participants getParticipantNames(){
        System.out.println(PARTICIPANT_MSG);
        String input = scanner.nextLine();
        String[] splitInput = input.split(DEFAULT_SPLIT_REGEX);
        List<Participant> result = Arrays.stream(splitInput)
                .map(Participant::new)
                .collect(Collectors.toList());
        return new Participants(result);
    }

    public ExpectedResults getExpectedResults(int size){
        System.out.println(EXPECTED_RESULT_MSG);
        String input = scanner.nextLine();
        String[] splitInput = input.split(DEFAULT_SPLIT_REGEX);
        if(splitInput.length != size) {
            throw new IllegalArgumentException("input size must be the same as the number of participants");
        }
        List<ExpectedResult> result =  Arrays.stream(splitInput)
                .map(ExpectedResult::new)
                .collect(Collectors.toList());
        return new ExpectedResults(result);
    }

    public LadderHeight getLadderHeight(){
        int numberInput;
        while (true) {
            try{
                Scanner scanner = new Scanner(System.in);
                System.out.println(LADDER_HEIGHT_MSG);
                numberInput = scanner.nextInt();
                scanner.nextLine();
                return new LadderHeight(numberInput);
            } catch (InputMismatchException e){
                System.out.println("input must be number type");
            }
        }
    }
}

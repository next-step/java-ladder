package ladder.view;

import ladder.domain.LadderHeight;
import ladder.domain.Participant;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static String PARTICIPANT_MSG = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)";
    private static String LADDER_HEIGHT_MSG = "최대 사다리 높이는 몇 개인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public List<Participant> getParticipantNames(){
        System.out.println(PARTICIPANT_MSG);
        String input = scanner.nextLine();
        String[] splitInput = input.split(",");
        return Arrays.stream(splitInput)
                .map(Participant::new)
                .collect(Collectors.toList());
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

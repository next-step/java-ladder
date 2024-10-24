package step2.uiView;

import step2.enums.InputMessage;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    //참여할 사람 이름을 입력한다.
    public String inputPerson() {
        System.out.println(InputMessage.INPUT_PERSON.message());
        return scanner.next();
    }

    //최대 사다리 높이를 입력한다.
    public int inputMaxLadder() {
        System.out.println(InputMessage.INPUT_MAX_LADDER.message());
        return scanner.nextInt();
    }

    //사다리게임 보상을 입력한다.
    public String inputLadderPrize() {
        System.out.println(InputMessage.INPUT_LADDER_PRIZE.message());
        return scanner.next();
    }

    //결과를 보고싶은 사람을 입력한다.
    public String inputChoosePerson() {
        System.out.println(InputMessage.INPUT_CHOOSE_PERSON.message());
        return scanner.next();
    }

}

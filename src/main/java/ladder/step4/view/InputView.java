package ladder.step4.view;

import ladder.step4.domain.Participants;
import ladder.step4.domain.LadderHeight;

import java.util.Scanner;

public class InputView {

    private static final InputView INSTANCE = new InputView();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NEW_LINE = System.lineSeparator();

    private InputView() { }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public Participants inputParticipants() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return Participants.of(SCANNER.nextLine());
    }

    public String inputResults() {
        System.out.println(NEW_LINE + "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return SCANNER.nextLine();
    }

    public LadderHeight inputHeight() {
        System.out.println(NEW_LINE + "최대 사다리 높이는 몇 개인가요?");
        return LadderHeight.valueOf(SCANNER.nextLine());
    }

    public String inputResultTarget() {
        System.out.println(NEW_LINE + NEW_LINE + "결과를 보고싶은 사람은?");
        return SCANNER.nextLine();
    }

}

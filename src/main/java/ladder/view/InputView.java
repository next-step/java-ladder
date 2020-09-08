package ladder.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    private InputView() {
        this.scanner = new Scanner(System.in);
    }

    private static class InnerHolder {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return InnerHolder.INSTANCE;
    }

    public String getRewards() {
        System.out.println(InputViewMessage.INPUT_FOR_REWARDS.getMessage());
        return scanner.nextLine();
    }

    public String getParticipantNames() {
        System.out.println(InputViewMessage.INPUT_FOR_NAMES.getMessage());
        return scanner.nextLine();
    }

    public String getLadderHeight() {
        System.out.println(InputViewMessage.INPUT_FOR_LADDER_HEIGHT.getMessage());
        return scanner.nextLine();
    }

    public String getTargetName() {
        System.out.println(InputViewMessage.INPUT_FOR_TARGET.getMessage());
        return scanner.nextLine();
    }
}

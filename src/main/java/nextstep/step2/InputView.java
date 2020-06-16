package nextstep.step2;

public class InputView {
    private InputView(){}

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static int inputLadderHeight() {
        return LadderScanner.inputNumber();
    }

    public static String inputParticipants() {
        return LadderScanner.inputString();
    }
}

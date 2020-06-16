package nextstep.step2;

public class Main {
    public static void main(String[] args) {
        InputView.printMessage("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String participants = InputView.inputParticipants();

        InputView.printMessage("최대 사다리 높이는 몇 개인가요?");
        int ladderHeight = InputView.inputLadderHeight();
    }
}

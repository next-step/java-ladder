package nextstep.ladder;

public class LadderMain {
    public static void main(String[] args) {
        Usernames usernames = new Usernames(InputView.inputUserNames());
        int height = InputView.inputHeight();
        ResultView.printLadderResult(usernames, new Ladder(height, usernames.size()));
    }
}

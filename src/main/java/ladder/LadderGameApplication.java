package ladder;

public class LadderGameApplication {

    public static void main(String[] args) {

        UserInput input = new UserInput();
        String memberNames = input.readLadderMemberNames();
        int ladderHeight = input.readLadderHeight();

        LadderGame game = new LadderGame(memberNames, ladderHeight);
        LadderGameResult result = game.run();

        ConsoleView consoleView = new ConsoleView();
        consoleView.printResult(result);

    }
}

import domain.LadderGame;
import view.ConsoleInputView;
import view.ConsoleOutputView;

public class ConsoleMain {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(
            ConsoleInputView.inputUserNames(),
            ConsoleInputView.inputResults(),
            ConsoleInputView.inputLadderDifficulty());

        ConsoleOutputView.printPositions(ladderGame.getUsers());
        ConsoleOutputView.printLadder(ladderGame.getLadder());
        ConsoleOutputView.printPositions(ladderGame.getResults());

        String name = ConsoleInputView.inputNameForResult();
        if(name.equals("all")) {
            ConsoleOutputView.printAllResult(ladderGame.getUsers().getNames(), ladderGame.search());
        } else {
            ConsoleOutputView.printOneResult(name, ladderGame.search(name));
        }
    }
}

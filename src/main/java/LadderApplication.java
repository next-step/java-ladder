import domain.LadderGame;
import dto.InputDto;
import ui.InputView;
import ui.ResultView;

public class LadderApplication {
    private static final String ALL_RESULTS = "all";

    public static void main(String[] args){
        InputDto inputDto = InputView.askInput();
        LadderGame ladderGame = LadderGame.of(inputDto);
        ResultView.print(ladderGame);

        repeatUntilGivenAll(ladderGame);
    }

    private static void repeatUntilGivenAll(LadderGame ladderGame) {
        while(true) {
            String name = InputView.askName();

            if(name.toLowerCase().equals(ALL_RESULTS)) {
                ResultView.printAllResults(ladderGame);
                return;
            }

            ResultView.printResultOf(ladderGame, name);
        }
    }
}

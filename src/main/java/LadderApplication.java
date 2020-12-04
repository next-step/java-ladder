import domain.LadderGame;
import domain.Length;
import domain.PlayerNames;
import dto.InputDto;
import ui.InputView;
import ui.ResultView;

public class LadderApplication {
    public static void main(String[] args){
        InputDto inputDto = InputView.askInput();
        LadderGame ladderGame = LadderGame.of(inputDto);
        ResultView.print(ladderGame);

        String name = InputView.askName();
        ResultView.printResultOf(ladderGame, name);
    }
}

import domain.LadderGame;
import domain.Length;
import domain.PlayerNames;
import dto.InputDto;
import ui.InputView;
import ui.ResultView;

public class LadderApplication {
    public static void main(String[] args){
        InputDto inputDto = InputView.askInput();

        PlayerNames playerNames = PlayerNames.of(inputDto.getNames());
        Length height = Length.of(inputDto.getLadderHeight());

        LadderGame ladderGame = LadderGame.of(playerNames, height);

        ResultView.print(ladderGame);
    }
}

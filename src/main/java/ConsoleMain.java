

import dto.Line;
import dto.Players;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMain {

    public static void main(String args[]){
        Players players = new Players(InputView.inputNames());
        int lineCount = InputView.lineCount();
        List<Line> lines = new ArrayList<>();
        ResultView.printPlayer(players.getPlayers());
        for(int i =0 ; i< lineCount ; i++){
            ResultView.printLine(new Line(players.size()));
        }




    }
}

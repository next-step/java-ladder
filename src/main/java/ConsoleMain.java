

import dto.*;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class ConsoleMain {

    public static void main(String args[]){
        Players players = new Players(InputView.inputNames());
        Score score = new Score(InputView.scores());
        int lineCount = InputView.lineCount();
        List<Line> lines = new ArrayList<>();
        for(int i =0 ; i< lineCount ; i++){
            lines.add(new Line(players.size()));
        }
        LadderResult ladderResult = new LadderResult(lines,score);
        GameResult gameResult = new GameResult();

        //print
        ResultView.printResultMent();
        ResultView.printPlayer(players.getPlayers());
        for(Line line : lines){
            ResultView.printLine(line);
        }
        ResultView.printScore(ladderResult.getScore());

        for(int i = 0 ; i < players.size(); i++){
            int lastIndex = ladderResult.lastIndex(i);
            gameResult.addResult(players.nthPlayer(i),ladderResult.getScore().nthScore(lastIndex));
        }

        String seePlayer = InputView.wantToSeePlayerResult();
        if(seePlayer == "all"){
            ResultView.seePlayerResult(gameResult);
        }else{
            ResultView.seePlayerResult(gameResult.playersResult(players.hasPlayer(seePlayer)));
        }





    }
}

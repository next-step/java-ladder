package ui;

import domain.Line;
import domain.Player;
import utils.StringUtils;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class ConsoleUI {

    public static void main(String[] args){
        String names = InputView.inputNames();
        List<Player> players = StringUtils.joinPlayer(StringUtils.splitDelemeter(names));
        int ladderHeight = InputView.inputLadderMaxHeight();

        List<Line> lines = new ArrayList<>();
        for(int i =0; i < ladderHeight; i++){
            lines.add(new Line(players.size()));
        }
        ResultView.resultStart();
        ResultView.printNames(players);
        ResultView.printLadder(lines);
    }
}

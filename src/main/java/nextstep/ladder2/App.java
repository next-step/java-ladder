package nextstep.ladder2;

import nextstep.ladder2.ladder.Ladder;
import nextstep.ladder2.ladder.MakeRealLine;
import nextstep.ladder2.player.Players;
import nextstep.ladder2.result.Results;
import nextstep.ladder2.view.InputView;
import nextstep.ladder2.view.OutputView;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Players players;
        Results results;
        int height = 0;
        while(true){
            try{
                String names = InputView.getName(sc);
                players = Players.of(names);

                String result = InputView.getResults(sc);
                results = Results.of(result);

                height = InputView.getHeight(sc);
                break;
            }catch(Exception e){
                System.out.println(e.getMessage());
                continue;
            }
        }

        MakeRealLine maker = new MakeRealLine();


        Ladder ladder = new Ladder(maker, height, players.size());


        OutputView.viewInit(players, ladder, results);

        ladder.play(players);
        String name = InputView.inputName(sc);

        while (!"all".equals(name)) {
            OutputView.showResult(players, results, name);
            name = InputView.inputName(sc);
        }

        OutputView.showAllResult(players, results);
    }
}

package refactoring;

import java.util.Scanner;
import refactoring.domain.Ladder;
import refactoring.domain.LadderFatory;
import refactoring.domain.Match;
import refactoring.domain.MatchResults;
import refactoring.domain.MyLadderFactory;
import refactoring.domain.MyLineFactory;
import refactoring.domain.Results;
import refactoring.utils.CommaSplit;
import refactoring.view.InputView;
import refactoring.domain.Players;
import refactoring.view.LadderView;

public class LadderGameRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView();
        inputView.printNameComment();
        String names = scanner.nextLine();
        String[] split = CommaSplit.split(names);
        Players players = Players.of(split);

        inputView.printDepthComment();
        int depth = scanner.nextInt();
        LadderFatory ladderFactory = new MyLadderFactory(new MyLineFactory());
        Ladder ladder = ladderFactory.create(depth, players.size());

        inputView.printExecutionResult();
        String reword = scanner.nextLine();

        String[] rewords = CommaSplit.split(reword);
        Results results  = Results.of(rewords);
        LadderView ladderView = new LadderView(players, ladder);
        ladderView.printLadder(results);




    }

}

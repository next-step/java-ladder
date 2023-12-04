package nextstep.ladder;

import java.util.Scanner;
import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.LadderFactory;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

public class LadderMain {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        InputView.joinPeople();
        String peopleNames = scanner.nextLine();
        LadderFactory ladderFactory = new LadderFactory(peopleNames);
        InputView.getHeight();
        int height = scanner.nextInt();
        Ladder ladder = ladderFactory.ladder(height);
        ResultView.printResult(ladderFactory.people(), ladder);
    }
}

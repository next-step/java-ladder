package nextstep.ladder.view;

import nextstep.ladder.doman.LadderHeight;
import nextstep.ladder.doman.ParticipantNames;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static ParticipantNames getParticipantNames() {
        OutputView.printParticipantMessage();
        return new ParticipantNames(scanner.nextLine());
    }

    public static LadderHeight getLadderHeight() {
        OutputView.printMaxLadderHeight();
        return new LadderHeight(Integer.parseInt(scanner.nextLine()));
    }
}

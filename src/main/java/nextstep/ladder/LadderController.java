package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.member.Members;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.Supplier;

public class LadderController {
    private final static PrintWriter output = new PrintWriter(System.out, true);
    private final static ResultView resultView = new ResultView(output);

    private LadderController() {
    }

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in), output);
        createAndShowLadder(inputView);
        output.close();
    }

    private static void createAndShowLadder(InputView inputView) {
        Members members = getInputWithoutException(() -> Members.of(inputView.getMemberNames()));
        Ladder ladder = getInputWithoutException(() -> Ladder.of(members.getCount(), inputView.getLadderHeight()));
        showMembersAndLadders(members, ladder);
    }

    private static void showMembersAndLadders(Members members, Ladder ladder) {
        resultView.showTitle();
        resultView.showMemberNames(members.getNames());
        resultView.showLadder(ladder.getLines());
    }

    private static <T> T getInputWithoutException(Supplier<T> inputSupplier) {
        try {
            return inputSupplier.get();
        } catch (Exception exception) {
            output.println(exception.getMessage());
            output.println("");
            return getInputWithoutException(inputSupplier);
        }
    }
}

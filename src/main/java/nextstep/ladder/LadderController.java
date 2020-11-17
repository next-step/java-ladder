package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.member.Members;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.function.Supplier;

public class LadderController {
    static PrintWriter output = new PrintWriter(System.out, true);

    private LadderController() {
    }

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in), output);
        ResultView resultView = new ResultView(output);
        createAndShowLadder(inputView, resultView);
        output.close();
    }

    private static void createAndShowLadder(InputView inputView, ResultView resultView) {
        Members members = getInputWithoutException(() -> Members.of(inputView.getMemberNames()));
        Ladder ladder = getInputWithoutException(() -> Ladder.of(members, inputView.getLadderHeight()));
        showLadder(resultView, ladder);
    }

    private static void showLadder(ResultView resultView, Ladder ladder) {
        resultView.showTitle();
        resultView.showMemberNames(ladder.getMemberNames());
        resultView.showLines(ladder.getLines());
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

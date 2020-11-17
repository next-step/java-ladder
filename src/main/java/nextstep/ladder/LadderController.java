package nextstep.ladder;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.member.Members;
import nextstep.ladder.view.InputView;
import nextstep.ladder.view.ResultView;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class LadderController {
    private static final String ALL = "all";
    private static final PrintWriter output = new PrintWriter(System.out, true);
    private static final ResultView resultView = new ResultView(output);
    private static final InputView inputView = new InputView(new Scanner(System.in), output);

    private LadderController() {
    }

    public static void main(String[] args) {
        createLadderGameAndExecute();
        output.close();
    }

    private static void createLadderGameAndExecute() {
        Members members = getInputWithoutException(() -> Members.of(inputView.getMemberNames()));
        List<String> givenEndPoints = getInputWithoutException(inputView::getLadderResult);
        Ladder ladder = getInputWithoutException(() -> Ladder.of(members.getCount(), inputView.getLadderHeight()));

        showLadder(members, givenEndPoints, ladder);
        showLadderGameResult(LadderGameResult.of(members, ladder.followAllLinesToEndPoint(givenEndPoints)));
    }

    private static void showLadder(Members members, List<String> endPoints, Ladder ladder) {
        resultView.showTitle();
        resultView.showMemberNames(members.getNames());
        resultView.showLadder(ladder.getLines());
        resultView.showEndPoints(endPoints);
    }

    private static void showLadderGameResult(LadderGameResult gameResult) {
        String memberName = getInputWithoutException(inputView::getMemberName);
        if (ALL.equals(memberName)) {
            resultView.showEndPointsOfAllMembers(gameResult.getAll());
            return;
        }
        if (gameResult.hasEndPointOfMember(memberName)) {
            resultView.showEndPointOfMember(gameResult.getEndPointOfMember(memberName));
        }
        showLadderGameResult(gameResult);
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

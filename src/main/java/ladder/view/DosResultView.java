package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.line.LadderLine;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.Prize;
import ladder.domain.point.LadderPoint;
import ladder.dto.request.PrintResultRequest;
import ladder.dto.response.LadderResult;

import java.util.List;
import java.util.stream.IntStream;

public final class DosResultView implements ResultView {
    private void printResultTitle() {
        System.out.println(Text.RESULT_TITLE);
    }

    private void printEmptyLine(int size) {
        IntStream.range(0, size)
                .forEach(i -> System.out.println());
    }

    private void printEmptyLine() {
        printEmptyLine(1);
    }

    @Override
    public void printResult(PrintResultRequest request) {
        printResultTitle();

        printPlayers(request.players());
        printLadder(request.ladder());
        printPrizes(request.prizes());
    }

    private void printPlayers(Players players) {
        players.forEach(iPlayer ->
                System.out.print(Text.PLAYER.format(iPlayer))
        );
        printEmptyLine();
    }

    private void printLadder(Ladder ladder) {
        ladder.forEach(this::printLadderLine);
    }

    private void printLadderLine(LadderLine ladderLine) {
        ladderLine.forEach(this::printLadderPoint);

        printEmptyLine();
    }

    private void printLadderPoint(LadderPoint point) {
        System.out.print(ropeText(point));
    }

    private Text ropeText(LadderPoint point) {
        return point.isLeft() ? Text.LEFT_ROPE : Text.EMPTY_RIGHT_ROPE;
    }

    private void printPrizes(List<Prize> prizes) {
        prizes.forEach(this::printPrize);
        printEmptyLine(2);
    }

    private void printPrize(Prize prize) {
        System.out.print(Text.PRIZE.format(prize));
    }

    @Override
    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void printPrizeOwner(LadderResult ladderResult, Player player) {
        printResultTitle();

        System.out.println(ladderResult.prize(player));
        printEmptyLine();
    }

    @Override
    public void printPrizeAll(LadderResult ladderResult, Players players) {
        printResultTitle();

        players.forEach(
                iPlayer ->
                        System.out.println(
                                Text.PRIZE_ALL.format(iPlayer, ladderResult.prize(iPlayer))
                        )
        );
    }

    private enum Text {
        RESULT_TITLE("실행결과\n"),
        PLAYER("%5s "),
        PRIZE("%-5s "),
        LEFT_ROPE("-----|"),
        EMPTY_RIGHT_ROPE("     |"),
        PRIZE_ALL("%s : %s");

        private final String str;

        Text(String str) {
            this.str = str;
        }

        public String format(Object... objs) {
            return String.format(str, objs);
        }

        @Override
        public String toString() {
            return str;
        }
    }
}
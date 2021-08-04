package ladder.view;

import ladder.domain.*;
import ladder.dto.response.LadderResult;

import java.util.List;
import java.util.stream.IntStream;

public class DosResultView implements ResultView {
    @Override
    public void printResult(LadderResult ladderResult, Players players) {
        printResultTitle();

        printPlayers(players);
        printLadder(ladderResult.ladder());
    }

    private void printPlayers(Players players) {
        players.forEach(iPlayer ->
                System.out.print(Text.PLAYER.format(iPlayer))
        );
        printEmptyLine();
    }

    private void printLadder(Ladder ladder) {
        ladder.forEach(this::printLadderLine);
        printLadderPrizes(ladder.prizes());
    }

    private void printLadderLine(LadderLine ladderLine) {
        ladderLine.forEach(this::printRope);

        printEmptyLine();
    }

    private void printRope(Rope rope) {
        System.out.print(ropeText(rope));
    }

    private Text ropeText(Rope rope) {
        return rope.isPresent() ? Text.PRESENT_ROPE : Text.EMPTY_ROPE;
    }

    private void printLadderPrizes(List<Prize> prizes) {
        prizes.forEach(this::printLadderPrize);
        printEmptyLine(2);
    }

    private void printLadderPrize(Prize prize) {
        System.out.print(Text.PRIZE.format(prize));
    }

    @Override
    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    @Override
    public void printPrize(LadderResult ladderResult, Player player) {
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

    private enum Text {
        RESULT_TITLE("실행결과\n"),
        PLAYER("%5s "),
        PRIZE("%-5s "),
        PRESENT_ROPE("-----|"),
        EMPTY_ROPE("     |"),
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

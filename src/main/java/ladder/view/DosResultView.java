package ladder.view;

import ladder.domain.*;

public class DosResultView implements ResultView {
    @Override
    public void printResult(Players players, Ladder ladder) {
        System.out.println(Text.RESULT_TITLE);
        printPlayers(players);
        printLadder(ladder);
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
        System.out.print(Text.EMPTY_ROPE);
        ladderLine.forEach(this::printRope);

        printEmptyLine();
    }

    private void printRope(Rope rope) {
        System.out.print(ropeText(rope));
    }

    private Text ropeText(Rope rope) {
        return rope.isPresent() ? Text.PRESENT_ROPE : Text.EMPTY_ROPE;
    }

    @Override
    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    private void printEmptyLine() {
        System.out.println();
    }

    private enum Text {
        RESULT_TITLE("실행결과\n"),
        PLAYER("%5s "),
        PRESENT_ROPE("-----|"),
        EMPTY_ROPE("     |");

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

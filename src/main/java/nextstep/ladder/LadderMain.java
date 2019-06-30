package nextstep.ladder;

public class LadderMain {
    public static void main(String[] args) {
        Players players = new Players(askPlayersName());
        Ladder ladder = new Ladder(askLadderHeight(), players.countOfPlayer());
        OutView.println(players.getFormattedName());
        OutView.println(ladder.getFormattedLine());
    }

    private static String askPlayersName() {
        OutView.askPlayersName();
        return InView.getString();
    }

    private static int askLadderHeight() {
        OutView.askLadderHeight();
        return InView.getInt();
    }
}

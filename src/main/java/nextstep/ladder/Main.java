package nextstep.ladder;

public class Main {

    public static void main(String[] args) {
        Names names = View.getNames();
        LadderHeight ladderHeight = View.getLadderHeight();
        Ladder ladder = Ladder.getRandomly(ladderHeight, names);
        View.printLadder(ladder);
    }
}

package nextstep.ladder;

public class Main {

    public static void main(String[] args) {
        Names names = View.getNames();
        Results results = View.getResults(names);
        LadderHeight ladderHeight = View.getLadderHeight();
        Ladder ladder = Ladder.getRandomly(ladderHeight, names);
        View.printLadder(ladder, results);
        LadderResultMap resultMap = LadderResultMap.execute(ladder, results);
        View.printResult(resultMap);
    }
}

package ladder;

import ladder.domain.*;
import ladder.domain.ladder.LadderFactory;
import ladder.domain.ladder.RandomLadderFactory;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private static final LadderFactory LADDER_FACTORY = new RandomLadderFactory();

    public static void main(String[] args) {
        Names names = InputView.inputNames();
        int height = InputView.inputHeight();
        List<String> prizes = InputView.inputPrizes(names.names().size());

        RandomLadder randomLadder = LADDER_FACTORY.createLadder(names.names().size() - 1, height);
        Map<Name, String> result = playing(names, prizes, randomLadder);

        ResultView.printResult(names, randomLadder, prizes);
        ResultView.printPersonPrize(InputView.inputPersonName(), result);
    }

    public static Map<Name, String> playing(Names names, List<String> prizes, RandomLadder randomLadder) {
        Map<Name, String> result = new HashMap<>();
        for(Name name: names.names()){
            int currentPosition = names.names().indexOf(name);
            currentPosition = eachNamePosition(names, randomLadder, currentPosition);
            result.put(name, prizes.get(currentPosition));
        }
        return result;
    }

    private static int eachNamePosition(Names names, RandomLadder randomLadder, int currentPosition) {
        for(int i = 0; i < randomLadder.size(); i++){
            currentPosition = moveOrStay(names, randomLadder, currentPosition, i);
        }
        return currentPosition;
    }

    private static int moveOrStay(Names names, RandomLadder randomLadder, int currentPosition, int i) {
        if(canMoveRight(names, randomLadder, currentPosition, i)){
            return ++currentPosition;
        }
        if(canMoveLeft(randomLadder, currentPosition, i)){
            return --currentPosition;
        }
        return currentPosition;
    }

    private static boolean canMoveRight(Names names, RandomLadder randomLadder, int currentPosition, int i) {
        return currentPosition < names.names().size() - 1 && randomLadder.isMarked(i, currentPosition);
    }

    private static boolean canMoveLeft(RandomLadder randomLadder, int currentPosition, int i) {
        return currentPosition > 0 && randomLadder.isMarked(i, currentPosition - 1);
    }

}

package ladder;

import ladder.domain.*;
import ladder.domain.util.RandomBooleanGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    public static void main(String[] args) {
        Names names = InputView.inputNames();
        int height = InputView.inputHeight();
        List<String> prizes = InputView.inputPrizes(names.names().size());

        Ladder ladder = new Ladder(names.names().size() - 1, height, new RandomBooleanGenerator()).makeLadder();
        Map<Name, String> result = playing(names, prizes, ladder);

        ResultView.printResult(names, ladder, prizes);
        ResultView.printPersonPrize(InputView.inputPersonName(), result);
    }

    public static Map<Name, String> playing(Names names, List<String> prizes, Ladder ladder) {
        Map<Name, String> result = new HashMap<>();
        for(Name name: names.names()){
            int currentPosition = names.names().indexOf(name);
            currentPosition = eachNamePosition(names, ladder, currentPosition);
            result.put(name, prizes.get(currentPosition));
        }
        return result;
    }

    private static int eachNamePosition(Names names, Ladder ladder, int currentPosition) {
        for(int i = 0; i < ladder.size(); i++){
            currentPosition = moveOrStay(names, ladder, currentPosition, i);
        }
        return currentPosition;
    }

    private static int moveOrStay(Names names, Ladder ladder, int currentPosition, int i) {
        if(canMoveRight(names, ladder, currentPosition, i)){
            currentPosition++;
        } else if(canMoveLeft(ladder, currentPosition, i)){
            currentPosition--;
        }
        return currentPosition;
    }

    private static boolean canMoveRight(Names names, Ladder ladder, int currentPosition, int i) {
        return currentPosition < names.names().size() - 1 && ladder.isMarked(i, currentPosition);
    }

    private static boolean canMoveLeft(Ladder ladder, int currentPosition, int i) {
        return currentPosition > 0 && ladder.isMarked(i, currentPosition - 1);
    }

}

package ladder.domain;

import ladder.domain.ladder.RandomLadder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

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

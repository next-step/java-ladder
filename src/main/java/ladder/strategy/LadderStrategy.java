package ladder.strategy;

import ladder.domain.Ladder;

import java.util.ArrayList;

public class LadderStrategy {

    public static boolean validLadder(Ladder ladder) {

        int height = ladder.getHeight();
        int countOfPerson = ladder.getCountOfPerson();
        boolean result = true;

        for (int i = 0; i < countOfPerson; i++) {
            ArrayList<Boolean> a = new ArrayList<>();
            for (int j = 0; j < height; j++) {
                a.add(ladder.getLadder().get(j).getPoints().get(i));
            }
            if (i != 0 && a.stream().noneMatch(point -> point == true)) {
                result = false;
                break;
            }
        }
        return result;
    }

}

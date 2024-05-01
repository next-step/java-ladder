package nextstep;

import nextstep.domain.Ladder;
import nextstep.domain.LadderResult;

import java.util.*;

public class LadderGame {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        OutView.createParticipantsView();
        String names = InputView.createField();
        ;
        OutView.createPrizeView();
        List<String> prizeList = InputView.createPrizeList();

        OutView.createHeightView();
        String height = InputView.createField();

        Ladder ladder = new Ladder(names, Integer.valueOf(height));

        LadderResult ladderResult = ladder.createLadderResult(prizeList);
        OutView outView = new OutView(ladderResult);
        OutView.createLadderResultView(ladder, prizeList);

        boolean result = false;
        do {
            outView.createStartResultView();
            String field = InputView.createField();
            result = outView.createResultView(field);
        } while (!result);

    }
}

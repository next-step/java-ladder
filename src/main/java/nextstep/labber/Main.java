package nextstep.labber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LadderView ladderView = new LadderView(bufferedReader);

        List<User> list = ladderView.participantsList();
        List<String> result = ladderView.enterResult();
        int ladderHeight = ladderView.enterLadderHeight();

        Ladder ladder = new Ladder(ladderHeight, list);

        ladderView.drawParticipants(list);
        ladderView.drawLadder(ladder.ladder());
        ladderView.drawProduct(result);

        while (true) {
            String entered = ladderView.findResult();
            Map<String, Integer> allResult = ladder.findAllResult();
            ladderView.drawResult(entered, result, allResult);
        }
    }
}

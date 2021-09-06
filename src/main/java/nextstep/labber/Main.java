package nextstep.labber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        LadderView ladderView = new LadderView(bufferedReader);

        List<User> list = ladderView.participantsList();
        int ladderHeight = ladderView.enterLadderHeight();

        List<Line> ladder = Ladder.createLadder(list.size(), ladderHeight);

        ladderView.drawParticipants(list);
        ladderView.drawLadder(ladder);

    }
}

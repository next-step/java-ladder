package nextstep.ladder;

import nextstep.ladder.view.InputView;

import java.util.List;

public class LadderApplication {

public static void main(String[] args) {
        int ladderHeight = InputView.getLadderHeight();
        List<String> participants = InputView.getParticipants();
    }
}

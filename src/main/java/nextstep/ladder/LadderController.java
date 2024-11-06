package nextstep.ladder;

import java.util.List;

public class LadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> participantsList = inputView.getParticipantsName();

        int ladderHeight = inputView.getLadderHeight();



    }
}

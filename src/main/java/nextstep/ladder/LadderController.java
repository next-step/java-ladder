package nextstep.ladder;

public class LadderController {

    public static void main(String[] args) {
        InputView inputView = new InputView();

        Players players = new Players(inputView.getPlayersName());

        int ladderHeight = inputView.getLadderHeight();

    }
}

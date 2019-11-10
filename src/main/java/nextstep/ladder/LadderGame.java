package nextstep.ladder;

public class LadderGame {

    public static void start(LadderGameView view) {
        Participants participants = new Participants(view.getNames());
        int height = view.getHeight();

        Lines lines = new Lines(height, participants.size() - 1);
        view.showResult(participants.getVaule(), lines.getValue());
    }
}

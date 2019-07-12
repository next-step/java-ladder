package ladder.domain;

import ladder.view.InputView;

public class LadderGameInfo {

    private String participantNames;
    private String goals;
    private int height;

    public LadderGameInfo(String participantNames, String goals, int height) {
        this.participantNames = participantNames;
        this.goals = goals;
        this.height = height;
    }

    public static LadderGameInfo readInput() {
        return new LadderGameInfo(InputView.askParticipantNames(), InputView.askGoals(), InputView.askHeight());
    }

    public String getParticipantNames() {
        return participantNames;
    }

    public String getGoals() {
        return goals;
    }

    public int getHeight() {
        return height;
    }
}

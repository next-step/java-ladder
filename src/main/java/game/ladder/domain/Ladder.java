package game.ladder.domain;

public class Ladder {
    private final UserInputs userInputs;
    private final LadderLines ladderLines;

    public Ladder(UserInputs userInputs, LadderLines ladderLines) {
        this.userInputs = userInputs;
        this.ladderLines = ladderLines;
    }

    public String makeStringLadder() {
        StringBuilder sb = new StringBuilder();
        sb.append(userInputs.getStringParticipantsNames()).append(System.lineSeparator());
        sb.append(ladderLines.getStringLadderLines());
        sb.append(userInputs.getStringExpects()).append(System.lineSeparator());
        return sb.toString();
    }

    public GameResults makeGameResults(Name name) {
        return this.userInputs.makeGameResults(name, this.ladderLines);
    }
}

package game.ladder.domain;

public class Ladder {

    private final Lines lines;
    private final UserInputs userInputs;

    public Ladder(LinesGenerator generator, UserInputs userInputs) {
        this.lines = generator.generate(userInputs.partipantsSize());
        this.userInputs = userInputs;
    }

    public String makeStringLadder() {
        StringBuilder sb = new StringBuilder();
        sb.append(userInputs.getStringParticipantsNames()).append(System.lineSeparator());
        sb.append(lines.getStringLines()).append(System.lineSeparator());
        sb.append(userInputs.getStringExpects());

        return sb.toString();
    }

    public GameResults makeGameResults(Name name) {
        return this.userInputs.makeGameResults(name, this.lines);
    }
}

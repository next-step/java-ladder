package game.ladder.domain;

public class Ladder {

    private final Participants participants;
    private final Lines lines;

    public Ladder(LinesGenerator generator, Participants participants) {
        this.participants = participants;
        this.lines = generator.generate(participants.size());
    }

    public String makeStringLadder() {
        StringBuilder sb = new StringBuilder();
        sb.append(participants.getAllFormattedNames()).append(System.lineSeparator());
        sb.append(lines.getStringLines()).append(System.lineSeparator());

        return sb.toString();
    }


}

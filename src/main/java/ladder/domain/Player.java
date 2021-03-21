package ladder.domain;

public class Player {

    private final Name name;

    private final LadderNumber startLadderNumber;

    public Player(String name, int ladderNumber) {
        this(new Name(name), new LadderNumber(ladderNumber));
    }

    public Player(Name name, LadderNumber ladderNumber) {
        this.name = name;
        this.startLadderNumber = ladderNumber;
    }

    public String name() {
        return name.toString();
    }

    public boolean isMatch(String playerName) {
        return name.equals(new Name(playerName));
    }

    public LadderNumber startLadderNumber() {
        return startLadderNumber;
    }
}

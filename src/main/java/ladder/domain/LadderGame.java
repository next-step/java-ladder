package ladder.domain;

public class LadderGame {

    private final LadderGameInformation ladderGameInformation;
    private final Ladder ladder;

    public LadderGame(LadderGameInformation ladderGameInformation, Ladder ladder) {
        this.ladderGameInformation = ladderGameInformation;
        this.ladder = ladder;
    }

    public LadderGameResult getResult() {
//        return ladder.run().stream().collect(Collectors.toList());
        return null;
    }


}

package nextstep.domain;

public class Ladder
{
    private final LadderLines ladderLines;
    private final LadderHeight ladderHeight;

    public Ladder(LadderLines ladderLines , LadderHeight ladderHeight)
    {
        this.ladderLines = ladderLines;
        this.ladderHeight = ladderHeight;
    }
}

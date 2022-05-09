package nextstep.domain;

import java.util.List;

public class StartLadderGame
{
    private final List<User> users;
    private final LadderHeight maxLadderHeight;

    public StartLadderGame(List<User> users, LadderHeight ladderHeight)
    {
        this.users = users;
        this.maxLadderHeight = ladderHeight;
    }

}

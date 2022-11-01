package ladderapplication.models.requests;

import java.util.List;

public class GameSettingRequest {

    private final LadderRequest ladderRequest;
    private final List<PlayerRequest> playerRequests;

    private GameSettingRequest(LadderRequest ladderRequest, List<PlayerRequest> playerRequests) {
        this.ladderRequest = ladderRequest;
        this.playerRequests = playerRequests;
    }

    public LadderRequest getLadderRequest() {
        return ladderRequest;
    }

    public List<PlayerRequest> getPlayerRequests() {
        return playerRequests;
    }

    public static GameSettingRequest of(LadderRequest ladderRequest, List<PlayerRequest> playerRequests) {
        return new GameSettingRequest(ladderRequest, playerRequests);
    }
}

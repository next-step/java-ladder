package ladder.domain.user;

import ladder.common.Csv;
import ladder.domain.ladderline.LadderLines;
import ladder.domain.ladderline.LadderProxy;

import java.util.HashMap;
import java.util.Map;

public class LadderPlayer {
    private LadderLines ladderLines;
    private LadderUsers ladderUsers;
    private Csv ladderResult;

    private LadderPlayer(LadderLines ladderLines, LadderUsers ladderUsers, Csv ladderResult) {
        this.ladderLines = ladderLines;
        this.ladderUsers = ladderUsers;
        this.ladderResult = ladderResult;
    }

    public static LadderPlayer of(LadderLines ladderLines, LadderUsers ladderUsers, Csv ladderResult) {
        return new LadderPlayer(ladderLines, ladderUsers, ladderResult);
    }

    public LadderResult start(Username username) {
        return username.isAllUser() ? moveAllUser() : moveUser(username);
    }

    private LadderResult moveUser(Username username) {
        Map<Username, String> resultMap = new HashMap<>();
        resultMap.put(username, move(username));
        return LadderResult.of(resultMap);
    }

    private LadderResult moveAllUser() {
        Map<Username, String> resultMap = new HashMap<>();
        ladderUsers.getUsernames().stream()
                .forEach(username -> resultMap.put(username, move(username)));
        return LadderResult.of(resultMap);
    }

    private String move(Username username) {
        return ladderResult.getValue(LadderProxy.move(ladderLines, ladderUsers.getUserIndex(username)));
    }
}

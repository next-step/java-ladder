package nextstep.ladder2.domain.result;

import java.util.Collections;
import java.util.List;
import nextstep.ladder2.domain.player.NxPlayer;

public class NxResultBoard {
    private final List<NxResult> resultBoard;

    public NxResultBoard(List<NxResult> resultBoard) {
        this.resultBoard = resultBoard;
    }

    public NxResult findResultByPlayer(NxPlayer player) {
        return resultBoard.stream()
                .filter(result -> result.findPlayer(player))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 이름을 가진 플레이어가 없습니다."));
    }

    public List<NxResult> getResultBoard() {
        return Collections.unmodifiableList(resultBoard);
    }
}

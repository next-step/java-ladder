package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<LadderPiece> ladderPieces = new ArrayList<>();

    public Line(int length) {
        LadderPiece leftLadderPiece = null;
        for (int outerIndex = 0; outerIndex < length; outerIndex++) {
            LadderPiece ladderPiece = new LadderPiece();
            connectLadderPiece(leftLadderPiece, ladderPiece);
            leftLadderPiece = ladderPiece;
            ladderPieces.add(ladderPiece);
        }
    }

    public List<LadderPiece> getLadderPieces() {
        return Collections.unmodifiableList(ladderPieces);
    }

    public LadderPiece getLadderPiece(int index) {
        return this.ladderPieces.get(index);
    }

    public void settingBridgeOnAllPiece(BridgeInterface bridgeInterface) {
        this.ladderPieces.forEach((ladderPiece) -> ladderPiece.settingBridge(bridgeInterface));
    }

    public void connectToUnder(Line bottomLine) {
        List<LadderPiece> topLineLadderPieces = this.getLadderPieces();
        List<LadderPiece> bottomLineLadderPieces = bottomLine.getLadderPieces();

        for (int index = 0; index < topLineLadderPieces.size(); index++) {
            topLineLadderPieces.get(index).setBottomPiece(bottomLineLadderPieces.get(index));
        }
    }

    private void connectLadderPiece(LadderPiece left, LadderPiece right) {
        if (left == null) {
            return;
        }
        left.connectToRight(right);
    }

}

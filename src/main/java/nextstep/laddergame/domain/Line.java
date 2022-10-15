package nextstep.laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<LadderPiece> ladderPieces = new ArrayList<>();

    public Line(int length) {
        LadderPiece leftLadderPiece = new LadderPiece();
        ladderPieces.add(leftLadderPiece);
        for (int outerIndex = 1; outerIndex < length; outerIndex++) {
            LadderPiece rightLadderPiece = leftLadderPiece.makeAndLinkNewLadderPieceToRight();
            leftLadderPiece = rightLadderPiece;
            ladderPieces.add(rightLadderPiece);
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

    public Line makeAndLinkNewLineToUnder() {
        Line bottomLine = new Line(this.ladderPieces.size());

        List<LadderPiece> topLineLadderPieces = this.getLadderPieces();
        List<LadderPiece> bottomLineLadderPieces = bottomLine.getLadderPieces();

        for (int index = 0; index < topLineLadderPieces.size(); index++) {
            topLineLadderPieces.get(index).setBottomPiece(bottomLineLadderPieces.get(index));
        }
        return bottomLine;
    }

}

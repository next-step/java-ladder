package step4.domain;

import java.util.List;
import step4.domain.column.LadderColumn;
import step4.exceptions.NotEqualColumnSizeException;

public class LadderResult {
    private LadderColumn startNames;
    private LadderColumn resultNames;
    private List<Integer> moveResult;


    public void addStartNames(LadderColumn ladderColumn) {
        this.startNames = ladderColumn;
    }

    public void addResultNames(LadderColumn ladderColumn) {
        this.resultNames = ladderColumn;
    }


    public void matchNameSize() {
        startNames.matchSize(resultNames);
    }


    public int sizeOfPerson() {
        return startNames.sizeOfPerson();
    }


    public LadderColumn startNames() {
        return startNames;
    }

    public LadderColumn resultNames() {
        return resultNames;
    }

    public List<Integer> moveResult() {
        return moveResult;
    }

    public void addLadderResult(List<Integer> moveResult) {
        if (moveResult.size() != startNames.sizeOfPerson()) {
            throw new NotEqualColumnSizeException();
        }
        this.moveResult = moveResult;
    }
}

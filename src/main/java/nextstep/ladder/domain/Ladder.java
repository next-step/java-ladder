package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final static String EMPTY_LINE_EXCEPTION = "하나 이상의 라인이 필요합니다.";
    private final List<Line> lineList;

    public Ladder(List<Line> lineList) {
        validate(lineList);
        this.lineList = lineList;
    }

    void validate(List<Line> lineList){
        if(lineList == null || lineList.size() == 0){
            throw new IllegalArgumentException(EMPTY_LINE_EXCEPTION);
        }
    }

    public static Ladder of(int rowCnt, int colCnt, PointCreationRule pointCreationRule) {
        List<Line> lineList = new ArrayList<>();
        for(int i=0; i<rowCnt; i++){
            lineList.add(Line.of(colCnt, pointCreationRule));
        }
        return new Ladder(lineList);
    }

    public List<Line> getLineList() {
        return lineList;
    }

}

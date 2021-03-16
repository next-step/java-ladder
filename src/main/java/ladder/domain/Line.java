package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    public Line (int countOfPerson) {
        int totalHorizontalLine = countOfPerson * 2 -1;
        Random rd = new Random();
        boolean isPreviousConnected = false;
        for (int i = 0; i < totalHorizontalLine ; i++) {
            if( i % 2 != 0) {
                boolean newConnectingLine = rd.nextBoolean();
                if(isPreviousConnected){
                    newConnectingLine = false;
                }
                points.add(newConnectingLine);
                isPreviousConnected= newConnectingLine;
            }else{
                points.add(Boolean.TRUE);
            }
        }
        // 라인의 좌표 값에 선이 있는지 유무를 판단하는 로직 추가
    }

    public List<Boolean> getPoints() {
        return points;
    }
}

package domain;

import utils.BooleanGenerator;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final String VERTICAL_BAR = "|";
    private final int LINE_WIDTH = 5;
    private List<Boolean> points;

    public Line (int countOfPerson) {
        if(countOfPerson < 0){
            throw new RuntimeException("음수가 올 수 없습니다.");
        }
        BooleanGenerator booleanGenerator = new BooleanGenerator();
        points = booleanGenerator.generateLine(countOfPerson);
    }

    public Line (List<Boolean> points) {
        for(int i =1; i < points.size(); i++){
            if(points.get(i-1) && points.get(i)){
                throw new RuntimeException("성립할 수 없는 사다리 구조입니다.");
            }
        }
        this.points = points;
    }

    @Override
    public String toString() {
        String line = VERTICAL_BAR;
        for(Boolean bool : points){
            line += drawLine(bool) + VERTICAL_BAR;
        }
        return line;
    }

    private String drawLine(Boolean bool) {
        if(bool){
            return StringUtils.getReplace(StringUtils.MID_BAR, LINE_WIDTH);
        }
        return StringUtils.getReplace(StringUtils.SPACE, LINE_WIDTH);
    }


}

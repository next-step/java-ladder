package domain;

import utils.BooleanGenerator;
import utils.StringUtils;

import java.util.ArrayList;

public class Line {
    private final String VERTICAL_BAR = "|";
    private final int LINE_WIDTH = 5;
    private ArrayList<Boolean> points;

    public Line (int countOfPerson) {
        if(countOfPerson < 0){
            throw new RuntimeException("음수가 올 수 없습니다.");
        }
        BooleanGenerator booleanGenerator = new BooleanGenerator();
        points = booleanGenerator.generatLine(countOfPerson);
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

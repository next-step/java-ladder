package domain;

import utils.BooleanGenerator;
import utils.StringUtils;

import java.util.List;

public class Line{
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
        return points.stream().map(x-> drawLine(x)).reduce("",(x,y)->x + VERTICAL_BAR + y).concat(VERTICAL_BAR);
    }

    private String drawLine(Boolean bool) {
        if(bool){
            return StringUtils.getReplace(StringUtils.MID_BAR, LINE_WIDTH);
        }
        return StringUtils.getReplace(StringUtils.SPACE, LINE_WIDTH);
    }

    public int nextPosition(int index) {

        if(index==0){
            if(points.get(index)){
                return index+1;
            }
        }

        if(index==points.size()){
            if(points.get(index-1)){
                return index-1;
            }
        }

        if(index > 0 && index < points.size()) {
            if (points.get(index - 1)) {
                return index - 1;
            }
            if (points.get(index)) {
                return index + 1;
            }
        }

        return index;
    }
}

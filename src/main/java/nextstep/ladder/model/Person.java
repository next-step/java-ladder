package nextstep.ladder.model;
import java.util.List;

public class Person {
    private String name;
    private int position;

    public Person(String name, int position){
        this.name = name;
        this.position = position;
    }
    public String getName(){
        return name;
    }
    public int getPosition(){
        return position;
    }
    public int getPosition(List<Line> lines){
        for(Line line : lines){
            position = movePosition(position, line.getPoints());
        }
        return position;
    }
    public int movePosition(int position, List<Boolean> points){
        if(position != points.size() && points.get(position)){
            return position + 1;
        }
        if(position !=0 && points.get(position-1)){
            return position - 1;
        }
        return position;
    }
}

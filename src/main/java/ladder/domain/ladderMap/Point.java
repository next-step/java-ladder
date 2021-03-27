package ladder.domain.ladderMap;

public class Point {
    private String value;

    public Point(int idx){
        this.value = mark(idx);
    }

    private String mark(int idx){
        if(idx%5==4){
            return "|";
        }
        return " ";
    }

    public String value(){
        return this.value;
    }
}

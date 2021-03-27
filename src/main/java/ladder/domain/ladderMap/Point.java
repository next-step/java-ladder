package ladder.domain.ladderMap;

public class Point {
    private String value;

    public Point(int idx){
        this.value = initialValue(idx);
    }

    private String initialValue(int idx){
        if(idx%5==4){
            return "|";
        }
        return " ";
    }

    public boolean vertical(){
        return this.value.equals("|");
    }

    public boolean horizontal() {
        return this.value.equals("-");
    }

    public boolean empty(){
        return this.value.equals(" ");
    }

    public String value(){
        return this.value;
    }

    public Point nowHorizontal() {
        this.value = "-";
        return this;
    }
}

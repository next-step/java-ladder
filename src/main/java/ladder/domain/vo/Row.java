package ladder.domain.vo;

public class Row {

    private final Integer width;

    public Row(Integer width) {
        if(width > 5)
            throw new IllegalArgumentException("길이는 5가 최대입니다.");
        this.width = width;
    }

    public Integer width(){
        return this.width;
    }

    public Boolean exist(){
        return this.width > 0;
    }

}

package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Line {
    // private Integer[] array;

    // public Integer[] getArray(){
    //     return array;
    // }

    // public void setArray(Integer[] array){
    //     this.array = array;
    // }

    private List<Integer> array;

    public List<Integer> getArray(){
        return array;
    }

    public Line(Integer[] array){
        this.array = Arrays.stream(array).collect(Collectors.toList());
    }
}
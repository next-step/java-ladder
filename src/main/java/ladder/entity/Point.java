package ladder.entity;

import ladder.exception.CustomException;
import ladder.exception.ErrorCode;

public class Point {

    private int index;

    public Point(int index){
        this.index = verifiedIndex(index);
    }

    private int verifiedIndex(int index){
        if(index<0){
            throw new CustomException(ErrorCode.INVALID_POINT_INDEX);
        }
        return index;
    }

    public int index(){
        return this.index;
    }
}

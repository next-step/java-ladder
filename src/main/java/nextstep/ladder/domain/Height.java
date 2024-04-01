package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Height{
    private final int height;

    public Height(int height) {
        if(height <= 1){
            throw new IllegalArgumentException();
        }
        this.height = height;
    }

    public int getSize(){
        return this.height;
    }
}

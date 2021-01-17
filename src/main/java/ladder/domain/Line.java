package ladder.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Line {
    private List<ArrayList<Boolean>> line;
    private int column;

    private Line(int countOfPerson){
        this.line = new ArrayList<>();
        this.column = countOfPerson;
    }

    protected void addLine(){
        List<Boolean> booleans = new ArrayList<>();
        int ladderColumn = column - 1;
        Random random = new Random(2);
        int initRandom = random.nextInt();
        
        for(int i = 0; i < ladderColumn; i++) {

        }

    }



}
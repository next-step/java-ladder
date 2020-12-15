package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private List<Line> list;

    public List<Line> getLadder(){
        return list;
    }

    public Ladder(int width, int height){
        List<Line> list = new ArrayList<>();
        for(int i = 0; i < height; i++){
            Line row = new Line();
            row.setArray(settingWidth(width));
            list.add(row);
        }
        this.list = list;
    }

    public Ladder(){
    }

    public int randomInt(){
        Random rd = new Random();
        return rd.nextInt(2);
    }

    public Integer[] settingWidth(int size){
        int width = size + (size - 1);
        Integer[] row = new Integer[width];
        for(int i = 0; i < row.length; i++) {
            row = settingRow(row, i);
        }
        return row;
    }

    public Integer[] settingRow(Integer[] row, int i){
        if (i % 2 != 0) {
            row = createRow(row, i, randomInt());
        }
        if (i % 2 == 0) {
            row[i] = 2;
        }
        return row;
    }

    public Integer[] createRow(Integer[] row, int i, int random){
        if (i > 2 && row[i-2] == 1) {
            row[i] = 0;
        }
        if (i > 2 && row[i-2] != 1) {
            row[i] = random;
        }
        if (i < 2) {
            row[i] = random;
        }
        return row; 
    }

}
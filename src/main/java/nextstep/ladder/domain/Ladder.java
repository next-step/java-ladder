package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private List<Integer[]> list;

    public List<Integer[]> getLadder(){
        return list;
    }
    
    public void setLadder(int width, int height){
        List<Integer[]> list = new ArrayList<>();
        for(int i = 0; i < height; i++){
            Integer[] row = settingWidth(width);
            list.add(row);
        }
        this.list = list;
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
            row = validateRow(row, i);
        }
        if (i % 2 == 0) {
            row[i] = 2;
        }
        return row;
    }

    public Integer[] validateRow(Integer[] row, int i){
        if (i > 2 && row[i-2] == 1) {
            row[i] = 0;
        }
        if (i > 2 && row[i-2] != 1) {
            row[i] = randomInt();
        }
        if (i < 2) {
            row[i] = randomInt();
        }
        return row; 
    }

}
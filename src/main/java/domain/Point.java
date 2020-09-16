package domain;

import static utility.generatorPoint.makeDirection;

public class Point {
    private int index;
    private boolean left;
    private boolean right;


    public Point(int index, boolean makeDirection) {
        this.index =index;
        this.right= makeDirection;
    }

    public Point next(){
        if(this.right){
            return new Point(index+1, false);
        }
        return new Point(index+1,makeDirection());
    }

    public boolean isRight() {
        return right;
    }

    public Point last() {
        Point last =  new Point(index+1,false);
        return last;
    }
}

package me.namuhuchutong.ladder.domain.wrapper;

public class Flag {

    private boolean flag;

    public Flag() {
        this.flag = false;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean peek() {
        return flag;
    }
}

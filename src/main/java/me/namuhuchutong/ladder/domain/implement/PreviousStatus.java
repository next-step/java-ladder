package me.namuhuchutong.ladder.domain.implement;

public class PreviousStatus {

    private boolean createdBefore;

    public PreviousStatus() {
        this.createdBefore = false;
    }

    public boolean isNotCreatedBefore() {
        return !createdBefore;
    }

    public void setCreated() {
        this.createdBefore = true;
    }

    public void setNotCreated() {
        this.createdBefore = false;
    }
}

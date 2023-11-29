package com.fineroot.ladder.viewmodel;

public class InputViewModel {

    private String usernameString;
    private int height;

    public void saveLadderHeight(final int ladderHeight){
        this.height=ladderHeight;
    }
    public void saveUsernameString(final String usernameString){
        this.usernameString=usernameString;
    }

    public String getUsernameString() {
        return usernameString;
    }

    public int getHeight() {
        return height;
    }
}

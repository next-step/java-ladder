package com.fineroot.ladder.viewmodel;

public class InputViewModel {

    private String usernamesString;
    private int height;
    private String rewardsString;
    private String usernameString;

    public void saveLadderHeight(final int ladderHeight){
        this.height=ladderHeight;
    }
    public void saveUsernamesString(final String usernameString){
        this.usernamesString =usernameString;
    }

    public void saveRewardsString(final String rewardsString){
        this.rewardsString=rewardsString;
    }

    public void saveUsernameString(final String username){
        this.usernameString = username;
    }

    public String getUsernamesString() {
        return usernamesString;
    }

    public int getHeight() {
        return height;
    }

    public String getRewardsString(){
        return rewardsString;
    }

    public String getUsernameString(){
        return usernameString;
    }
}

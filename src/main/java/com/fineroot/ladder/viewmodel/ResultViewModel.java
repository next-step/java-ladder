package com.fineroot.ladder.viewmodel;

public class ResultViewModel {
    private String usernameString;
    private String ladderString;

    public void saveUsernameString(final String usernameString){
        this.usernameString = usernameString;
    }

    public void saveLadderString(final String ladderString){
       this.ladderString = ladderString;
    }

    public String getUsernameString() {
        return usernameString;
    }

    public String getLadderString() {
        return ladderString;
    }
}

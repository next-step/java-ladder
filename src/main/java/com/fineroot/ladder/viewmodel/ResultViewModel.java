package com.fineroot.ladder.viewmodel;

public class ResultViewModel {

    private String usernamesString;
    private String ladderString;
    private String rewardsString;
    private String resultString;

    public void saveUsernamesString(final String usernamesString){
        this.usernamesString = usernamesString;
    }

    public void saveLadderString(final String ladderString){
       this.ladderString = ladderString;
    }

    public void saveResultString(final String resultString){
        this.resultString = resultString;
    }

    public void saveRewardsString(final String rewardsString){
        this.rewardsString=rewardsString;
    }

    public String getUsernamesString() {
        return usernamesString;
    }

    public String getLadderString() {
        return ladderString;
    }

    public String getResultString(){
        return resultString;
    }

    public String getRewardsString(){
        return rewardsString;
    }
}

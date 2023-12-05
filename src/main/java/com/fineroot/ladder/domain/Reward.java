package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.ExceptionMessage;

public class Reward {

    private final String value;

    public Reward(String value){
        validation(value);
        this.value = value;
    }

    private void validation(String value) {
        if(value.isEmpty() || value.isBlank()){
            throw new IllegalArgumentException(ExceptionMessage.REWARD_EMPTY_OR_BLANK.getMessage());
        }
    }

    @Override
    public String toString() {
        return value;
    }
}

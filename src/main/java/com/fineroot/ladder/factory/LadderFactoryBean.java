package com.fineroot.ladder.factory;

import com.fineroot.ladder.domain.MyLadderCreator;
import com.fineroot.ladder.domain.MyLineCreator;
import com.fineroot.ladder.engine.LadderCreator;
import com.fineroot.ladder.utils.ExceptionMessage;

public class LadderFactoryBean {

    private LadderFactoryBean(){
        throw new IllegalArgumentException(ExceptionMessage.UTILITY_CLASS.getMessage());
    }
    public static LadderCreator createLadderFactory(){
        return new MyLadderCreator(new MyLineCreator());
    }
}

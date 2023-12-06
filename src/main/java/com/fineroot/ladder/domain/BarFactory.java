package com.fineroot.ladder.domain;

import com.fineroot.ladder.utils.ExceptionMessage;
import java.util.ArrayList;
import java.util.List;

public class BarFactory {
    private final List<Bar> barList= new ArrayList<>();
    private boolean isValid = true;

    public BarFactory(boolean initValue){
        barList.add(Bar.of(false, initValue));
    }

    public Bar first(){
        return barList.get(0);
    }

    public Bar next(boolean value){
        if(!isValid){
            throw new IllegalArgumentException(ExceptionMessage.BAR_FACTORY_NEXT_AFTER_LAST.getMessage());
        }
        Bar result = createNextBar(value);
        barList.add(result);
        return result;
    }

    public Bar last(){
        isValid = false;
        return Bar.of(currentBar().currentStep(),false);
    }

    private Bar createNextBar(boolean value){
        if(!currentBar().currentStep()){
            return Bar.of(currentBar().currentStep(), value);
        }
        return Bar.of(currentBar().currentStep(), false);
    }

    private Bar currentBar(){
        return barList.get(barList.size()-1);
    }
}

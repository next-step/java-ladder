package me.namuhuchutong.ladder.domain;

import me.namuhuchutong.ladder.domain.wrapper.Point;

public class ContinuousScaffoldValidator {

    private boolean flag;

    public ContinuousScaffoldValidator() {
        this.flag = false;
    }

    public boolean isContinuous(Point point) {
        if (point.isHyphen() && (flag)) {
            return true;
        }
        this.flag = point.isHyphen();
        return false;
    }
}

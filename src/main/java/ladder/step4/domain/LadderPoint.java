/* Copyright (c) 2020 ZUM Internet, Inc.
 * All right reserved.
 * http://www.zum.com
 * This software is the confidential and proprietary information of ZUM
 * , Inc. You shall not disclose such Confidential Information and
 * shall use it only in accordance with the terms of the license agreement
 * you entered into with ZUM.
 *
 * Revision History
 * Author                    Date                     Description
 * ------------------       --------------            ------------------
 *   junil                2020-06-05
 */
package ladder.step4.domain;

public class LadderPoint {
    private final int point;
    private final Direction direction;

    private LadderPoint (int point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public static LadderPoint of (int point, Direction direction) {
        return new LadderPoint(point, direction);
    }

    public int move () {
        if (direction == Direction.LEFT) {
            return point - 1;
        }
        if (direction == Direction.RIGHT) {
            return point + 1;
        }
        return point;
    }
}
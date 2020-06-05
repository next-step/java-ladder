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

import java.util.Random;

public enum Direction {
    EMPTY(false, false),
    LEFT(true, false),
    RIGHT(false, true);

    private static final Random RANDOM = new Random();

    private final boolean left;
    private final boolean right;

    Direction(boolean left, boolean right) {
        this.left = left;
        this.right = right;
    }

    public static Direction createOptional (Direction direction) {
        return RANDOM.nextBoolean() ? direction : EMPTY;
    }

    public static Direction toggle (Direction direction) {
        return direction == Direction.RIGHT ? Direction.LEFT : Direction.RIGHT;
    }
}
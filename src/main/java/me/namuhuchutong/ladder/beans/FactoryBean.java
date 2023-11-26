package me.namuhuchutong.ladder.beans;

import me.namuhuchutong.ladder.domain.engine.LadderCreator;
import me.namuhuchutong.ladder.domain.engine.LineCreator;
import me.namuhuchutong.ladder.domain.engine.ScaffoldDiscriminator;
import me.namuhuchutong.ladder.domain.implement.LadderGameCreator;
import me.namuhuchutong.ladder.domain.implement.RowCreator;
import me.namuhuchutong.ladder.domain.implement.discriminator.ScaffoldRandomDiscriminator;

public class FactoryBean {

    public static ScaffoldDiscriminator scaffoldDiscriminator() {
        return new ScaffoldRandomDiscriminator();
    }

    public static LineCreator lineCreator() {
        return new RowCreator(scaffoldDiscriminator());
    }

    public static LadderCreator ladderCreator() {
        return new LadderGameCreator(lineCreator());
    }
}

package me.namuhuchutong.ladder.beans;

import me.namuhuchutong.ladder.domain.engine.LadderCreator;
import me.namuhuchutong.ladder.domain.engine.LineCreator;
import me.namuhuchutong.ladder.domain.engine.ScaffoldGenerator;
import me.namuhuchutong.ladder.domain.implement.LadderGameCreator;
import me.namuhuchutong.ladder.domain.implement.RowCreator;
import me.namuhuchutong.ladder.domain.implement.discriminator.ScaffoldRandomGenerator;

public class FactoryBean {

    private FactoryBean() {}

    public static ScaffoldGenerator scaffoldDiscriminator() {
        return new ScaffoldRandomGenerator();
    }

    public static LineCreator lineCreator() {
        return new RowCreator(scaffoldDiscriminator());
    }

    public static LadderCreator ladderCreator() {
        return new LadderGameCreator(lineCreator());
    }
}

package icu.sunway.naraka.Entity.Card.CardImpl;

import icu.sunway.naraka.Entity.Card.AbstractCard;
import icu.sunway.naraka.Entity.Player.AbstractPlayer;
import lombok.Getter;

public class CardLionRage extends AbstractCard {
    private final static int rageConsumption = 1;
    private final static int rageRecovery = 3;
    private final static String intro = "消耗1点怒气，使你的怒气值+3";
    private final static String displayName = "雄狮";
    @Getter
    private final static CardLionRage instance = new CardLionRage();

    CardLionRage() {
        super(rageConsumption, intro, displayName);
    }

    @Override
    public void execute(AbstractPlayer playerMe, AbstractPlayer playerOppo) {

    }
}

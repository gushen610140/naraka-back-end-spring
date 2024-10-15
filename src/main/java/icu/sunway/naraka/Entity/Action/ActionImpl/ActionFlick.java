package icu.sunway.naraka.Entity.Action.ActionImpl;

import icu.sunway.naraka.Entity.Action.AbstractAction;
import icu.sunway.naraka.Entity.Player.AbstractPlayer;
import lombok.Getter;

public class ActionFlick extends AbstractAction {

    private final static int value = 300;
    private final static String intro = "轻击，如果对方选择重击，则受到500点伤害，对其他动作造成300点伤害。";
    private final static String displayName = "轻击";
    @Getter
    private final static ActionFlick instance = new ActionFlick();

    ActionFlick() {
        super(value, intro, displayName);
    }

    @Override
    public void execute(AbstractPlayer playerMe, AbstractPlayer playerOppo) {

    }
}

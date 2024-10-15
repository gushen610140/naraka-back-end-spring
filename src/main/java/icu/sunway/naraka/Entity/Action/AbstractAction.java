package icu.sunway.naraka.Entity.Action;

import icu.sunway.naraka.Entity.Player.AbstractPlayer;

public abstract class AbstractAction {
    protected int value;
    protected String intro;
    protected String displayName;

    public AbstractAction(int value, String intro, String displayName) {
        this.value = value;
        this.intro = intro;
        this.displayName = displayName;
    }

    public abstract void execute(AbstractPlayer playerMe, AbstractPlayer playerOppo);
}

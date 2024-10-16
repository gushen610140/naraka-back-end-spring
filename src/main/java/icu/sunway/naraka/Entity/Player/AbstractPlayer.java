package icu.sunway.naraka.Entity.Player;

import icu.sunway.naraka.Entity.Action.AbstractAction;
import icu.sunway.naraka.Entity.Card.AbstractCard;
import icu.sunway.naraka.Utils.UUIDUtils;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AbstractPlayer {
    protected String id;
    protected int healthCur;
    protected int healthMax;
    protected String showName;
    protected String nickName;
    protected int rage;
    protected PlayerStatus status;
    protected AbstractAction action;
    protected List<AbstractCard> cardList;

    public AbstractPlayer(int healthMax, String showName) {
        this.healthMax = healthMax;
        this.showName = showName;
    }

    public void initPlayer(String nickName) {
        id = UUIDUtils.generateUUID();
        healthCur = healthMax;
        this.nickName = nickName;
        rage = 0;
        status = PlayerStatus.Waiting;
        action = null;
        cardList = new ArrayList<>();
    }
}

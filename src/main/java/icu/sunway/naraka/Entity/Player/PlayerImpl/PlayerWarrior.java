package icu.sunway.naraka.Entity.Player.PlayerImpl;

import icu.sunway.naraka.Entity.Player.AbstractPlayer;
import lombok.Getter;

public class PlayerWarrior extends AbstractPlayer {
    private static final int maxHealth = 3000;
    private static final String nickName = "Warrior";

    PlayerWarrior() {
        super(maxHealth, nickName);
    }
}

package icu.sunway.naraka.Entity.Card;

import icu.sunway.naraka.Entity.Card.CardImpl.CardLionRage;
import lombok.Getter;

import java.util.Random;

@Getter
public enum CardMap {
    LionRage(CardLionRage.getInstance());

    private final AbstractCard card;

    CardMap(AbstractCard card) {
        this.card = card;
    }

    public static CardMap fromString(String name) {
        try {
            return Enum.valueOf(CardMap.class, name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private static final Random random = new Random();
    public static CardMap getRandomCardMap() {
        CardMap[] cardMaps = CardMap.values();
        return cardMaps[random.nextInt(cardMaps.length)];
    }
}

package icu.sunway.naraka.Service;

import icu.sunway.naraka.Entity.Action.AbstractAction;
import icu.sunway.naraka.Entity.Card.AbstractCard;
import icu.sunway.naraka.Entity.Card.CardMap;
import icu.sunway.naraka.Entity.Player.AbstractPlayer;
import icu.sunway.naraka.Entity.Player.PlayerImpl.PlayerWarrior;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class PlayerService {
    private final RedisTemplate<String, Object> redisTemplate;

    public PlayerService(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void updatePlayerAction(String playerId, AbstractAction action) throws Exception {
        AbstractPlayer player = (AbstractPlayer) redisTemplate.opsForValue().get(playerId);
        if (player == null) {
            throw new Exception("Custom Exception: player not exists");
        }
        player.setAction(action);
        redisTemplate.opsForValue().set(playerId, player);
    }

    public String createPlayer(String nickName) {
        AbstractPlayer player = new PlayerWarrior();
        player.initPlayer(nickName);
        redisTemplate.opsForValue().set(player.getId(), player);
        redisTemplate.expire(player.getId(), Duration.ofHours(1));
        return player.getId();
    }

    public AbstractPlayer getPlayer(String playerId) {
        return (AbstractPlayer) redisTemplate.opsForValue().get(playerId);
    }

    public void updatePlayerCardAddCardRandom(String playerId) throws Exception {
        AbstractPlayer player = (AbstractPlayer) redisTemplate.opsForValue().get(playerId);
        if (player == null) {
            throw new Exception("Custom Exception: player not exists");
        }
        CardMap newCard = CardMap.getRandomCardMap();
        List<AbstractCard> cardList = player.getCardList();
        cardList.add(newCard.getCard());
        player.setCardList(cardList);
        redisTemplate.opsForValue().set(playerId, player);
    }
}

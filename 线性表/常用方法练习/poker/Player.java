package code_2021_0113.poker;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public List<Card> cards = new ArrayList<>();//手牌
    public String name;//玩家姓名

    public Player(String name) {
        this.name = name;
    }
}

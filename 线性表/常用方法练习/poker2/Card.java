package code_2021_0113.poker2;

import java.util.Objects;

public class Card {
    public String suit;//花色
    public int rank;//牌面值

    public Card(String suit,int rank){
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    //打印这张牌
    public String toString() {
        return String.format("[%s %d]",suit,rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && Objects.equals(suit, card.suit);
    }

    //再学一个equals方法，使得只要点数相同即为true
    public boolean equalsRank(Card card){
        return rank == card.rank;
    }
}

package code_2021_0113.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
    //制作扑克牌(初始化）
    private static void initializeCards(List<Card> cards){
        for(String suit: new String[]{"♠","♥","♦","♣"}){
            for(int rank = 1;rank <= 5;rank++){
                Card card = new Card(suit,rank);
                //把扑克牌放入牌组中
                cards.add(card);
            }
        }
    }

    public static void main(String[] args) {
        //5名玩家，用List将其保存起来
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("周润发"));
        playerList.add(new Player("刘德华"));
        playerList.add(new Player("周星驰"));
        playerList.add(new Player("高进"));
        playerList.add(new Player("未知用户"));

        //牌组容器
        List<Card> cardList = new ArrayList<>();

        //初始化扑克牌
        initializeCards(cardList);
        System.out.println("初始化好的牌：");
        System.out.println(cardList);

        //洗牌，可以直接调用Collections.shuffle来洗牌
        Collections.shuffle(cardList);
        System.out.println("洗牌完成，准备发牌：");
        System.out.println(cardList);

        //发牌
        int n = 4;//每名玩家发几张牌
        for(int i = 0; i < n;i++){  //一共发5轮牌
            for(Player plaryer:playerList){ //每名玩家依次抽排
                //从牌组中，抽一张牌出来
                Card card = cardList.remove(0);
                //把这张牌放到玩家的手牌中
                plaryer.cards.add(card);
            }
        }

        System.out.println("发哥变牌之前：");
        for(Player player:playerList){
            System.out.printf("玩家[%s]的手牌是：%s%n",player.name,player.cards);
        }

        //先定义一张需要对比的牌黑桃1
        Card toFoundCard = new Card("♠",1);
        Player faGe = playerList.get(0);
        if(!faGe.cards.contains(toFoundCard)){
            //发哥手里没有黑桃1，需要发功（交换），先把第一张牌拿出来
            //发哥手里的第一张牌
            Card firstCard = faGe.cards.get(0);
            //然后将发哥的第一个牌换成黑桃1
            faGe.cards.set(0,toFoundCard);
            for(int i = 1; i < playerList.size();i++){
                //需要知道哪个玩家手里拿黑桃1了，并且记录下标
                int index1 = -1;
                if((index1 = playerList.get(i).cards.indexOf(toFoundCard)) != -1){
                    //把手持黑桃1的玩家手中的黑桃1换成发哥的第一张牌
                    playerList.get(i).cards.set(index1, firstCard);
                }
            }
        }

        System.out.println("发哥第一次发功：");
        for(Player player:playerList){
            System.out.printf("玩家[%s]的手牌是：%s%n",player.name,player.cards);
        }

        Random random = new Random();
        //开始抽牌，每名玩家依次抽取下家一张随机的手牌
        for(int i = 0; i < playerList.size();i++){
            //当前玩家
            Player currentPlayer = playerList.get(i);
            //下家
            //playerList中的最后一名玩家需要抽第一个玩家的手牌，所以得判断是否为最后一个玩家
            Player nextPlayer = playerList.get(i != playerList.size() - 1 ? i + 1 : 0);

            //要取的牌的下标，随机生成
            int toDrawIndex = random.nextInt(nextPlayer.cards.size());
            //取牌
            Card drawCard = nextPlayer.cards.remove(toDrawIndex);
            //放入当前玩家手中
            currentPlayer.cards.add(drawCard);
        }

        System.out.println("抽牌之后：");
        for(Player player:playerList){
            System.out.printf("玩家[%s]的手牌是：%s%n",player.name,player.cards);
        }

        if(!faGe.cards.contains(toFoundCard)){
            //发哥手里没有黑桃1，需要发功（交换），先把第一张牌拿出来
            //发哥手里的第一张牌
            Card firstCard = faGe.cards.get(0);
            //然后将发哥的第一个牌换成黑桃1
            faGe.cards.set(0,toFoundCard);
            for(int i = 1; i < playerList.size();i++){
                //需要知道哪个玩家手里拿黑桃1了，并且记录下标
                int index1 = -1;
                if((index1 = playerList.get(i).cards.indexOf(toFoundCard)) != -1){
                    //把手持黑桃1的玩家手中的黑桃1换成发哥的第一张牌
                    playerList.get(i).cards.set(index1, firstCard);
                }
            }
        }

        System.out.println("发哥第二次发功：");
        for(Player player:playerList){
            System.out.printf("玩家[%s]的手牌是：%s%n",player.name,player.cards);
        }

        /*for(Player player : playerList){
            for(Card card:player.cards){
                if(toFoundCard.equals(card)){
                    System.out.println(player.name+"获胜");
                    return;
                }
            }
        }*/
        /*for (Player player : playerList) {
            if(player.cards.indexOf(toFoundCard) != -1){
                System.out.println(player.name+"获胜");
            }
        }*/

        for (Player player : playerList) {
            if(player.cards.contains(toFoundCard)){
                System.out.println(player.name+"获胜");
            }
        }

    }
}

package code_2021_0113.poker2;

import java.util.*;

public class Game {
    //玩家初始化
    private static List<Player> initializePlayerList() {
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("周润发"));
        playerList.add(new Player("刘德华"));
        playerList.add(new Player("周星驰"));
        playerList.add(new Player("高进"));
        playerList.add(new Player("未知用户"));
        return playerList;
    }

    //扑克牌初始化，并直接删掉黑桃1
    private static List<Card> initializeCardList() {
        List<Card> cardList = new ArrayList<>();
        for(String suit:new String[]{"♠","♥","♦","♣"}){
            for(int rank = 1; rank <= 5;rank++){
                cardList.add(new Card(suit,rank));
            }
        }

        //删掉黑桃1
        cardList.remove(0);
        return cardList;
    }

    //将打印手牌抽象成方法，方便多次使用
    private static void printHands(List<Player> playerList){
        for (Player player : playerList) {
            System.out.printf("%s 的手牌：%s%n",player.name,player.cards);
        }
    }

    //将发牌抽象成方法，玩家摸牌过程中自动检查是否配对，配对则扔掉
    private static void drawCard(List<Player> playerList, List<Card> cardList) {
        //只要cardList中还有牌就继续抽
        while(true) {
            for (Player player : playerList) {
                //if(cardList.size() == 0){//两种方式都可以
                //注意，这里特意将if判断写在for循环里面，
                // 这样可以达到每个玩家都可以判断是否还有牌
                if(cardList.isEmpty()){
                    return;
                }
                Card card = cardList.remove(0);
                boolean flag = true;
                //练一下迭代器，判断抽上来的牌和手牌是否配对
                Iterator<Card> it = player.cards.iterator();
                while(it.hasNext()){
                    Card everyCard = it.next();
                    if(everyCard.equalsRank(card)){
                        it.remove();
                        flag = false;
                        break;
                    }
                }
                //没有配对成功，则插入
                if(flag){
                    player.cards.add(card);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Player> playerList = initializePlayerList();
        List<Card> cardList = initializeCardList();
        Collections.shuffle(cardList);

        //发牌
        drawCard(playerList,cardList);
        //打印发牌结束之后每个玩家手中的牌
        printHands(playerList);

        //把没有手牌的玩家去掉
        Iterator<Player> iterator = playerList.iterator();
        while(iterator.hasNext()){
            Player next = iterator.next();
            if(next.cards.isEmpty()){
                iterator.remove();
            }
        }

        //开始游戏
        //只剩一名玩家的时候就结束
        Random random = new Random();
        while(playerList.size() != 1){
            for(int i = 0;i < playerList.size();i++){
                //多判断一次是防止出现最后一名玩家自己抽自己的情况。
                if(playerList.size() == 1) break;

                System.out.println("目前在游戏中的玩家有：");
                printHands(playerList);

                //获得当前玩家
                Player current = playerList.get(i);
                int nextIndex = i == playerList.size()-1 ? 0 : i+1;
                //获得下家
                Player next = playerList.get(nextIndex);
                //current随机抽取next的一张手牌
                int randomIndex = random.nextInt(next.cards.size());
                //先把牌抽出来
                Card card = next.cards.remove(randomIndex);

                System.out.println(current.name+"抽了"+next.name+"一张"+card);
                //如果下家的手牌为空了，下家退出
                if(next.cards.isEmpty()){
                    playerList.remove(nextIndex);
                }

                //判断抽出来的牌有没有和手牌中一样的，如果有就去掉。
                boolean flag = true;
                Iterator<Card> it2 = current.cards.iterator();
                while(it2.hasNext()){
                    if(it2.next().equalsRank(card)){
                        it2.remove();
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    current.cards.add(card);
                }
                //如果当前玩家手中没有牌则退出游戏
                if(current.cards.isEmpty()){
                    playerList.remove(i);
                    i = i - 1;
                }
            }
        }
        System.out.println(playerList.get(0).name + "被捉了");
    }
}

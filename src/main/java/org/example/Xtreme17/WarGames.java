package org.example.Xtreme17;

import java.util.*;

/**
 * @author pc
 * @description 战争游戏
 * 在战争游戏的一种变体中，两名玩家发一堆扑克牌。每轮游戏时，双方都要翻开自己最上面的牌，拥有较高牌的一方将较低的牌加入牌堆底部。
 * 然后丢弃较高的牌。如果翻开的牌的价值相同，则双方都将自己的牌放回牌堆底部。
 *
 * 牌用完的玩家输掉游戏。如果没有玩家用完牌，则游戏以平局结束。
 *
 * 您的挑战是根据每位玩家牌堆中的牌来判断哪位玩家会赢得游戏。
 * @create 2023/10/28 17:31
 */
public class WarGames {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Map<Character, Integer> cardValues = new HashMap<>();

        char[] cards = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
        for (int i = 0; i < cards.length; i++) {
            cardValues.put(cards[i], i + 2);
        }

        for (int i = 0; i < n; i++) {
            Queue<Integer> player1Queue = new LinkedList<>();
            String[] player1 = sc.nextLine().split(" ");
            for (String c : player1) {
                player1Queue.add(cardValues.get(c.toCharArray()[0]));
            }
            Queue<Integer> player2Queue = new LinkedList<>();
            String[] player2 = sc.nextLine().split(" ");
            for (String c : player2) {
                player2Queue.add(cardValues.get(c.toCharArray()[0]));
            }
            System.out.println(playWar(player1Queue, player2Queue));
        }
    }


    public static String playWar (Queue <Integer> player1Queue, Queue <Integer> player2Queue){
        int rounds = 1000;

        for (int i = 0; i < rounds; i++) {
            if (player1Queue.isEmpty() && !player2Queue.isEmpty()) {
                return "player 2";
            }
            if (player2Queue.isEmpty() && !player1Queue.isEmpty()) {
                return "player 1";
            }

            int firstCard = player1Queue.poll();
            int secondCard = player2Queue.poll();

            if (firstCard > secondCard) {
                player1Queue.add(secondCard);
            } else if (firstCard < secondCard) {
                player2Queue.add(firstCard);
            } else {
                player1Queue.add(firstCard);
                player2Queue.add(secondCard);
            }
        }

        return "draw";
    }
}

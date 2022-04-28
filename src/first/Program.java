package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Program {


    // Narazie na stałe dać kolejność, póżniej zrobić sortowanie po inicjatywie z rollem
    public static void fighting(Player hero1, Player hero2, Player enemy) {
        int counterIni = 0;
//        if (hero1.initiative() < enemy.initiative()) {
//            counterIni = 1;
//        }
        while ((hero1.isLives() || hero2.isLives()) && enemy.isLives()) {
            switch (counterIni) {
                case 0:
                    hero1.attack(enemy);
                    if (hero2.isLives()) {
                        counterIni = 1;
                        System.out.println("-----zmieniłem counter na 1");
                    } else {
                        counterIni = 2;
                        System.out.println("-----zmieniłem counter na 2");
                    }
                    break;
                case 1:
                    hero2.attack(enemy);
                    counterIni = 2;
                    System.out.println("-----zmieniłem counter na 2");
                    break;
                case 2:
                    enemy.attack(enemy.choiceVictin(hero1, hero2));
                    if (hero1.isLives()) {
                        counterIni = 0;
                        System.out.println("-----zmieniłem counter na 1");
                    } else {
                        counterIni = 1;
                        System.out.println("-----zmieniłem counter na 2");
                    }
                    break;
            }
        }
    }

    public static void fighting1(Player hero1, Player hero2, Player enemy) {
        ArrayList<Player> listOfPlayer = new ArrayList<>();
        listOfPlayer.add(hero1);
        listOfPlayer.add(hero2);
        listOfPlayer.add(enemy);
        getFasterPlayer(listOfPlayer);

        while ((hero1.isLives() || hero2.isLives()) && enemy.isLives()) {
            for (int i = 0; i < listOfPlayer.size(); i++)
                if (listOfPlayer.get(i).isLives()) {
                    if (listOfPlayer.get(i).equals(enemy)) {
                        listOfPlayer.get(i).attack(enemy.choiceVictin(hero1, hero2));
                    } else {
                        listOfPlayer.get(i).attack(enemy);
                    }
                }
        }
    }

    public static ArrayList<Player> getFasterPlayer(ArrayList<Player> listOfPlayer) { //to wywołuje rzuty dwa razy
//        for (Player p : listOfPlayer) {
//            System.out.println(p.getName());
//        }
//        ArrayList<Player> playerAfterSortByInitiative = listOfPlayer;

//        playerAfterSortByInitiative.sort(Comparator.comparing(Player::initiative));
        listOfPlayer.sort(Comparator.comparing(Player::initiative));
//        for (Player p : playerAfterSortByInitiative) {
//            System.out.println(p.getName());
//        }
        System.out.println();
        return listOfPlayer;
    }

    public static ArrayList<Player> getFasterPlayer2(ArrayList<Player> listOfPlayer) {//to jest nie działa
        for (Player p : listOfPlayer) {
            System.out.println(p.getName());
        }
        ArrayList<Player> playerAfterSortByInitiative = listOfPlayer;
        playerAfterSortByInitiative.sort(Player::compareTo);
        for (Player p : playerAfterSortByInitiative) {
            System.out.println(p.getName());
        }
        return playerAfterSortByInitiative;
    }
}

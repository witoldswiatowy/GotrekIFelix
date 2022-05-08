package first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Program {
    Random rnd = new Random();

    int initiative;

    // Narazie na stałe dać kolejność, póżniej zrobić sortowanie po inicjatywie z rollem
    public static void fightingOldDoNotUse(Player hero1, Player hero2, Player enemy) {
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
                    enemy.attack(enemy.choiceVictim(hero1, hero2));
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

    public static void fighting(Player hero1, Player hero2, Player enemy) {
        ArrayList<Player> listOfPlayer = new ArrayList<>();
        listOfPlayer.add(hero1);
        listOfPlayer.add(hero2);
        listOfPlayer.add(enemy);
        getFasterPlayer(listOfPlayer);

        while ((hero1.isLives() || hero2.isLives()) && enemy.isLives()) {
            for (int i = 0; i < listOfPlayer.size(); i++) {
                if (listOfPlayer.get(i).isLives()) {
                    if (listOfPlayer.get(i).equals(enemy)) {
                        listOfPlayer.get(i).attack(enemy.choiceVictim(hero1, hero2));
                    } else {
                        listOfPlayer.get(i).attack(enemy);
                    }
                }
            }
        }
    }

    public static void figthingHeroVSEnemy(ArrayList<Player> listOfHero, ArrayList<Player> listOfEnemy) {
        ArrayList<Player> listOfFighter = new ArrayList<>();
        listOfFighter.addAll(listOfHero);
        listOfFighter.addAll(listOfEnemy);
        for (Player p : listOfFighter) {
            p.initiative(); //na początku walki ustalamy rzuty na inicjatywe
        }
        Program.getFasterPlayer(listOfFighter);
        while (listOfHero.size() != 0 || listOfEnemy.size() != 0) {
            for (int i = 0; i < listOfFighter.size(); i++) { //może się zdarzyć, że zostanie usunięty element przed wartością i, co sprawii że zostanie przeskoczona jedna postać
                if (listOfFighter.get(i).isGood()) {
                    if (listOfEnemy.size() != 0) {
                        Player victim = listOfFighter.get(i).choiceVictim(listOfEnemy);
                        listOfFighter.get(i).attack(victim); //tu przesłonić metode choiceVictin w obu klasach lub przeciążyć w Playerze na Arrayliste
                        if (!victim.isLives()) {
                            System.out.println("-----------------Robie remove postaci: " + victim.getName() + " z listy listOfFigter w rundzie " + listOfFighter.get(i).getName());
                            listOfFighter.remove(victim);
                            System.out.println("-----------------Robie remove postaci: " + victim.getName() + " z listy listOfEnemy w rundzie " + listOfFighter.get(i).getName());
                            listOfEnemy.remove(victim);
                        }
                    } else {
                        System.out.println("Bohaterowie wygrali!!!");
                    }
                }
                if (listOfHero.size() != 0) {
                    Player victim = listOfFighter.get(i).choiceVictim(listOfHero);
                    listOfFighter.get(i).attack(victim);
                    if (!victim.isLives()) {
                        System.out.println("-----------------Robie remove postaci: " + victim.getNameSpecial() + " z listy listOfFighter w rundzie " + listOfFighter.get(i).getName());
                        listOfFighter.remove(victim); //tu wywala kiedy usuwany jest ostatni obiekt z listy, ale wyrzuca przy wyborze choiceVictim z pustego zbioru
                        System.out.println("-----------------Robie remove postaci: " + victim.getNameSpecial() + " z listy listOfHero w rundzie " + listOfFighter.get(i).getName());
                        listOfHero.remove(victim); //to trzeba sprawdzic czy działa
                    }
                } else {
                    System.out.println("Złole wygrali");
                }
                //todo jakies błedy linijki niżej
                //Jesli ginie drugi bohater to rzuca błąd IllegalArgumentException: bound must be positive i w 165 linijce Playera
                //i może to być związane z kolejnością Troll, Barr, Felix, Gotrek, Goblin. Zgineli pokolei felix, goblin i gotrek (gotrek przez trolla)
                // Zgineli pokolei gotrek, goblin i felix (felix przez trolla)

            }//Lub drugi błąd rzuca martwy drugi bohater, w 87 linicje program, IndexOutOfBoundsException: Index 3 out of bounds for length 3
            //i może to być związane z kolejnością Troll, Barr, Felix, Gotrek, Goblin. Zgineli pokolei felix i gotrek (gotrek przez goblina)
        }
    }


    public static ArrayList<Player> getFasterPlayer(ArrayList<Player> listOfPlayer) { //to wywołuje rzuty dwa razy
//        for (Player p : listOfPlayer) {
//            System.out.println(p.getName());
//        }
//        ArrayList<Player> playerAfterSortByInitiative = listOfPlayer;

//        playerAfterSortByInitiative.sort(Comparator.comparing(Player::initiative));
        listOfPlayer.sort(Comparator.comparing(Player::getIni));
//        for (Player p : playerAfterSortByInitiative) {
//            System.out.println(p.getName());
//        }
        System.out.println();
        System.out.println("Kolejność wg. inicjatywy(1): ");
        for (Player p : listOfPlayer) {
            System.out.println(p.getName());
        }
        System.out.println("koniec 1 ########");
        return listOfPlayer;
    }

    public static ArrayList<Player> getFasterPlayer2(ArrayList<Player> listOfPlayer) {//to jest nie działa
        System.out.println("Kolejność wg. inicjatywy(2): ");
        for (Player p : listOfPlayer) {
            System.out.println(p.getName());
        }
        System.out.println("########## koniec listy kontrolnej ");
        ArrayList<Player> playerAfterSortByInitiative = listOfPlayer;
        Collections.sort(playerAfterSortByInitiative);
        Collections.reverse(playerAfterSortByInitiative);
        System.out.println("Sortowanie się zaczyna:");
        for (Player p : playerAfterSortByInitiative) {
            System.out.println(p.getName());
        }
        System.out.println("koniec 2 ########");
        return playerAfterSortByInitiative;
    }


}

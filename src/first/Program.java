package first;

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
                    if(hero2.isLives()){
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
                    if(hero1.isLives()){
                        counterIni = 0;
                        System.out.println("-----zmieniłem counter na 1");
                    } else {
                        counterIni = 1;
                        System.out.println("-----zmieniłem counter na 2");
                    }
                    break;
            }
        }


        /*if (hero.initiative() > enemy.initiative()) {
            hero.attack(enemy);
            if (enemy.isLives()) {
                enemy.attack(hero);
            }
        }else if (hero.initiative() < enemy.initiative()) {
            enemy.attack(hero);
            if(hero.isLives()) {
                hero.attack(enemy);
            }
        }else if (hero.getIni() < enemy.getIni()) {
            enemy.attack(hero);
            hero.attack(enemy);
        }else {
            hero.attack(enemy);
            enemy.attack(hero);
        }*/
    }

}

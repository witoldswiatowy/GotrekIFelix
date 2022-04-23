package first;

public class Program {

public static void fighting (Player hero, Player enemy) { //lepszą logige pozycjonowania kolejności. Chyba lepsze będą kolecje albo sterty
    int counterIni = 0;
    if (hero.initiative() < enemy.initiative()){
        counterIni = 1;
    }
    while (hero.isLives() && enemy.isLives()){
        switch (counterIni){
            case 0 :
                hero.attack(enemy);
                counterIni = 2;
                break;
            case 1 :
                enemy.attack(hero);
                counterIni = 0;
                break;
            case 2 :
                counterIni = 1;
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

package first;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        Skills [] skillsFelix = {Skills.dodge};
        Hero felix = new Hero(Species.CZLOWIEK, "Felix", 3, 15, 5, 6, 6, true, 1, true);
        Hero gotrek = new Hero(Species.KRASNOLUD, "Gotrek", 5, 25, 7, 4, 4, true, 1, true);
        Hero bardin = new Hero(Species.KRASNOLUD,"Bardin", 6,22,8,4,4, true, 1,true);

        Enemy barr = new Enemy(Species.OGR, "Barr", 6, 20, 8, 2, 2, true, 1, false);
        Enemy troll = new Enemy(Species.TROLL, "Troll", 8, 30, 10, 1, 1, true, 1, false);
        Enemy goblin = new Enemy(Species.GOBLIN, "Goblin", 2, 10, 4, 7, 7, true, 1, false);


        ArrayList<Player> heroArrayList = new ArrayList<>();
        heroArrayList.add(felix);
        heroArrayList.add(gotrek);
        heroArrayList.add(bardin);

        ArrayList<Player> enemyArrayList = new ArrayList<>();
        enemyArrayList.add(barr);
        enemyArrayList.add(troll);
        enemyArrayList.add(goblin);


        Program.figthingHeroVSEnemy(heroArrayList,enemyArrayList);


    }
}

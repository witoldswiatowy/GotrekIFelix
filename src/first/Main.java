package first;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        Skills [] skillsFelix = {Skills.dodge};
        Hero felix = new Hero(Species.CZLOWIEK, "Felix", 3, 15, 5, 4, 4, true, 1, true);
        Hero gotrek = new Hero(Species.KRASNOLUD, "Gotrek", 5, 25, 7, 5, 5, true, 1, true);
        Enemy barr = new Enemy(Species.OGR, "Barr", 6, 25, 17, 2, 2, true, 1, false);
        Enemy troll = new Enemy(Species.TROLL, "Troll", 8, 30, 17, 10, 10, true, 1, false);
        Enemy goblin = new Enemy(Species.GOBLIN, "Goblin", 2, 10, 10, 5, 5, true, 1, false);

//        Player[] players = new Player[10];
//        players[0] = felix.createNewPlayer();
//        players[0].show();

//        felix.show();
//        gotrek.show();
//        barr.show();
//        Program.fighting(gotrek, felix, barr);
//        Program.fighting(gotrek, players[0], barr);

/*        ArrayList <Player> playerArrayList = new ArrayList<>();
        playerArrayList.add(barr);
        playerArrayList.add(felix);
        playerArrayList.add(gotrek);*/
/*        for (Player p : playerArrayList){
            System.out.println(p.getName());
        }
        Program.getFasterPlayer(playerArrayList);
        for (Player p : playerArrayList){
            System.out.println(p.getName());
        }*/
//        Program.fighting(gotrek,felix,barr); //felix zadał cios po śmierci

        ArrayList<Player> heroArrayList = new ArrayList<>();
        heroArrayList.add(felix);
        heroArrayList.add(gotrek);
        for (Player p : heroArrayList) {
            p.initiative(); //na początku walki ustalamy rzuty na inicjatywe
        }
//        Program.getFasterPlayer(heroArrayList);
//        System.out.println("KOLEJNOSC DRUGIM SPOSOBEM -----------------");
        Program.getFasterPlayer2(heroArrayList);

        ArrayList<Player> enemyArrayList = new ArrayList<>();
        enemyArrayList.add(barr);
        enemyArrayList.add(troll);
        enemyArrayList.add(goblin);
        for (Player p : enemyArrayList) {
            p.initiative(); //na początku walki ustalamy rzuty na inicjatywe
        }
//        Program.getFasterPlayer(enemyArrayList);
//        System.out.println("KOLEJNOSC DRUGIM SPOSOBEM -----------------");
        Program.getFasterPlayer2(enemyArrayList);

        for (Player p : heroArrayList){
            System.out.println(p.getName());
        }
        System.out.println();
        for (Player p : enemyArrayList){
            System.out.println(p.getName());
        }
        System.out.println();


//        Program.figthingHeroVSEnemy(heroArrayList,enemyArrayList);



    }
}

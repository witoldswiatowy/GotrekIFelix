package first;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        Skills [] skillsFelix = {Skills.dodge};
        Player felix = new Player(Species.CZLOWIEK, "Felix", 2, 15, 5, 4, true, 1);
        Player gotrek = new Player(Species.KRASNOLUD, "Gotrek", 5, 25, 7, 5, true, 1);
        Player barr = new Player(Species.OGR, "Barr", 6, 30, 7, 2, true, 1);

//        Player[] players = new Player[10];
//        players[0] = felix.createNewPlayer();
//        players[0].show();

//        felix.show();
//        gotrek.show();
//        barr.show();
//        Program.fighting(gotrek, felix, barr);
//        Program.fighting(gotrek, players[0], barr);
        ArrayList <Player> playerArrayList = new ArrayList<>();

        playerArrayList.add(barr);
        playerArrayList.add(felix);
        playerArrayList.add(gotrek);

        Program.fighting1(gotrek,felix,barr); //felix zadał cios po śmierci
/*        for (Player p : playerArrayList){
            System.out.println(p.getName());
        }
        Program.getFasterPlayer(playerArrayList);
        for (Player p : playerArrayList){
            System.out.println(p.getName());
        }*/

    }
}

package first;

public class Main {
    public static void main(String[] args) {

        Player felix = new Player(Species.CZLOWIEK, "Felix", 2, 15, 5, 4, true, 1);
        Player gotrek = new Player(Species.KRASNOLUD, "Gotrek",5,25,7,5,true,1);
        Player barr = new Player(Species.OGR,"Barr",6,30,7,2,true,1);

        Player [] players = new Player[10];
//        players[0] = felix.createNewPlayer();

        felix.show();
        barr.show();
        Program.fighting(gotrek,barr);


    }
}

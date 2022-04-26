package first;

import java.util.Random;
import java.util.Scanner;

public class Player {

    Scanner scanner = new Scanner(System.in);
    Random rnd = new Random();

    Species species;
    private final String name;
    private int def;
    private int hp;
    private int power;
    private int ini;
    private int demage;
    private boolean lives;
    private int exp;

    protected Player(Species species, String name, int def, int hp, int power, int ini, boolean lives, int exp) {
        this.species = species;
        this.name = name;
        this.def = def;
        this.hp = hp;
        this.power = power;
        this.ini = ini;
        this.lives = lives;
        this.exp = exp;
    }

    protected Player createNewPlayer() {
        int [] arrayOfStatistic = setStatistic();
        Player player = new Player(setSpecies(), setName(), arrayOfStatistic[0], arrayOfStatistic[1], arrayOfStatistic[2], arrayOfStatistic[3], lives, 1);
        return player;
    }

    private Species setSpecies() {
        System.out.println("Jakiej rasy jest twoja postać? \n Człowiek, Krasnolud czy Ogr?");
        String choiceSpecies = scanner.nextLine();
        switch (choiceSpecies) {
            case "Człowiek":
                this.species = Species.CZLOWIEK;
                break;
            case "Krasnolud":
                this.species = Species.KRASNOLUD;
                break;
            case "Ogr":
                this.species = Species.OGR;
                break;
            default:
                System.out.println("Chyba umiesz poprawnie napisać nazwę swojej rasy? Spróbuj jeszcze raz.");
        }
        return species;
    }

    private String setName() {
        System.out.println("Jak będzie się nazywać twoja postać?");
        return scanner.nextLine();
    }

    private int[] setStatistic() {
        int[] arrayOfStatistic = new int[4];
        for (int i = 0; i < arrayOfStatistic.length; i++) {
            arrayOfStatistic[i] = rnd.nextInt(10) + 1;
        }
        arrayOfStatistic[1] +=7;
//        if (species.equals(Species.KRASNOLUD){
//            arrayOfStatistic[0] +=
//            arrayOfStatistic[1] +=
//            arrayOfStatistic[2] +=
//            arrayOfStatistic[3] +=
//        }
        return arrayOfStatistic;
    }

    private int makeAttack() {
        int roll = rnd.nextInt(10) + 1;
        if (roll == 10) {
            int furiaUlricha = rnd.nextInt(10 + 1);
            demage = power + roll + furiaUlricha; //trzeba by jeszcze dodać pętle że przy następnych 10, kula się dalej i sumuje się wszystkie rzuty
        } else {
            demage = power + roll;
        }
        return demage;
    }

    protected void attack(Player target) {
        if (target.lives) {
            if (target.def - makeAttack() < 0) {
                target.hp += target.def - this.demage;
                System.out.println(target.name + " został zaatakowany za " + this.demage + " przez " + this.name + "a i ma " + target.hp + " życia.");
            } else {
                System.out.println("Twój atak nie przebił się przez defensywe");
            }
        }
        if (target.hp <= 0) {
            target.lives = false;
            System.out.println();
            System.out.println("śmierć!!!");
            System.out.println(this.name + " zadał ostatni cios zabijając " + target.name + "a!");
            System.out.println();
            exp += (target.exp / 4) + 200;
        }
    }

    protected Player choiceVictin (Player hero1, Player hero2) {
        int rollToDirect = rnd.nextInt(2);
        if (rollToDirect == 0){
            return hero1;
        } else {
            return hero2;
        }
    }

    public void show (){
        System.out.println(name + " jest z rasy: " + species + "\n def: " + def + ", hp: " + hp + ", power: " + power + ", ini: " + ini + ", exp: " + exp);
    }

    public boolean isLives() {
        return lives;
    }

    public int initiative() {
        return ini + rnd.nextInt(10);
    }
    public int getIni() {
        return ini;
    }
}

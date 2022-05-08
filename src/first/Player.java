package first;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player implements Comparable<Player> {

    Scanner scanner = new Scanner(System.in);
    Random rnd = new Random();

    Species species;
    private final String name;
    private int def;
    private int hp;
    private int power;
    private int orginalIni;
    private int ini;
    private int demage;
    private boolean lives;
    private int exp;
    private final boolean isGood;
    Skills[] skills;

    protected Player(Species species, String name, int def, int hp, int power, int orginalIni, int ini, boolean lives, int exp, boolean isGood, Skills[] skills) {
        this.species = species;
        this.name = name;
        this.def = def;
        this.hp = hp;
        this.power = power;
        this.orginalIni = orginalIni;
        this.ini = ini;
        this.lives = lives;
        this.exp = exp;
        this.isGood = isGood;
        this.skills = skills;
    }

    protected Player(Species species, String name, int def, int hp, int power, int orginalIni, int ini, boolean lives, int exp, boolean isGood) {
        this.species = species;
        this.name = name;
        this.def = def;
        this.hp = hp;
        this.power = power;
        this.orginalIni = orginalIni;
        this.ini = ini;
        this.lives = lives;
        this.exp = exp;
        this.isGood = isGood;
    }

    protected Player createNewPlayer() {
        int[] arrayOfStatistic = setStatistic();
        Player player = new Player(setSpecies(), setName(), arrayOfStatistic[0], arrayOfStatistic[1], arrayOfStatistic[2], arrayOfStatistic[3], arrayOfStatistic[3], lives, 1, isGood, skills);
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
        String newName = scanner.nextLine();
        return newName;
    }

    public String getName() {
        return name;
    }

    public String getNameSpecial() {
        return name;
    }

    public boolean isGood() {
        return isGood;
    }

    private int[] setStatistic() {
        int[] arrayOfStatistic = new int[4];
        for (int i = 0; i < arrayOfStatistic.length; i++) {
            arrayOfStatistic[i] = rnd.nextInt(10) + 1;
        }
        if (species.equals(Species.KRASNOLUD)) {
            arrayOfStatistic[0] += 6; //def
            arrayOfStatistic[1] += 14; //hp
            arrayOfStatistic[2] += 5; //power
            arrayOfStatistic[3] += 5;//ini

        } else if (species.equals(Species.CZLOWIEK)) {
            arrayOfStatistic[0] += 4;
            arrayOfStatistic[1] += 16;
            arrayOfStatistic[2] += 5;
            arrayOfStatistic[3] += 5;

        } else if (species.equals(Species.OGR)) {
            arrayOfStatistic[0] += 4;
            arrayOfStatistic[1] += 15;
            arrayOfStatistic[2] += 6;
            arrayOfStatistic[3] += 5;
        }
        return arrayOfStatistic;
    }

    private int makeAttack() {
        int roll = rnd.nextInt(10) + 1;
        if (roll == 10) {
            int furiaUlricha = rnd.nextInt(10 + 1);
            demage = power + roll + furiaUlricha; //todo trzeba by jeszcze dodać pętle że przy następnych 10, kula się dalej i sumuje się wszystkie rzuty
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
            if (target.hp <= 0) {
                target.lives = false;
                System.out.println();
                System.out.println("śmierć!!!");
                System.out.println(this.name + " zadał ostatni cios zabijając " + target.name + "a!");
                System.out.println();
                exp += (target.exp / 4) + 200;
            }
        } else {
            System.out.println("Bohater " + this.name + " chciał zaatakować, ale przeciwnik nie żyje");
        }
    }

    protected Player choiceVictim(Player hero1, Player hero2) {
        if (hero1.isLives() && hero2.isLives()) {
            int rollToDirect = rnd.nextInt(2);
            if (rollToDirect == 0) {
                return hero1;
            } else {
                return hero2;
            }
        } else if (!hero2.isLives()) {
            return hero1;
        } else {
            return hero2;
        }
    }

    protected Player choiceVictim(ArrayList<Player> listOfVictim) {
        int numberOfVictim = rnd.nextInt(listOfVictim.size());
        return listOfVictim.get(numberOfVictim);
    }

    public void show() {
        System.out.println(name + " jest z rasy: " + species + "\n def: " + def + ", hp: " + hp + ", power: " + power + ", ini: " + ini + ", exp: " + exp);
    }

    public boolean isLives() {
        return lives;
    }

    public void initiative() {
        int roll = rnd.nextInt(10);
        int initiativeValue = orginalIni + roll;
        System.out.println(this.name + " rzucił: " + roll + " i ma inicjatywy " + initiativeValue);
        this.ini = initiativeValue;
    }

    public int getIni() {
        return ini;
    }


    @Override
    public int compareTo(Player o) {
        if (this.getIni() < o.getIni()) {
            return -1;
        }
        if (this.getIni() > o.getIni()) {
            return 1;
        }
        return 0;
    }

    public interface Comparable <T> {
        public int compareTo(T o);
    }
}

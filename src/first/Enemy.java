package first;

public class Enemy extends Player{
    boolean isGood;
    protected Enemy(Species species, String name, int def, int hp, int power, int orginalIni, int ini, boolean lives, int exp, boolean isGood, Skills[] skills) {
        super(species, name, def, hp, power, orginalIni, ini, lives, exp, isGood, skills);
    }

    protected Enemy(Species species, String name, int def, int hp, int power, int orginalIni, int ini, boolean lives, int exp, boolean isGood) {
        super(species, name, def, hp, power, orginalIni, ini, lives, exp, isGood);
    }
}

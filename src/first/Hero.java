package first;

public class Hero extends Player{
    protected Hero(Species species, String name, int def, int hp, int power, int orginalIni, int ini, boolean lives, int exp, boolean isGood, Skills[] skills) {
        super(species, name, def, hp, power, orginalIni, ini, lives, exp, isGood, skills);

    }

    protected Hero(Species species, String name, int def, int hp, int power, int orginalIni, int ini, boolean lives, int exp, boolean isGood) {
        super(species, name, def, hp, power,orginalIni, ini, lives, exp, isGood);
    }
}

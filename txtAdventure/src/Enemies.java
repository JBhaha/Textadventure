public class Enemies {

    private String name;
    private double hp = 100;
    private double maxhp = 100;
    private double attackdmg;
    private int experience = 0;
    private int level = 3;

    public Enemies(String name, double hp, double maxhp, double attackdmg, int experience, int level) {
        this.name = name;
        this.hp = hp;
        this.maxhp = maxhp;
        this.attackdmg = attackdmg;
        this.experience = experience;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public double getHp() {
        return hp;
    }

    public double getMaxhp() {
        return maxhp;
    }

    public double getAttackdmg() {
        return attackdmg;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public void setMaxhp(double maxhp) {
        this.maxhp = maxhp;
    }

    public void setAttackdmg(double attackdmg) {
        this.attackdmg = attackdmg;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // this method attacks the adventurer
    public void attackadv(){
        attackdmg = 3;
        Adventurer.hp = hp - attackdmg;
    }


}

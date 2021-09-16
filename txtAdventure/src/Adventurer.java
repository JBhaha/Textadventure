/**
 * Class for adventurer (maybe selectable)
 **/
public class Adventurer {

    // Declaring Attributes for the Adventurer...
    private String name;
    private double health = 40;
    private double attackdmg;
    private int experience = 0;
    private int level = 1;
    private Backpack backpack;



    //Constructor

    public Adventurer(String name, double health, double attackdmg) {
        this.name = name;
        this.health = health;
        this.attackdmg = attackdmg;
        this.experience = experience;
        this.level = level;
    }


    //Getters and Setters


    public String getName() {
        return name;
    }

    public double getHealth() {
        return health;
    }

    public double getAttackdmg() {
        return attackdmg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setAttackdmg(double attackdmg) {
        this.attackdmg = attackdmg;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public void setBackpack(Backpack backpack) {
        this.backpack = backpack;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    // Methods

    // this Method adds exp
    public void addexp(){
        if (experience == 100){
            level++;
            experience = 0;
        }
    }
    // this Method removes exp
    public void removeexp(){
        if (experience == 100){
            level--;
            experience = 0;
        }
    }

    // this Method adds life points
    public void addhealth(){
        health = health + 15;
        }

    }


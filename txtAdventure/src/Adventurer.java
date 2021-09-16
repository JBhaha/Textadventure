import java.util.Scanner;
/**
 * Class for adventurer (maybe selectable)
 **/
public class Adventurer {

    // Declaring Attributes for the Adventurer
    String name;
    double life;
    double attackdmg;


    //Constructor

    public Adventurer(String name, double life, double attackdmg) {
        this.name = name;
        this.life = life;
        this.attackdmg = attackdmg;
    }

    //Getters and Setters


    public String getName() {
        return name;
    }

    public double getLife() {
        return life;
    }

    public double getAttackdmg() {
        return attackdmg;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLife(double life) {
        this.life = life;
    }

    public void setAttackdmg(double attackdmg) {
        this.attackdmg = attackdmg;
    }




}
package be.evoliris.formation.rpgandroid.models;

public abstract class Personnage {
    private String name;
    private int hp;
    private int strenght;
    private int endurance;

    public Personnage(String name, double hp, double strenght, double endurance) {
        this.hp = (int)hp;
        this.strenght = (int)strenght;
        this.endurance = (int)endurance;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public int attack(Personnage target){
        int dommage = this.endurance * this.strenght / 2;
        target.hp -= dommage;
        return dommage;
    }
}

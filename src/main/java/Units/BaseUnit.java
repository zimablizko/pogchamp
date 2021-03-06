package Units;

import java.util.Random;

/**
 * Created by Evgeniy.Nikolaev on 18.06.2018.
 */
public class BaseUnit {
    private String name;
    private int hp;
    private int damage;
    private boolean isAlive;

    public BaseUnit(String name) {
        Random random = new Random();
        this.name = name+" "+String.valueOf(random.nextInt(999));
        this.hp = 100;
        this.damage = 5;
        this.isAlive = true;

    }

    public BaseUnit(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.isAlive = true;
    }

    public void Attack(BaseUnit target){
        Random random = new Random();
        int dmg = this.getDamage() + random.nextInt(4);
        Random critRandom = new Random();
        if(critRandom.nextInt(100)<15){
            System.out.println(this.getName()+" ON RAGE!");
            dmg*=2;
        }
        System.out.println(this.getName()+" hit "+target.getName()+" for "+String.valueOf(dmg));
        target.setHp(target.getHp()-dmg);
    }

    public void checkDying(){
        if (this.getHp()<=0){
            this.isAlive = false;
            System.out.println(this.getName()+" is dead.");
        }
    }
    public String getName() {
        return name+"("+this.getHpString()+")";
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public String getHpString() {
        return String.valueOf(hp);
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public String getDamageString() {
        return String.valueOf(damage);
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

}

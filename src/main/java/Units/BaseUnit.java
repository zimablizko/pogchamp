package Units;

import Utils.Randomizer;
import lombok.Data;

import java.util.Random;

/**
 * Created by Evgeniy.Nikolaev on 18.06.2018.
 */

@Data
public class BaseUnit {
    private String name;
    private int hp;
    private int accuracy;
    private int damage;
    private int damageRange;
    private int critChance;
    private int critModifier;
    private int blockChance;
    private boolean isAlive;

    public BaseUnit(String name) {
        Random random = new Random();
        this.name = name+" "+String.valueOf(random.nextInt(999));
        this.hp = 100;
        this.accuracy = 95;
        this.damage = 5;
        this.damageRange = 4;
        this.critChance = 10;
        this.critModifier = 2;
        this.blockChance = 10;
        this.isAlive = true;
    }

    public BaseUnit(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.isAlive = true;

    }

    public void Attack(BaseUnit target){
        if(Randomizer.CheckSuccess(getAccuracy())) {
            int dmg = calculateDamage();
            System.out.println(getName() + " hit " + target.getName() + " for " + String.valueOf(dmg));
            target.takeDamage(dmg);
        }else{
            System.out.println(getName() + " missed.");
        }
    }

    public int calculateDamage(){
        Random dmgRandom = new Random();
        int dmg = getDamage() + dmgRandom.nextInt(getDamageRange());
        if (Randomizer.CheckSuccess(getCritChance())) {
            System.out.println(getName() + " ON RAGE!");
            dmg *= this.critModifier;
        }
        return dmg;
    }

    public void takeDamage(int dmg){
        if(Randomizer.CheckSuccess(getBlockChance())){
            System.out.println(getName()+" blocked damage!");
        }else {
            this.setHp(getHp() - dmg);
        }
    }

    public void checkDying(){
        if (this.getHp()<=0){
            this.isAlive = false;
            System.out.println(getName()+" is dead.");
        }
    }
}

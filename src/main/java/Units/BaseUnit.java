package Units;

import Utils.Randomizer;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Evgeniy.Nikolaev on 18.06.2018.
 */

public class BaseUnit {
    private String name;
    private int teamId;
    private int hp;
    private int accuracy;
    private int damage;
    private int damageRange;
    private int attackRange;
    private int position;
    private int critChance;
    private int critModifier;
    private int blockChance;
    private int initiative;
    private boolean isAlive;
    List<String> attackPhrases = new ArrayList();

    public BaseUnit(String name, int teamId) {
        this.setTeamId(teamId);
        this.setHp(Randomizer.GetRandomInt(50,70));
        this.setAccuracy(Randomizer.GetRandomInt(90,100));
        this.setDamage(Randomizer.GetRandomInt(3,7));
        this.setDamageRange(4);
        this.setPosition(1);
        this.setAttackRange(1);
        this.setCritChance(Randomizer.GetRandomInt(5,15));
        this.setCritModifier(2);
        this.setBlockChance(Randomizer.GetRandomInt(5,15));
        this.setInitiative(Randomizer.GetRandomInt(0,100));
        this.setAlive(true);
        this.setName(name+" Vasyan ");
    }

    public BaseUnit() {
    }

    public void Attack(BaseUnit target){
        if(Randomizer.CheckSuccess(getAccuracy())) {
            int dmg = calculateDamage();
            System.out.println(getName() + " hit " + target.getName() + " for " + dmg);
            showRandomPhrase(attackPhrases);
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

    public void showRandomPhrase(List<String> list){
        if(!list.isEmpty() && Randomizer.CheckSuccess(10)){
            System.out.println(this.getName() +" says \""+list.get(new Random().nextInt(list.size()))+"\"");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamageRange() {
        return damageRange;
    }

    public void setDamageRange(int damageRange) {
        this.damageRange = damageRange;
    }

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public int getCritModifier() {
        return critModifier;
    }

    public void setCritModifier(int critModifier) {
        this.critModifier = critModifier;
    }

    public int getBlockChance() {
        return blockChance;
    }

    public void setBlockChance(int blockChance) {
        this.blockChance = blockChance;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

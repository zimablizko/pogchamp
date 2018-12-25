package Units;

import Utils.Randomizer;

import java.util.Random;

public class BaseFootman extends BaseUnit {
    public BaseFootman(String name, int teamId) {
        this.setTeamId(teamId);
        this.setHp(Randomizer.GetRandomInt(70,85));
        this.setAccuracy(Randomizer.GetRandomInt(80,95));
        this.setDamage(Randomizer.GetRandomInt(5,8));
        this.setDamageRange(5);
        this.setPosition(1);
        this.setAttackRange(1);
        this.setCritChance(Randomizer.GetRandomInt(10,15));
        this.setCritModifier(2);
        this.setBlockChance(Randomizer.GetRandomInt(10,20));
        this.setInitiative(Randomizer.GetRandomInt(0,100));
        this.setAlive(true);
        this.setName(name+" Footman ");
        attackPhrases.add("For Alliance!");
        attackPhrases.add("Taste my sword!");
    }

}

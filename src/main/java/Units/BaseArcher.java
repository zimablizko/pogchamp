package Units;

import Utils.Randomizer;

public class BaseArcher extends BaseUnit {
    public BaseArcher(String name, int teamId) {
        this.setTeamId(teamId);
        this.setHp(Randomizer.GetRandomInt(40,60));
        this.setAccuracy(Randomizer.GetRandomInt(75,100));
        this.setDamage(Randomizer.GetRandomInt(8,10));
        this.setDamageRange(6);
        this.setPosition(2);
        this.setAttackRange(2);
        this.setCritChance(Randomizer.GetRandomInt(10,20));
        this.setCritModifier(2);
        this.setBlockChance(Randomizer.GetRandomInt(0,5));
        this.setInitiative(Randomizer.GetRandomInt(0,100));
        this.setAlive(true);
        this.setName(name+" Archer ");
        attackPhrases.add("One shot - one kill!");
        attackPhrases.add("Right in the eye!");
    }

}

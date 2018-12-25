/**
 * Created by Evgeniy.Nikolaev on 18.06.2018.
 */

import Units.BaseArcher;
import Units.BaseFootman;
import Units.BaseGroup;
import Units.BaseUnit;

import java.util.*;
import java.util.stream.Collectors;

public class MainCycle {

     public static void StartCycle(){

        BaseGroup groupObj = new BaseGroup();
        List<BaseUnit> group = groupObj.group;
        for (int i = 1; i<=12; i++){
            BaseUnit unit = new BaseUnit("Red",1);
            group.add(unit);
        }
        for (int i = 1; i<=5; i++) {
            BaseUnit unit = new BaseFootman("Blue", 2);
            group.add(unit);
        }
         for (int i = 1; i<=5; i++) {
             BaseUnit unit = new BaseArcher("Blue", 2);
             group.add(unit);
         }

         StartBattle(groupObj,group);
         int teamWinner = group.get(0).getTeamId();
         System.out.println("BATTLE ENDED! WINNER - TEAM "+teamWinner);
    }

    public static void StartBattle(BaseGroup groupObj, List<BaseUnit> group){
        group = group.stream().sorted((o1,o2)->Integer.compare(o2.getInitiative(),(o1.getInitiative()))).
                collect(Collectors.toList());
        System.out.println("BATTLE BEGINS!");
        while (group.stream().anyMatch(o -> o.getTeamId()==1) && group.stream().anyMatch(o -> o.getTeamId()==2)) {
            group = group.stream().filter(o -> o.isAlive()).collect(Collectors.toList());
            for (BaseUnit currUnit:group) {
                if(currUnit.isAlive()) {
                    Random targetNum = new Random();
                    List<BaseUnit> targetList = group.stream().filter(o -> o.getTeamId() != currUnit.getTeamId() && o.isAlive() && (o.getPosition()<=currUnit.getAttackRange() || o.getPosition()==groupObj.getClosestUnitPosition(o.getTeamId()))).collect(Collectors.toList());
                    if (targetList.size()>0) {
                        BaseUnit target = targetList.get(targetNum.nextInt(targetList.size()));
                        currUnit.Attack(target);
                        target.checkDying();
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("error");
            }
        }

    }

    public static void main(String[] args) {
        StartCycle();
    }
}

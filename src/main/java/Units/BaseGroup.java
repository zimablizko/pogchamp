package Units;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Evgeniy.Nikolaev on 18.06.2018.
 */
public class BaseGroup {


    public List<BaseUnit> group = new ArrayList<BaseUnit>();
    
    public BaseGroup(){
    }
    /*
    public void AttackGroup(BaseGroup targetGroup){
        for (BaseUnit unit:this.group) {
            if (!targetGroup.getGroup().isEmpty()) {
                Random targetNum = new Random();
                BaseUnit target = targetGroup.getGroup().get(targetNum.nextInt(targetGroup.group.size()));
                unit.Attack(target);
                target.checkDying();
                if (!target.isAlive()) {
                    targetGroup.group.remove(target);
                }
            }else{
                return;
            }
        }
    }*/


    public List<BaseUnit> getGroup() {
        return group;
    }

    public void setGroup(List<BaseUnit> group) {
        this.group = group;
    }

    public int getClosestUnitPosition(int teamId){
        List<BaseUnit> teamList = group.stream().filter(o -> o.getTeamId() == teamId && o.isAlive()).collect(Collectors.toList());
        teamList = teamList.stream().sorted((o1,o2)->Integer.compare(o1.getPosition(),(o2.getPosition()))).
                collect(Collectors.toList());
        return teamList.get(0).getPosition();
    }
}

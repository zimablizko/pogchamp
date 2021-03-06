package Units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Evgeniy.Nikolaev on 18.06.2018.
 */
public class BaseGroup {


    protected List<BaseUnit> group = new ArrayList<BaseUnit>();
    
    public BaseGroup(int size, String name){
        for (int i = 1; i<=size; i++){
            BaseUnit unit = new BaseUnit(name);
            group.add(unit);
        }
    }
    
    public void AttackGroup(BaseGroup targetGroup){
        for (BaseUnit unit:this.group) {
            if (!targetGroup.getGroup().isEmpty()) {
                Random targetNum = new Random();
                BaseUnit target = targetGroup.getGroup().get(targetNum.nextInt(targetGroup.group.size()));
                unit.Attack(target);
                target.checkDying();
                if (target.getAlive() == false) {
                    targetGroup.group.remove(target);
                }
            }else{
                return;
            }
        }
    }

    public List<BaseUnit> getGroup() {
        return group;
    }

    public void setGroup(List<BaseUnit> group) {
        this.group = group;
    }

}

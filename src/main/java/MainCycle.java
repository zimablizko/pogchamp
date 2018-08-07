/**
 * Created by Evgeniy.Nikolaev on 18.06.2018.
 */

import Units.BaseGroup;

public class MainCycle {

    public static void StartCycle(){
       /* BaseUnit unit = new BaseUnit("Vasyan", 100,5);
        BaseUnit target = new BaseUnit("Vasyan 2", 100,5);*/
        BaseGroup group1 = new BaseGroup(5,"Vasyan");
        BaseGroup group2 = new BaseGroup(5, "Slavyan");
        while (!group1.getGroup().isEmpty() && !group2.getGroup().isEmpty()){
            System.out.println("GROUP 1 ATTACK "+group1.getGroup().size());
            group1.AttackGroup(group2);
            System.out.println("GROUP 2 ATTACK "+group2.getGroup().size());
            group2.AttackGroup(group1);

            /*unit.Attack(target);
            target.Attack(unit);
            System.out.println(unit.getName()+"("+ (unit.getHpString())+"/"+unit.getDamageString()+")");
            System.out.println(target.getName()+"("+ (target.getHpString())+"/"+target.getDamageString()+")");*/
            try {
                Thread.sleep(1000);
            } catch(InterruptedException ex) {System.out.println("error");}
        }
    }



    public static void main(String[] args) {
        StartCycle();
    }
}

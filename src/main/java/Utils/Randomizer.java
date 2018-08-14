package Utils;

import java.util.Random;

/**
 * Created by Evgeniy.Nikolaev on 14.08.2018.
 */
public class Randomizer {
    public static boolean CheckSuccess (int param){
        Random random = new Random();
        if (random.nextInt(100) < param)
            return true;
        else
            return false;
    }
}

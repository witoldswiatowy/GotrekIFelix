package first;

import java.util.Random;

public class Skills {
    Random rnd = new Random();


     public boolean dodge(int init) {
        return init >= rnd.nextInt(10) + 1;
    }

}

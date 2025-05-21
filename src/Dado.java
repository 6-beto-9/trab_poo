package src;
import java.util.Random;

public class Dado {
        private static final Random random = new Random();

        public static int roll(){
            return random.nextInt(6)+1;
        }
}

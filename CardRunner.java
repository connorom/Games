import java.util.Scanner;

public class CardRunner {


    public static void main(String[] args) {
       

        try (Scanner in = new Scanner(System.in)) {
            int stop = 0;
   do {
                Play test = new Play();
                test.drayPlayerCard();
                test.DealerCard();
                test.results();

                System.out.println("Do you want to play again? ");
                System.out.print("Press <-1 to exit> or <2 to shuffle>");
                stop = in.nextInt();


            } while (stop != -1);
        }

    }

}


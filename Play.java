import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Play
{
    private int playPoints;
    private int dPoints;
    private String[] suits = {"hearts", "clubs", "diamonds", "spades"};
    private String[] ranks = {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "Queen", "King"};

    // convert array to list
    private List<String> s;
    private List<String> r;

    //player hand

    private ArrayList<String> playerCards;
    private ArrayList<String> dealerCards;
    private String pSuit;
    private String pRank;
    Scanner in = new Scanner(System.in);


    public Play()
    {

        s = Arrays.asList(suits);
        r = Arrays.asList(ranks);
        playerCards = new ArrayList<String>();
        dealerCards = new ArrayList<String>();      

    }

     public int getHandSum() {
            int handSum = 0;

            handSum = points();

            return handSum;
        }

    public void shuffle()
    {

        pSuit = s.get((int)(Math.random()*s.size()));
        pRank = r.get((int)(Math.random()*r.size()));

       System.out.println(pRank + " of " + pSuit);



    }
    public void DealerCard() {

        dPoints = 0;

        shuffle();
        dealerCards.add(pRank + " of " + pSuit);
        dPoints += points();
        shuffle();
        dealerCards.add(pRank + " of " + pSuit);
        dPoints = dPoints + points();

        System.out.println(" Dealers cards are: " + dealerCards);
        System.out.println(" Dealers points: " + dPoints);

        while(dPoints < 17) {
            shuffle();
            dealerCards.add(pRank + " of " + pSuit);
            dPoints += points();
            //shuffle();
            //dealerCards.add(pRank + " of " + pSuit);

            System.out.println("Dealers cards are: " + dealerCards);
            System.out.println("Dealers points: " + dPoints);

            if(dPoints >= 22) {
                System.out.println("DEALER BUST");


            }

        }


    }

    public void drayPlayerCard() {

        playPoints = 0;
        shuffle();
        playerCards.add(pRank + " of " + pSuit);
        playPoints += points();
        shuffle();
        playerCards.add(pRank + " of " + pSuit);
        playPoints = playPoints + points();

        System.out.println("Your cards are " + playerCards);
        System.out.println("Your points: " + playPoints);
        System.out.println("Do you want some more cards?");
        System.out.println("Press h to hit, c to continue");

        String h = in.next().toLowerCase();

        System.out.println("\n");

        while(h.equals("h") && playPoints < 22) {
            shuffle();
            playerCards.add(pRank + " of " + pSuit);
            playPoints += points();


            System.out.println("Your cards are " + playerCards);
            System.out.println("Your points: " + playPoints);

            if(playPoints < 22) {

                System.out.println("Do you want some more cards?");
                System.out.println("Press h to hit, c to continue");

        //h = in.next().toLowerCase();
                h = in.next();

                System.out.println(" \n ");
            }


        }
        if(playPoints >= 22)
            System.out.println("PLAYER BUST");
        System.out.println("---------------------------------");


    }

    public void results() {

        if(dPoints >= 22 && playPoints >= 22)
                System.out.println("--------------BOTH LOSE---------------");

        else if(dPoints <= 21 && playPoints < dPoints)
                System.out.println("--------------DEALER WINS--------------");

        else if(dPoints > 21 && playPoints <= 21)
                System.out.println("--------------PLAYER WINS---------------");

        else if(dPoints < 21 && playPoints > dPoints && playPoints <= 21)
            System.out.println("-------------------PLAYER WINS---------------");

        else if(playPoints < 21 && dPoints > playPoints && dPoints <= 21)
            System.out.println("------------------DEALER WINS----------------");

        else if(playPoints <= 21 && dPoints < playPoints)
            System.out.println("-------------------PLAYER WINS--------------------");

        else if(playPoints > 21 && dPoints <= 21)
            System.out.println("--------------DEALER WINS---------------");

        else if(playPoints == dPoints)
            System.out.println("--------------DRAW-----------------");

    }




       public int points() {

    int p = 0;

    if(pRank.equals("2"))
        p = 2;

    else if(pRank.equals("3"))
        p = 3;

    else if(pRank.equals("4"))
        p = 4;

    else if(pRank.equals("5"))
        p = 5;

    else if(pRank.equals("6"))
        p = 6;

    else if(pRank.equals("7"))
        p = 7;

    else if(pRank.equals("8"))
        p = 8;

    else if(pRank.equals("9"))
        p = 9;

    else if(pRank.equals("10"))
        p = 10;

    else if(pRank.equals("Queen"))
        p = 10;

    else if(pRank.equals("King"))
        p = 10;

    else if(pRank.equals("jack"))
        p = 10;

    else if(pRank.equals("ace"))
        p = 11;


    return p;
    }


}
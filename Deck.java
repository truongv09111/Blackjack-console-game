

public class Deck {
    //public fields
    public static Cards aceOfSpades = new Cards("Ace of spades", 1, 11); //1
    public static Cards aceOfCloves = new Cards("Ace of cloves", 1, 11); //2
    public static  Cards aceOfDiamonds = new Cards("Ace of diamonds", 1, 11); //3
    public static  Cards aceOfHearts = new Cards("Ace of hearts", 1, 11); //4

    public static  Cards twoOfSpades = new Cards("2 of spades", 2, 0); //5
    public static  Cards twoOfCloves = new Cards("2 of cloves", 2,0); //6
    public static  Cards twoOfDiamonds = new Cards("2 of diamonds", 2, 0); //7
    public static  Cards twoOfHearts = new Cards("2 of hearts", 2, 0); //8

    public static  Cards threeOfSpades = new Cards("3 of spades", 3, 0); //9
    public static  Cards threeOfCloves = new Cards("3 of cloves", 3,0); //10
    public static  Cards threeOfDiamonds = new Cards("3 of diamonds", 3, 0); //11
    public static  Cards threeOfHearts = new Cards("3 of hearts", 3, 0); //12

    public static  Cards fourOfSpades = new Cards("4 of spades", 4, 0); //13
    public static  Cards fourOfCloves = new Cards("4 of cloves", 4,0); //14
    public static  Cards fourOfDiamonds = new Cards("4 of diamonds", 4, 0); //15
    public static  Cards fourOfHearts = new Cards("4 of hearts", 4, 0); //16

    public static  Cards fiveOfSpades = new Cards("5 of spades", 5, 0); //17
    public static  Cards fiveOfCloves = new Cards("5 of cloves", 5,0); //18
    public static  Cards fiveOfDiamonds = new Cards("5 of diamonds", 5, 0); //19
    public static  Cards fiveOfHearts = new Cards("5 of hearts", 5, 0); //20

    public static  Cards sixOfSpades = new Cards("6 of spades", 6, 0); //21
    public static  Cards sixOfCloves = new Cards("6 of cloves", 6,0); //22
    public static  Cards sixOfDiamonds = new Cards("6 of diamonds", 6, 0); //23
    public static  Cards sixOfHearts = new Cards("6 of hearts", 6, 0); //24

    public static  Cards sevenOfSpades = new Cards("7 of spades", 7, 0); //25
    public static  Cards sevenOfCloves = new Cards("7 of cloves", 7,0); //26
    public static  Cards sevenOfDiamonds = new Cards("7 of diamonds", 7, 0); //27
    public static  Cards sevenOfHearts = new Cards("7 of hearts", 7, 0); //28

    public static  Cards eightOfSpades = new Cards("8 of spades", 8, 0); //29
    public static  Cards eightOfCloves = new Cards("8 of cloves", 8,0); //30
    public static  Cards eightOfDiamonds = new Cards("8 of diamonds", 8, 0); //31
    public static  Cards eightOfHearts = new Cards("8 of hearts", 8, 0); //32

    public static  Cards nineOfSpades = new Cards("9 of spades", 9, 0); //33
    public static  Cards nineOfCloves = new Cards("9 of cloves", 9,0); //34
    public static  Cards nineOfDiamonds = new Cards("9 of diamonds", 9, 0); //35
    public static  Cards nineOfHearts = new Cards("9 of hearts", 9, 0); //36

    public static  Cards tenOfSpades = new Cards("10 of spades", 10, 0); //37
    public static  Cards tenOfCloves = new Cards("10 of cloves", 10,0); //38
    public static  Cards tenOfDiamonds = new Cards("10 of diamonds", 10, 0); //39
    public static  Cards tenOfHearts = new Cards("10 of hearts", 10, 0); //40

    public static  Cards jackOfSpades = new Cards("Jack of spades", 10, 0); //41
    public static  Cards jackOfCloves = new Cards("Jack of cloves", 10,0); //42
    public static  Cards jackOfDiamonds = new Cards("Jack of diamonds", 10, 0); //43
    public static  Cards jackOfHearts = new Cards("Jack of hearts", 10, 0); //44

    public static  Cards queenOfSpades = new Cards("Queen of spades", 10, 0); //45
    public static  Cards queenOfCloves = new Cards("Queen of cloves", 10,0); //46
    public static  Cards queenOfDiamonds = new Cards("Queen of diamonds", 10, 0); //47
    public static  Cards queenOfHearts = new Cards("Queen of hearts", 10, 0); //48

    public static  Cards kingOfSpades = new Cards("King of spades", 10, 0); //49
    public static  Cards kingOfCloves = new Cards("King of cloves", 10,0); //50
    public static  Cards kingOfDiamonds = new Cards("King of diamonds", 10, 0); //51
    public static  Cards kingOfHearts = new Cards("King of hearts", 10, 0); //52

    private static int cardsLeft = 52; //deck starts out with 52 cards

    //setter method
    public static void setCardsLeft(int cardsLeft) {
        Deck.cardsLeft -= cardsLeft;
        if (Deck.cardsLeft == 10){
            System.out.println("There are only 10 cards remaining in the deck. Deck will now have 52 cards again.");
            restartDeck();
            Deck.cardsLeft = 52;

        }
    }
    //getter method
    public static int getCardsLeft() {
        return cardsLeft;
    }

    //private static method
    private static void restartDeck(){ //fills up the deck with 52 cards again
        aceOfSpades = new Cards("Ace of spades", 1, 11); //1
        aceOfCloves = new Cards("Ace of cloves", 1, 11); //2
        aceOfDiamonds = new Cards("Ace of diamonds", 1, 11); //3
        aceOfHearts = new Cards("Ace of hearts", 1, 11); //4

        twoOfSpades = new Cards("2 of spades", 2, 0); //5
        twoOfCloves = new Cards("2 of cloves", 2,0); //6
        twoOfDiamonds = new Cards("2 of diamonds", 2, 0); //7
        twoOfHearts = new Cards("2 of hearts", 2, 0); //8

        threeOfSpades = new Cards("3 of spades", 3, 0); //9
        threeOfCloves = new Cards("3 of cloves", 3,0); //10
        threeOfDiamonds = new Cards("3 of diamonds", 3, 0); //11
        threeOfHearts = new Cards("3 of hearts", 3, 0); //12

        fourOfSpades = new Cards("4 of spades", 4, 0); //13
        fourOfCloves = new Cards("4 of cloves", 4,0); //14
        fourOfDiamonds = new Cards("4 of diamonds", 4, 0); //15
        fourOfHearts = new Cards("4 of hearts", 4, 0); //16

        fiveOfSpades = new Cards("5 of spades", 5, 0); //17
        fiveOfCloves = new Cards("5 of cloves", 5,0); //18
        fiveOfDiamonds = new Cards("5 of diamonds", 5, 0); //19
        fiveOfHearts = new Cards("5 of hearts", 5, 0); //20

        sixOfSpades = new Cards("6 of spades", 6, 0); //21
        sixOfCloves = new Cards("6 of cloves", 6,0); //22
        sixOfDiamonds = new Cards("6 of diamonds", 6, 0); //23
        sixOfHearts = new Cards("6 of hearts", 6, 0); //24

        sevenOfSpades = new Cards("7 of spades", 7, 0); //25
        sevenOfCloves = new Cards("7 of cloves", 7,0); //26
        sevenOfDiamonds = new Cards("7 of diamonds", 7, 0); //27
        sevenOfHearts = new Cards("7 of hearts", 7, 0); //28

        eightOfSpades = new Cards("8 of spades", 8, 0); //29
        eightOfCloves = new Cards("8 of cloves", 8,0); //30
        eightOfDiamonds = new Cards("8 of diamonds", 8, 0); //31
        eightOfHearts = new Cards("8 of hearts", 8, 0); //32

        nineOfSpades = new Cards("9 of spades", 9, 0); //33
        nineOfCloves = new Cards("9 of cloves", 9,0); //34
        nineOfDiamonds = new Cards("9 of diamonds", 9, 0); //35
        nineOfHearts = new Cards("9 of hearts", 9, 0); //36

         tenOfSpades = new Cards("10 of spades", 10, 0); //37
         tenOfCloves = new Cards("10 of cloves", 10,0); //38
         tenOfDiamonds = new Cards("10 of diamonds", 10, 0); //39
         tenOfHearts = new Cards("10 of hearts", 10, 0); //40

         jackOfSpades = new Cards("Jack of spades", 10, 0); //41
         jackOfCloves = new Cards("Jack of cloves", 10,0); //42
         jackOfDiamonds = new Cards("Jack of diamonds", 10, 0); //43
         jackOfHearts = new Cards("Jack of hearts", 10, 0); //44

         queenOfSpades = new Cards("Queen of spades", 10, 0); //45
         queenOfCloves = new Cards("Queen of cloves", 10,0); //46
         queenOfDiamonds = new Cards("Queen of diamonds", 10, 0); //47
         queenOfHearts = new Cards("Queen of hearts", 10, 0); //48

         kingOfSpades = new Cards("King of spades", 10, 0); //49
         kingOfCloves = new Cards("King of cloves", 10,0); //50
         kingOfDiamonds = new Cards("King of diamonds", 10, 0); //51
         kingOfHearts = new Cards("King of hearts", 10, 0); //52
    }
}

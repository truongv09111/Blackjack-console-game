import java.util.Scanner;

public class Player {
    //instance fields
    private static int currentBetAmount;
    private int totalCashAmount;
    private Hand hand;
    private boolean playerHit;
    private boolean playerDoubledDown;
    private boolean playerSplit;
    private boolean askedToSplit;
    private static int insuranceBetAmount;
    private int numberOfSplits;
    private boolean cheatCodeActivated;
    private int totalBetAmountForAllHands;
    private int totalCashAmountRequired;




    //constructor method
    public Player(){
        totalCashAmount = 100;
        currentBetAmount = 0;
        hand = new Hand();
        playerHit = false;
        playerDoubledDown = false;
        askedToSplit = false;
        insuranceBetAmount = 0;
        numberOfSplits = 0;
        cheatCodeActivated = false;
        totalBetAmountForAllHands = currentBetAmount;
        totalCashAmountRequired = totalBetAmountForAllHands;




    }

    //getter methods
    public int getTotalCashAmount() {
        return totalCashAmount;
    }

    public static int getCurrentBetAmount() {
        return currentBetAmount ;
    }

    public Hand getHand() {
        return hand;
    }

    public boolean isPlayerHit() {
        return playerHit;
    }
    public boolean isPlayerDoubledDown() {
        return playerDoubledDown;
    }
    public static int getInsuranceBetAmount(){
        return insuranceBetAmount;
    }



    public boolean isPlayerSplit() {
        return playerSplit;
    }

    public int getNumberOfSplits() {
        return numberOfSplits;
    }

    public boolean isPlayerAskedToSplit() {
        return askedToSplit;
    }

    public boolean isCheatCodeActivated() {
        return cheatCodeActivated;
    }

    public int getTotalBetAmountForAllHands() {
        return totalBetAmountForAllHands;
    }

    //setter methods
    public void setTotalCashAmount(int totalCashAmount) {
        this.totalCashAmount = totalCashAmount;
    }
    public static void setCurrentBetAmount(int betAmount){
        currentBetAmount = betAmount;
    }

    public void setPlayerHit(boolean playerHit) {
        this.playerHit = playerHit;
    }

    public void setAskedToSplit(boolean askedToSplit) {
        this.askedToSplit = askedToSplit;
    }

    public void setPlayerDoubledDown(boolean playerDoubledDown) {
        this.playerDoubledDown = playerDoubledDown;
    }
    public static void setInsuranceBetAmount(int insuranceBet){
        insuranceBetAmount = insuranceBet;
    }

    public void setTotalBetAmountForAllHands(int totalBetAmountForAllHands) {
        this.totalBetAmountForAllHands = totalBetAmountForAllHands;
    }

    public void setPlayerSplit(boolean playerSplit) {
        this.playerSplit = playerSplit;
    }

    public void setCheatCodeActivated(boolean cheatCodeActivated) {
        this.cheatCodeActivated = cheatCodeActivated;
    }

    public void setNumberOfSplits(int numberOfSplits) {
        this.numberOfSplits = numberOfSplits;
    }

    public void setTotalCashAmountRequired(int totalCashAmountRequired) {
        this.totalCashAmountRequired = totalCashAmountRequired;
    }

    //instance methods
    public void deal() { //chooses a random number between 1-52 (inclusive) and based on that number, it will set the corresponding card. Deals player's two intial cards using a for loop
        Cards tempCard = new Cards();
        for (int i = 0; i < 2; i++) {
            do {
                int max = 52;
                int min = 1;
                int randomNumber = (int) (Math.random() * max) + min; //chooses a random number between 1-52 (inclusive)

                switch (randomNumber) {
                    case 1:
                        tempCard = Deck.aceOfSpades;
                        if (tempCard.getName().endsWith("s")){
                            hand.addCard(Deck.aceOfSpades); //add card to hand
                            Deck.aceOfSpades = new Cards(); //remove card by making it blank
                            Deck.setCardsLeft(1); //subtract a card from the deck
                        }
                        break;
                    case 2:
                        tempCard = Deck.aceOfCloves;
                        if (tempCard.getName().endsWith("s")){
                            hand.addCard(Deck.aceOfCloves);
                            Deck.aceOfCloves = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 3:
                        tempCard = Deck.aceOfDiamonds;
                        if (tempCard.getName().endsWith("s")){
                            hand.addCard(Deck.aceOfDiamonds);
                            Deck.aceOfDiamonds = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 4:
                        tempCard = Deck.aceOfHearts;
                        if (tempCard.getName().endsWith("s")){
                            hand.addCard(Deck.aceOfHearts);
                            Deck.aceOfHearts = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;

                    case 5:
                        tempCard = Deck.twoOfSpades;
                        if (tempCard.getName().endsWith("s")){
                            hand.addCard(Deck.twoOfSpades);
                            Deck.twoOfSpades = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 6:
                        tempCard = Deck.twoOfCloves;
                        if (tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.twoOfCloves);
                            Deck.twoOfCloves = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 7:
                        tempCard = Deck.twoOfDiamonds;
                        if (tempCard.getName().endsWith("s")){
                            hand.addCard(Deck.twoOfDiamonds);
                            Deck.twoOfDiamonds = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 8:
                        tempCard = Deck.twoOfHearts;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.twoOfHearts);
                            Deck.twoOfHearts = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 9:
                        tempCard = Deck.threeOfSpades;
                        if (tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.threeOfSpades);
                            Deck.threeOfSpades = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 10:
                        tempCard = Deck.threeOfCloves;
                        if (tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.threeOfCloves);
                            Deck.threeOfCloves = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 11:
                        tempCard = Deck.threeOfDiamonds;
                        if (tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.threeOfDiamonds);
                            Deck.threeOfDiamonds = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 12:
                        tempCard = Deck.threeOfHearts;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.threeOfHearts);
                            Deck.threeOfHearts = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 13:
                        tempCard = Deck.fourOfSpades;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.fourOfSpades);
                            Deck.fourOfSpades = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 14:
                        tempCard = Deck.fourOfCloves;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.fourOfCloves);
                            Deck.fourOfCloves = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 15:
                        tempCard = Deck.fourOfDiamonds;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.fourOfDiamonds);
                            Deck.fourOfDiamonds = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 16:
                        tempCard = Deck.fourOfHearts;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.fourOfHearts);
                            Deck.fourOfHearts = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 17:
                        tempCard = Deck.fiveOfSpades;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.fiveOfSpades);
                            Deck.fiveOfSpades = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 18:
                        tempCard = Deck.fiveOfCloves;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.fiveOfCloves);
                            Deck.fiveOfCloves = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 19:
                        tempCard = Deck.fiveOfDiamonds;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.fiveOfDiamonds);
                            Deck.fiveOfDiamonds = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 20:
                        tempCard = Deck.fiveOfHearts;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.fiveOfHearts);
                            Deck.fiveOfHearts = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 21:
                        tempCard = Deck.sixOfSpades;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.sixOfSpades);
                            Deck.sixOfSpades = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 22:
                        tempCard = Deck.sixOfCloves;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.sixOfCloves);
                            Deck.sixOfCloves = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 23:
                        tempCard = Deck.sixOfDiamonds;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.sixOfDiamonds);
                            Deck.sixOfDiamonds = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 24:
                        tempCard = Deck.sixOfHearts;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.sixOfHearts);
                            Deck.sixOfHearts = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 25:
                        tempCard = Deck.sevenOfSpades;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.sevenOfSpades);
                            Deck.sevenOfSpades = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 26:
                        tempCard = Deck.sevenOfCloves;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.sevenOfCloves);
                            Deck.sevenOfCloves = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 27:
                        tempCard = Deck.sevenOfDiamonds;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.sevenOfDiamonds);
                            Deck.sevenOfDiamonds = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 28:
                        tempCard = Deck.sevenOfHearts;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.sevenOfHearts);
                            Deck.sevenOfHearts = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 29:
                        tempCard = Deck.eightOfSpades;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.eightOfSpades);
                            Deck.eightOfSpades = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 30:
                        tempCard = Deck.eightOfCloves;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard((Deck.eightOfCloves));
                            Deck.eightOfCloves = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 31:
                        tempCard = Deck.eightOfDiamonds;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.eightOfDiamonds);
                            Deck.eightOfDiamonds = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 32:
                        tempCard = Deck.eightOfHearts;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.eightOfHearts);
                            Deck.eightOfHearts = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 33:
                        tempCard = Deck.nineOfSpades;
                        if (tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.nineOfSpades);
                            Deck.nineOfSpades = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 34:
                        tempCard = Deck.nineOfCloves;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.nineOfCloves);
                            Deck.nineOfCloves = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 35:
                        tempCard = Deck.nineOfDiamonds;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.nineOfDiamonds);
                            Deck.nineOfDiamonds = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 36:
                        tempCard = Deck.nineOfHearts;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.nineOfHearts);
                            Deck.nineOfHearts = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 37:
                        tempCard = Deck.tenOfSpades;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.tenOfSpades);
                            Deck.tenOfSpades = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 38:
                        tempCard = Deck.tenOfCloves;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.tenOfCloves);
                            Deck.tenOfCloves = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 39:
                        tempCard = Deck.tenOfDiamonds;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.tenOfDiamonds);
                            Deck.tenOfDiamonds = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 40:
                        tempCard = Deck.tenOfHearts;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.tenOfHearts);
                            Deck.tenOfHearts = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 41:
                        tempCard = Deck.jackOfSpades;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.jackOfSpades);
                            Deck.jackOfSpades = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 42:
                        tempCard = Deck.jackOfCloves;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.jackOfCloves);
                            Deck.jackOfCloves = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 43:
                        tempCard = Deck.jackOfDiamonds;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.jackOfDiamonds);
                            Deck.jackOfDiamonds = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 44:
                        tempCard = Deck.jackOfHearts;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.jackOfHearts);
                            Deck.jackOfHearts = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 45:
                        tempCard = Deck.queenOfSpades;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.queenOfSpades);
                            Deck.queenOfSpades = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 46:
                        tempCard = Deck.queenOfCloves;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.queenOfCloves);
                            Deck.queenOfCloves = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 47:
                        tempCard = Deck.queenOfDiamonds;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.queenOfDiamonds);
                            Deck.queenOfDiamonds = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 48:
                        tempCard = Deck.queenOfHearts;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.queenOfHearts);
                            Deck.queenOfHearts = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 49:
                        tempCard = Deck.kingOfSpades;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.kingOfSpades);
                            Deck.kingOfSpades = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 50:
                        tempCard = Deck.kingOfCloves;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.kingOfCloves);
                            Deck.kingOfCloves = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 51:
                        tempCard = Deck.kingOfDiamonds;
                        if (tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.kingOfDiamonds);
                            Deck.kingOfDiamonds = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                    case 52:
                        tempCard = Deck.kingOfHearts;
                        if(tempCard.getName().endsWith("s")) {
                            hand.addCard(Deck.kingOfHearts);
                            Deck.kingOfHearts = new Cards();
                            Deck.setCardsLeft(1);
                        }
                        break;
                }
            } while (tempCard.getName().equals("blank"));



        }
    }

    public void bet() {
        int maxBetAmount = 40;
        int minBetAmount = 10;

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("How much do you want to bet? (enter a number): ");
            boolean hasInt = scanner.hasNextInt();
            if (!hasInt) {
                //check to see if user entered cheat code
                String cheatCode = scanner.nextLine();
                if(cheatCode.equals("ActivateCheat")){
                    cheatScreen();
                    System.out.println("Cheat code activated!");
                } else{
                    System.out.println("You did not enter a number. Please try again.");
                }


            } else{
                int dealerTotalCash = Main.getDealerTotalCash();
                int betAmount = scanner.nextInt();
                scanner.nextLine();
                if(betAmount >= 10 && betAmount <= 40 && totalCashAmount >= betAmount && dealerTotalCash >= betAmount) {
                    currentBetAmount = betAmount;
                    break;
                } else{
                    System.out.println("You entered bet amount: " + "$" + betAmount);
                    System.out.println("Your total cash amount: " + "$" + totalCashAmount);
                    System.out.println("Dealer's total cash amount: " + "$" + dealerTotalCash);
                    System.out.println("The bet amount you entered is not valid. Either you or the dealer doesn't have enough cash or you did not enter the correct bet range. Minimum bet is $10 and Maximum bet is $40. ");

                }
            }
        }

    }
    public void promptSplit(){

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to split? (y/n): ");
            boolean hasInt = scanner.hasNextInt();
            if (hasInt == true) { //if the player entered a number, print message saying it is an invalid input and ask player if he wants to split again
                scanner.nextInt(); //clear number input from scanner
                scanner.nextLine(); //clear enter input from scanner
                System.out.println("You entered a number. Please enter the letter y or n.");
                continue;

            } else { //if player didn't enter a number, then they entered a string. Check to see if the string only has 1 character. If it does then put that single character into a char variable. If it doesn't then output message that tells the player to only enter a letter and not a word.
                String input = scanner.nextLine();
                if (input.length() > 1) { //check the string's length to see how many characters/letters are in the string. If the number of letters are more than 1, print a error message telling the player to enter a letter either y or n
                    System.out.println("You entered a word. Please enter the letter y or n");
                    continue;
                }
                char validLetter = input.charAt(0); //put single character in the string into a char variable.
                if (validLetter == 'y') { //if the inputted letter is equal to y, which means player wants to split
                    numberOfSplits += 1;
                    if(numberOfSplits == 1){
                        totalBetAmountForAllHands = currentBetAmount * 2;
                        totalCashAmountRequired = totalBetAmountForAllHands;

                    } else if(numberOfSplits == 2){
                        totalBetAmountForAllHands = currentBetAmount * 3;
                        totalCashAmountRequired = totalBetAmountForAllHands;

                    } else if(numberOfSplits == 3){
                        totalBetAmountForAllHands = currentBetAmount * 4;
                        totalCashAmountRequired = totalBetAmountForAllHands;

                    }

                    if(totalCashAmount >= totalBetAmountForAllHands && Main.getDealerTotalCash() >= totalBetAmountForAllHands) {
                        playerSplit = true;
                        break;
                    } else {
                        playerSplit = false;
                        System.out.println("Your total cash amount: " + totalCashAmount);
                        System.out.println("Dealer's total cash amount: " + Main.getDealerTotalCash());
                        System.out.println("Cash amount required to split: " + totalBetAmountForAllHands);
                        System.out.println("You cannot split this hand. Either you or the dealer does not have enough cash for splitting.");
                        break;
                    }

                } else if (validLetter == 'n') { //if the inputted letter is equal to n, which means player does not want to split
                    playerSplit = false;
                    break;

                } else { //if the player inputs a letter that is not y or n, print error message
                    System.out.println("You did not enter a valid letter. Please enter either y or n.");

                }


            }


        }

    }
    public void hitOrStay(){

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Do you want to hit or stay? (h/s): ");
            boolean hasInt = scanner.hasNextInt();
            if (hasInt == true){
                System.out.println("You entered a number. Please enter h or s.");

            } else{
                String input = scanner.nextLine();
                if (input.length() > 1){
                    System.out.println("You did not enter a letter. Please enter h or s.");
                } else{
                    char validLetter = input.charAt(0);
                    if (validLetter == 'h'){ //if player wants to hit
                        playerHit = true;
                        break;

                    } else if (validLetter == 's'){ //if player wants to stay
                        playerHit = false;
                        break;

                    } else{
                        System.out.println("You did not enter a valid letter. Please enter h or s.");
                    }
                }
            }
        }
    }
    public void hit(){
        Cards tempCard = new Cards();
        do {
            int max = 52;
            int min = 1;
            int randomNumber = (int) (Math.random() * max) + min; //chooses a random number between 1-52 (inclusive)

            switch (randomNumber) {
                case 1:
                    tempCard = Deck.aceOfSpades;
                    if (tempCard.getName().endsWith("s")){
                        hand.addCard(Deck.aceOfSpades); //add card to hand
                        Deck.aceOfSpades = new Cards(); //remove card by making it blank
                        Deck.setCardsLeft(1); //subtract a card from the deck
                    }
                    break;
                case 2:
                    tempCard = Deck.aceOfCloves;
                    if (tempCard.getName().endsWith("s")){
                        hand.addCard(Deck.aceOfCloves);
                        Deck.aceOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 3:
                    tempCard = Deck.aceOfDiamonds;
                    if (tempCard.getName().endsWith("s")){
                        hand.addCard(Deck.aceOfDiamonds);
                        Deck.aceOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 4:
                    tempCard = Deck.aceOfHearts;
                    if (tempCard.getName().endsWith("s")){
                        hand.addCard(Deck.aceOfHearts);
                        Deck.aceOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;

                case 5:
                    tempCard = Deck.twoOfSpades;
                    if (tempCard.getName().endsWith("s")){
                        hand.addCard(Deck.twoOfSpades);
                        Deck.twoOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 6:
                    tempCard = Deck.twoOfCloves;
                    if (tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.twoOfCloves);
                        Deck.twoOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 7:
                    tempCard = Deck.twoOfDiamonds;
                    if (tempCard.getName().endsWith("s")){
                        hand.addCard(Deck.twoOfDiamonds);
                        Deck.twoOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 8:
                    tempCard = Deck.twoOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.twoOfHearts);
                        Deck.twoOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 9:
                    tempCard = Deck.threeOfSpades;
                    if (tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.threeOfSpades);
                        Deck.threeOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 10:
                    tempCard = Deck.threeOfCloves;
                    if (tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.threeOfCloves);
                        Deck.threeOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 11:
                    tempCard = Deck.threeOfDiamonds;
                    if (tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.threeOfDiamonds);
                        Deck.threeOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 12:
                    tempCard = Deck.threeOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.threeOfHearts);
                        Deck.threeOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 13:
                    tempCard = Deck.fourOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.fourOfSpades);
                        Deck.fourOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 14:
                    tempCard = Deck.fourOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.fourOfCloves);
                        Deck.fourOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 15:
                    tempCard = Deck.fourOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.fourOfDiamonds);
                        Deck.fourOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 16:
                    tempCard = Deck.fourOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.fourOfHearts);
                        Deck.fourOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 17:
                    tempCard = Deck.fiveOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.fiveOfSpades);
                        Deck.fiveOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 18:
                    tempCard = Deck.fiveOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.fiveOfCloves);
                        Deck.fiveOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 19:
                    tempCard = Deck.fiveOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.fiveOfDiamonds);
                        Deck.fiveOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 20:
                    tempCard = Deck.fiveOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.fiveOfHearts);
                        Deck.fiveOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 21:
                    tempCard = Deck.sixOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.sixOfSpades);
                        Deck.sixOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 22:
                    tempCard = Deck.sixOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.sixOfCloves);
                        Deck.sixOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 23:
                    tempCard = Deck.sixOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.sixOfDiamonds);
                        Deck.sixOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 24:
                    tempCard = Deck.sixOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.sixOfHearts);
                        Deck.sixOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 25:
                    tempCard = Deck.sevenOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.sevenOfSpades);
                        Deck.sevenOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 26:
                    tempCard = Deck.sevenOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.sevenOfCloves);
                        Deck.sevenOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 27:
                    tempCard = Deck.sevenOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.sevenOfDiamonds);
                        Deck.sevenOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 28:
                    tempCard = Deck.sevenOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.sevenOfHearts);
                        Deck.sevenOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 29:
                    tempCard = Deck.eightOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.eightOfSpades);
                        Deck.eightOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 30:
                    tempCard = Deck.eightOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard((Deck.eightOfCloves));
                        Deck.eightOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 31:
                    tempCard = Deck.eightOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.eightOfDiamonds);
                        Deck.eightOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 32:
                    tempCard = Deck.eightOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.eightOfHearts);
                        Deck.eightOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 33:
                    tempCard = Deck.nineOfSpades;
                    if (tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.nineOfSpades);
                        Deck.nineOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 34:
                    tempCard = Deck.nineOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.nineOfCloves);
                        Deck.nineOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 35:
                    tempCard = Deck.nineOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.nineOfDiamonds);
                        Deck.nineOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 36:
                    tempCard = Deck.nineOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.nineOfHearts);
                        Deck.nineOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 37:
                    tempCard = Deck.tenOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.tenOfSpades);
                        Deck.tenOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 38:
                    tempCard = Deck.tenOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.tenOfCloves);
                        Deck.tenOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 39:
                    tempCard = Deck.tenOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.tenOfDiamonds);
                        Deck.tenOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 40:
                    tempCard = Deck.tenOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.tenOfHearts);
                        Deck.tenOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 41:
                    tempCard = Deck.jackOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.jackOfSpades);
                        Deck.jackOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 42:
                    tempCard = Deck.jackOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.jackOfCloves);
                        Deck.jackOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 43:
                    tempCard = Deck.jackOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.jackOfDiamonds);
                        Deck.jackOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 44:
                    tempCard = Deck.jackOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.jackOfHearts);
                        Deck.jackOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 45:
                    tempCard = Deck.queenOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.queenOfSpades);
                        Deck.queenOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 46:
                    tempCard = Deck.queenOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.queenOfCloves);
                        Deck.queenOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 47:
                    tempCard = Deck.queenOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.queenOfDiamonds);
                        Deck.queenOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 48:
                    tempCard = Deck.queenOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.queenOfHearts);
                        Deck.queenOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 49:
                    tempCard = Deck.kingOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.kingOfSpades);
                        Deck.kingOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 50:
                    tempCard = Deck.kingOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.kingOfCloves);
                        Deck.kingOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 51:
                    tempCard = Deck.kingOfDiamonds;
                    if (tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.kingOfDiamonds);
                        Deck.kingOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 52:
                    tempCard = Deck.kingOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        hand.addCard(Deck.kingOfHearts);
                        Deck.kingOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
            }

        } while (tempCard.getName().equals("blank"));
    }



    public void promptDoubleDown(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Do you want to double down? (y/n): ");
            boolean hasInt = scanner.hasNextInt();
            if (hasInt) { //user entered a number
                System.out.println("You entered a number. Please enter y or n.");
                scanner.nextInt(); //clear number input from scanner
                scanner.nextLine(); //clear enter input from scanner
            } else{ //user entered a string
                String input = scanner.nextLine();
                if(input.length() > 1){ //user entered a word
                    System.out.println("You entered a word. Please enter y or n.");
                } else { //user entered a letter
                    char validLetter = input.charAt(0);
                    if(validLetter == 'y'){ //user entered y
                        totalCashAmountRequired += currentBetAmount;
                        if(totalCashAmount >= totalCashAmountRequired && Main.getDealerTotalCash() >= totalCashAmountRequired) {
                            playerDoubledDown = true;
                            break;
                        } else{
                            System.out.println("Your total cash amount: " + totalCashAmount);
                            System.out.println("Dealer's total cash amount: " + Main.getDealerTotalCash());
                            System.out.println("Cash amount required for doubling down: " + totalCashAmountRequired);
                            System.out.println("You cannot double down for this hand because either you or the dealer does not have enough cash.");
                            break;
                        }

                    } else if(validLetter == 'n'){ //user entered n
                        playerDoubledDown = false;
                        break;
                    } else{ //user didnt enter y or n
                        System.out.println("You did not enter a valid letter. Please enter y or n.");
                    }
                }
            }
        }
    }
    public void cheatScreen(){

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the Cheat Screen");
            System.out.println("Choose from the following cheats below:");
            System.out.println("1. Choose initial cards");
            System.out.println("2. Change player's total cash amount");
            System.out.println("3. Change dealer's total cash amount");
            System.out.println("4. Make dealer hit until bust");
            System.out.println("5. See through dealer's face down card");
            boolean hasInt = scanner.hasNextInt();
            if (!hasInt) {
                System.out.println("Please enter a choice from 1-7:");
                continue;
            } else{
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch(choice){
                    case 1:
                        cheatCodeActivated = true;
                        Scanner scannerTwo = new Scanner(System.in);
                        while(true) {
                            System.out.println("Type in the rank name of the first card (all lower capitalization): ");
                            boolean hasIntTwo = scannerTwo.hasNextInt();
                            if (hasIntTwo) {
                                System.out.println("You entered a number. Please enter a rank name, for example: ace");
                                scannerTwo.nextInt();
                                scannerTwo.nextLine();
                                continue;

                            } else{
                                String cardSelection = scannerTwo.nextLine();
                                switch(cardSelection){
                                    case "ace":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.aceOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.aceOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.aceOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.aceOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "two":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.twoOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.twoOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.twoOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.twoOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "three":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.threeOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.threeOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.threeOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.threeOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "four":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.fourOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.fourOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.fourOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.fourOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "five":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.fiveOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.fiveOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.fiveOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.fiveOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "six":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.sixOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.sixOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.sixOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.sixOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "seven":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.sevenOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.sevenOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.sevenOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.sevenOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "eight":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.eightOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.eightOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.eightOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.eightOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "nine":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.nineOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.nineOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.nineOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.nineOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "ten":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.tenOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.tenOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.tenOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.tenOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "jack":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.jackOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.jackOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.jackOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.jackOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "queen":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.queenOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.queenOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.queenOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.queenOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "king":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.kingOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.kingOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.kingOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.kingOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                }

                            }
                            break;
                        }
                        //ask user to enter second card
                        while(true) {
                            System.out.println("Type in the rank name of the second card (all lower capitalization): ");
                            boolean hasIntTwo = scannerTwo.hasNextInt();
                            if (hasIntTwo) {
                                System.out.println("You entered a number. Please enter a rank name, for example: ace");
                                scannerTwo.nextInt();
                                scannerTwo.nextLine();
                                continue;

                            } else{
                                String cardSelection = scannerTwo.nextLine();
                                switch(cardSelection){
                                    case "ace":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.aceOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.aceOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.aceOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.aceOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "two":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.twoOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.twoOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.twoOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.twoOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "three":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.threeOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.threeOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.threeOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.threeOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "four":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.fourOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.fourOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.fourOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.fourOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "five":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.fiveOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.fiveOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.fiveOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.fiveOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "six":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.sixOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.sixOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.sixOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.sixOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "seven":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.sevenOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.sevenOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.sevenOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.sevenOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "eight":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.eightOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.eightOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.eightOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.eightOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "nine":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.nineOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.nineOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.nineOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.nineOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "ten":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.tenOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.tenOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.tenOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.tenOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "jack":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.jackOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.jackOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.jackOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.jackOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "queen":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.queenOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.queenOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.queenOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.queenOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                    case "king":
                                        while(true) {
                                            System.out.println("Please choose a suit (enter 1-4): ");
                                            System.out.println("1. Spades");
                                            System.out.println("2. Cloves");
                                            System.out.println("3. Diamonds");
                                            System.out.println("4. Hearts");
                                            hasIntTwo = scannerTwo.hasNextInt();
                                            if (!hasIntTwo) {
                                                System.out.println("Please enter a number 1-4.");
                                                scannerTwo.nextLine();

                                            } else{
                                                boolean defaulted = false;
                                                int suitSelection = scannerTwo.nextInt();
                                                scannerTwo.nextLine();
                                                switch(suitSelection){
                                                    case 1:
                                                        hand.addCard(Deck.kingOfSpades);
                                                        break;
                                                    case 2:
                                                        hand.addCard(Deck.kingOfCloves);
                                                        break;
                                                    case 3:
                                                        hand.addCard(Deck.kingOfDiamonds);
                                                        break;
                                                    case 4:
                                                        hand.addCard(Deck.kingOfHearts);
                                                        break;
                                                    default:
                                                        System.out.println("Please choose a valid number from 1-4");
                                                        defaulted = true;
                                                        break;



                                                }
                                                if(!defaulted) {
                                                    break;
                                                }


                                            }
                                        }
                                        break;
                                }

                            }
                            break;
                        }
                        break;
                    case 2:
                        scannerTwo = new Scanner(System.in);
                        while(true) {
                            System.out.println("Choose an amount for player's total cash amount: ");
                            boolean hasIntTwo = scannerTwo.hasNextInt();
                            if (hasIntTwo) {
                                totalCashAmount = scannerTwo.nextInt();
                                scannerTwo.nextLine();
                                break;
                            } else {
                                System.out.println("You did not enter a number. Please enter a numeric value.");
                            }
                        }
                        break;
                    case 3:
                        Main.changeDealerTotalCash();
                        break;
                    case 4:
                        Main.activateDealerHitUntilBust();
                        break;
                    case 5:
                        Main.activateDealerCardVisible();
                        break;


                }
            }
            break;

        }
    }

    





}

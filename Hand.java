public class Hand {
    //fields
    //the most number of cards a hand can have before busting is 11. Four aces, four twos, and three threes

    private Cards firstCard = new Cards();
    private Cards secondCard = new Cards();
    private Cards thirdCard = new Cards();
    private Cards fourthCard = new Cards();
    private Cards fifthCard = new Cards();
    private Cards sixthCard = new Cards();
    private Cards seventhCard = new Cards();
    private Cards eigthCard = new Cards();
    private Cards ninthCard = new Cards();
    private Cards tenthCard = new Cards();
    private Cards eleventhCard = new Cards();

    private boolean firstCardAdded;
    private boolean secondCardAdded;
    private boolean thirdCardAdded;
    private boolean fourthCardAdded;
    private boolean fifthCardAdded;
    private boolean sixthCardAdded;
    private boolean seventhCardAdded;
    private boolean eigthCardAdded;
    private boolean ninthCardAdded;
    private boolean tenthCardAdded;
    private boolean eleventhCardAdded;

    private int handTotal;
    private int secondHandTotal;
    private boolean hasAce;
    private boolean bust;
    private boolean hasBlackJack;
    private boolean hasDoubleDown;
    private boolean canSplit;
    private boolean didDoubledDown;


    //constructor method
    public Hand(){
        handTotal = 0; //when first created there is no total
        secondHandTotal = 0;


        hasAce = false;
        bust = false;
        hasBlackJack = false;
        hasDoubleDown = false;
        canSplit = false;
        didDoubledDown = false;

        firstCardAdded = false;
        secondCardAdded = false;
        thirdCardAdded = false;
        fourthCardAdded = false;
        fifthCardAdded = false;
        sixthCardAdded = false;
        seventhCardAdded = false;
        eigthCardAdded = false;
        ninthCardAdded = false;
        tenthCardAdded = false;
        eleventhCardAdded = false;

    }
    //getter methods

    public Cards getFirstCard() {
        return firstCard;
    }

    public Cards getSecondCard() {
        return secondCard;
    }

    public Cards getThirdCard() {
        return thirdCard;
    }

    public  Cards getFourthCard() {
        return fourthCard;
    }

    public Cards getFifthCard() {
        return fifthCard;
    }

    public  Cards getSixthCard() {
        return sixthCard;
    }

    public  Cards getSeventhCard() {
        return seventhCard;
    }

    public  Cards getEigthCard() {
        return eigthCard;
    }

    public Cards getNinthCard() {
        return ninthCard;
    }

    public  Cards getTenthCard() {
        return tenthCard;
    }

    public Cards getEleventhCard() {
        return eleventhCard;
    }

    public int getHandTotal() {
        return handTotal;
    }

    public int getSecondHandTotal() {
        return secondHandTotal;
    }

    public boolean getHasAce() {
        return hasAce;
    }

    public boolean isBust() {
        return bust;
    }

    public boolean getHasBlackJack() {
        return hasBlackJack;
    }

    public boolean getHasDoubleDown() {
        return hasDoubleDown;
    }

    public boolean isDoubledDown() {
        return didDoubledDown;
    }

    public boolean isFirstCardAdded() {
        return firstCardAdded;
    }

    public boolean isSecondCardAdded() {
        return secondCardAdded;
    }

    public boolean isThirdCardAdded() {
        return thirdCardAdded;
    }

    public boolean isFourthCardAdded() {
        return fourthCardAdded;
    }

    public boolean isFifthCardAdded() {
        return fifthCardAdded;
    }

    public boolean isSixthCardAdded() {
        return sixthCardAdded;
    }

    public boolean isSeventhCardAdded() {
        return seventhCardAdded;
    }

    public boolean isEigthCardAdded() {
        return eigthCardAdded;
    }

    public boolean isNinthCardAdded() {
        return ninthCardAdded;
    }

    public boolean isTenthCardAdded() {
        return tenthCardAdded;
    }

    public boolean isEleventhCardAdded() {
        return eleventhCardAdded;
    }

    public boolean getCanSplit() {
        return canSplit;
    }
    //setter methods

    public void setHandTotal(int handTotal) {
        this.handTotal = handTotal;
    }

    public void setFirstCard(Cards firstCard) {
        this.firstCard = firstCard;
    }

    public void setSecondCard(Cards secondCard) {
        this.secondCard = secondCard;
    }

    public void setThirdCard(Cards thirdCard) {
        this.thirdCard = thirdCard;
    }

    public void setFourthCard(Cards fourthCard) {
        this.fourthCard = fourthCard;
    }

    public void setFifthCard(Cards fifthCard) {
        this.fifthCard = fifthCard;
    }

    public void setSixthCard(Cards sixthCard) {
        this.sixthCard = sixthCard;
    }

    public void setSeventhCard(Cards seventhCard) {
        this.seventhCard = seventhCard;
    }

    public void setEigthCard(Cards eigthCard) {
        this.eigthCard = eigthCard;
    }

    public void setNinthCard(Cards ninthCard) {
        this.ninthCard = ninthCard;
    }

    public void setTenthCard(Cards tenthCard) {
        this.tenthCard = tenthCard;
    }

    public void setEleventhCard(Cards eleventhCard) {
        this.eleventhCard = eleventhCard;
    }

    public void setDidDoubledDown(boolean didDoubledDown) {
        this.didDoubledDown = didDoubledDown;
    }

    public void setFirstCardAdded(boolean firstCardAdded) {
        this.firstCardAdded = firstCardAdded;
    }

    public void setSecondCardAdded(boolean secondCardAdded) {
        this.secondCardAdded = secondCardAdded;
    }

    //instance methods
    public void addCard(Cards dealtCard){ //add card to player's hand
        //this method goes down each card one by one. If it finds a blank card, it will initialize it with the card that is being passed in
        if (firstCard.getName() == "blank"){
            firstCard = dealtCard;

        } else if(secondCard.getName() == "blank"){
                secondCard = dealtCard;

        } else if(thirdCard.getName() == "blank"){
                thirdCard = dealtCard;

        } else if(fourthCard.getName() == "blank"){
                fourthCard = dealtCard;

        } else if(fifthCard.getName() == "blank"){
                fifthCard = dealtCard;

        } else if (sixthCard.getName() == "blank"){
                sixthCard = dealtCard;

        } else if(seventhCard.getName() == "blank"){
                seventhCard = dealtCard;

        } else if (eigthCard.getName() == "blank"){
                eigthCard = dealtCard;

        } else if (ninthCard.getName() == "blank"){
                ninthCard = dealtCard;

        } else if (tenthCard.getName() == "blank"){
                tenthCard = dealtCard;

        } else if (eleventhCard.getName() == "blank"){
                eleventhCard = dealtCard;

        }


    }
    public void showHand(){ //show the current hand of player
        if (firstCard.getName() != "blank"){
            System.out.println(firstCard.getName());
        } if (secondCard.getName() != "blank"){
            System.out.println(secondCard.getName());
        } if (thirdCard.getName() != "blank"){
            System.out.println(thirdCard.getName());
        } if (fourthCard.getName() != "blank") {
            System.out.println(fourthCard.getName());
        } if (fifthCard.getName() != "blank") {
        System.out.println(fifthCard.getName());
        } if (sixthCard.getName() != "blank") {
            System.out.println(sixthCard.getName());
        } if (seventhCard.getName() != "blank") {
            System.out.println(seventhCard.getName());
        } if (eigthCard.getName() != "blank") {
            System.out.println(eigthCard.getName());
        } if (ninthCard.getName() != "blank") {
            System.out.println(ninthCard.getName());
        } if (tenthCard.getName() != "blank") {
            System.out.println(tenthCard.getName());
        } if (eleventhCard.getName() != "blank") {
            System.out.println(eleventhCard.getName());
        }

    }
    public void getTotal(){ //get the total of player's hand. Ace has two values: 1 or 11. This method will account for any aces in the hand.
        //add the value of each card on hand one by one
        int tempTotal = 0;
        if (firstCard.getName() != "blank" && !firstCardAdded){
            tempTotal += firstCard.getRank();
            firstCardAdded = true;
        } if (secondCard.getName() != "blank" && !secondCardAdded){
            tempTotal += secondCard.getRank();
            secondCardAdded = true;
        } if (thirdCard.getName() != "blank" && !thirdCardAdded){
            tempTotal += thirdCard.getRank();
            thirdCardAdded = true;
        } if (fourthCard.getName() != "blank" && !fourthCardAdded){
            tempTotal += fourthCard.getRank();
            fourthCardAdded = true;
        } if (fifthCard.getName() != "blank" && !fifthCardAdded){
            tempTotal += fifthCard.getRank();
            fifthCardAdded = true;
        } if (sixthCard.getName() != "blank" && !sixthCardAdded){
            tempTotal += sixthCard.getRank();
            sixthCardAdded = true;
        } if (seventhCard.getName() != "blank" && !seventhCardAdded){
            tempTotal += seventhCard.getRank();
            seventhCardAdded = true;
        } if (eigthCard.getName() != "blank" && !eigthCardAdded){
            tempTotal += eigthCard.getRank();
            eigthCardAdded = true;
        } if (ninthCard.getName() != "blank" && !ninthCardAdded){
            tempTotal += ninthCard.getRank();
            ninthCardAdded = true;
        } if (tenthCard.getName() != "blank" && !tenthCardAdded){
            tempTotal += tenthCard.getRank();
            tenthCardAdded = true;
        } if (eleventhCard.getName() != "blank" && !eleventhCardAdded){
            tempTotal += eleventhCard.getRank();
            eleventhCardAdded = true;
        }
        handTotal += tempTotal;

        //now check to see if there are any aces in the hand. if there is then we must have two totals. Doesn't matter how many aces there is, if there is at least one ace, just add 10 to the handTotal
        if (firstCard.getName().charAt(0) == 'A'){
            hasAce = true;
        } else if(secondCard.getName().charAt(0) == 'A'){
            hasAce = true;
        } else if(thirdCard.getName().charAt(0) == 'A'){
            hasAce = true;
        } else if(fourthCard.getName().charAt(0) == 'A'){
            hasAce = true;
        } else if(fifthCard.getName().charAt(0) == 'A'){
            hasAce = true;
        } else if(sixthCard.getName().charAt(0) == 'A'){
            hasAce = true;
        } else if(seventhCard.getName().charAt(0) == 'A'){
            hasAce = true;
        } else if(eigthCard.getName().charAt(0) == 'A'){
            hasAce = true;
        } else if(ninthCard.getName().charAt(0) == 'A'){
            hasAce = true;
        } else if(tenthCard.getName().charAt(0) == 'A'){
            hasAce = true;
        } else if(eleventhCard.getName().charAt(0) == 'A'){
            hasAce = true;
        }

        //if there is at least one ace (or more) in the hand, secondTotal will equal handTotal + 10
        if (hasAce == true){
            secondHandTotal = handTotal + 10;
        }
        //check to see if hand busted
        if (handTotal > 21){
            bust = true;
        }if(secondHandTotal > 21){ //if second hand total is bigger than 21, set hasAce to false even if there is an ace. This way, only one total will be outputted
            hasAce = false;
            secondHandTotal = 0;
        }

        //check to see if player has blackjack or if player can double down
        hasBlackJack = checkBlackJack();
        hasDoubleDown = checkDoubleDown();
        canSplit = checkSplit();


    }
    public void resetHand(){ //reset the cards in the hand to blank and resets hand total and second hand total
          firstCard = new Cards();
          secondCard = new Cards();
          thirdCard = new Cards();
          fourthCard = new Cards();
          fifthCard = new Cards();
          sixthCard = new Cards();
          seventhCard = new Cards();
          eigthCard = new Cards();
          ninthCard = new Cards();
          tenthCard = new Cards();
          eleventhCard = new Cards();
          handTotal = 0;
          secondHandTotal = 0;
          hasAce = false;
          bust = false;
          hasBlackJack = false;
          hasDoubleDown = false;
          canSplit = false;

          //resets the added cards to false
        firstCardAdded = false;
        secondCardAdded = false;
        thirdCardAdded = false;
        fourthCardAdded = false;
        fifthCardAdded = false;
        sixthCardAdded = false;
        seventhCardAdded = false;
        eigthCardAdded = false;
        ninthCardAdded = false;
        tenthCardAdded = false;
        eleventhCardAdded = false;

    }
    private boolean checkBlackJack(){ //check to see if player has black jack by checking if the first two deal cards are Ace and a face card or face card and an ace
        if(firstCard.getSecondRank() == 11 && secondCard.getRank() == 10 || firstCard.getRank() == 10 && secondCard.getSecondRank() == 11){
            return true;
        } else{
            return false;
        }
    }
    private boolean checkDoubleDown(){ //check to see if player's first two cards equal 10 or 11. If it does then allow player to double down.
       if (hasBlackJack){ //if player's initial cards are ace and face card/10, hand cannot double down
           return false;
       } else{ //if player's initial cards are not ace and face card/10
           if (firstCard.getRank() + secondCard.getRank() == 10 || firstCard.getRank() + secondCard.getRank() == 11){
               return true;
           }
            return false;
       }
    }
    private boolean checkSplit() { //check if hand can split
       if (thirdCard.getName().equals("blank")) {
            if (firstCard.getName().charAt(0) == secondCard.getName().charAt(0)) {
                return true;
            }
            return false;
        }
        return false;
    }
    public Hand split(){
        if(canSplit){
            Hand newHand = new Hand();
            newHand.addCard(secondCard);
            setSecondCard(new Cards());
            setHandTotal(0);
            setFirstCardAdded(false);
            setSecondCardAdded(false);
            return newHand;
        }
        return null;
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
                        addCard(Deck.aceOfSpades); //add card to hand
                        Deck.aceOfSpades = new Cards(); //remove card by making it blank
                        Deck.setCardsLeft(1); //subtract a card from the deck
                    }
                    break;
                case 2:
                    tempCard = Deck.aceOfCloves;
                    if (tempCard.getName().endsWith("s")){
                        addCard(Deck.aceOfCloves);
                        Deck.aceOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 3:
                    tempCard = Deck.aceOfDiamonds;
                    if (tempCard.getName().endsWith("s")){
                        addCard(Deck.aceOfDiamonds);
                        Deck.aceOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 4:
                    tempCard = Deck.aceOfHearts;
                    if (tempCard.getName().endsWith("s")){
                        addCard(Deck.aceOfHearts);
                        Deck.aceOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;

                case 5:
                    tempCard = Deck.twoOfSpades;
                    if (tempCard.getName().endsWith("s")){
                        addCard(Deck.twoOfSpades);
                        Deck.twoOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 6:
                    tempCard = Deck.twoOfCloves;
                    if (tempCard.getName().endsWith("s")) {
                        addCard(Deck.twoOfCloves);
                        Deck.twoOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 7:
                    tempCard = Deck.twoOfDiamonds;
                    if (tempCard.getName().endsWith("s")){
                        addCard(Deck.twoOfDiamonds);
                        Deck.twoOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 8:
                    tempCard = Deck.twoOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.twoOfHearts);
                        Deck.twoOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 9:
                    tempCard = Deck.threeOfSpades;
                    if (tempCard.getName().endsWith("s")) {
                        addCard(Deck.threeOfSpades);
                        Deck.threeOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 10:
                    tempCard = Deck.threeOfCloves;
                    if (tempCard.getName().endsWith("s")) {
                        addCard(Deck.threeOfCloves);
                        Deck.threeOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 11:
                    tempCard = Deck.threeOfDiamonds;
                    if (tempCard.getName().endsWith("s")) {
                        addCard(Deck.threeOfDiamonds);
                        Deck.threeOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 12:
                    tempCard = Deck.threeOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.threeOfHearts);
                        Deck.threeOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 13:
                    tempCard = Deck.fourOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.fourOfSpades);
                        Deck.fourOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 14:
                    tempCard = Deck.fourOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.fourOfCloves);
                        Deck.fourOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 15:
                    tempCard = Deck.fourOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.fourOfDiamonds);
                        Deck.fourOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 16:
                    tempCard = Deck.fourOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.fourOfHearts);
                        Deck.fourOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 17:
                    tempCard = Deck.fiveOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.fiveOfSpades);
                        Deck.fiveOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 18:
                    tempCard = Deck.fiveOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.fiveOfCloves);
                        Deck.fiveOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 19:
                    tempCard = Deck.fiveOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.fiveOfDiamonds);
                        Deck.fiveOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 20:
                    tempCard = Deck.fiveOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.fiveOfHearts);
                        Deck.fiveOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 21:
                    tempCard = Deck.sixOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.sixOfSpades);
                        Deck.sixOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 22:
                    tempCard = Deck.sixOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.sixOfCloves);
                        Deck.sixOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 23:
                    tempCard = Deck.sixOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.sixOfDiamonds);
                        Deck.sixOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 24:
                    tempCard = Deck.sixOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.sixOfHearts);
                        Deck.sixOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 25:
                    tempCard = Deck.sevenOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.sevenOfSpades);
                        Deck.sevenOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 26:
                    tempCard = Deck.sevenOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.sevenOfCloves);
                        Deck.sevenOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 27:
                    tempCard = Deck.sevenOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.sevenOfDiamonds);
                        Deck.sevenOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 28:
                    tempCard = Deck.sevenOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.sevenOfHearts);
                        Deck.sevenOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 29:
                    tempCard = Deck.eightOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.eightOfSpades);
                        Deck.eightOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 30:
                    tempCard = Deck.eightOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        addCard((Deck.eightOfCloves));
                        Deck.eightOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 31:
                    tempCard = Deck.eightOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.eightOfDiamonds);
                        Deck.eightOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 32:
                    tempCard = Deck.eightOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.eightOfHearts);
                        Deck.eightOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 33:
                    tempCard = Deck.nineOfSpades;
                    if (tempCard.getName().endsWith("s")) {
                        addCard(Deck.nineOfSpades);
                        Deck.nineOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 34:
                    tempCard = Deck.nineOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.nineOfCloves);
                        Deck.nineOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 35:
                    tempCard = Deck.nineOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.nineOfDiamonds);
                        Deck.nineOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 36:
                    tempCard = Deck.nineOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.nineOfHearts);
                        Deck.nineOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 37:
                    tempCard = Deck.tenOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.tenOfSpades);
                        Deck.tenOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 38:
                    tempCard = Deck.tenOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.tenOfCloves);
                        Deck.tenOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 39:
                    tempCard = Deck.tenOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.tenOfDiamonds);
                        Deck.tenOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 40:
                    tempCard = Deck.tenOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.tenOfHearts);
                        Deck.tenOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 41:
                    tempCard = Deck.jackOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.jackOfSpades);
                        Deck.jackOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 42:
                    tempCard = Deck.jackOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.jackOfCloves);
                        Deck.jackOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 43:
                    tempCard = Deck.jackOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.jackOfDiamonds);
                        Deck.jackOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 44:
                    tempCard = Deck.jackOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.jackOfHearts);
                        Deck.jackOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 45:
                    tempCard = Deck.queenOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.queenOfSpades);
                        Deck.queenOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 46:
                    tempCard = Deck.queenOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.queenOfCloves);
                        Deck.queenOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 47:
                    tempCard = Deck.queenOfDiamonds;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.queenOfDiamonds);
                        Deck.queenOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 48:
                    tempCard = Deck.queenOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.queenOfHearts);
                        Deck.queenOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 49:
                    tempCard = Deck.kingOfSpades;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.kingOfSpades);
                        Deck.kingOfSpades = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 50:
                    tempCard = Deck.kingOfCloves;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.kingOfCloves);
                        Deck.kingOfCloves = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 51:
                    tempCard = Deck.kingOfDiamonds;
                    if (tempCard.getName().endsWith("s")) {
                        addCard(Deck.kingOfDiamonds);
                        Deck.kingOfDiamonds = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
                case 52:
                    tempCard = Deck.kingOfHearts;
                    if(tempCard.getName().endsWith("s")) {
                        addCard(Deck.kingOfHearts);
                        Deck.kingOfHearts = new Cards();
                        Deck.setCardsLeft(1);
                    }
                    break;
            }

        } while (tempCard.getName().equals("blank"));
    }




}

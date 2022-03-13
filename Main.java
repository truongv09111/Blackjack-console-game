import java.util.Scanner;


public class Main {
    public static Dealer dealer;

    public static void main(String[] args) {

        while(true){


        //create game objects
        int activeHands = 0;
        Player player = new Player();
        dealer = new Dealer();
        boolean isPlayAgain = false;
        boolean quitGame = false;
        int gameLevel = 1;




            //enter game level
            while (true) {
                player.setNumberOfSplits(0);

                if (dealer.getTotalCashAmount() < 10) {
                    if (gameLevel == 1) {
                        System.out.println("Congratulations! You beat level one. Moving on to level two.");
                        gameLevel = 2;
                        player.setTotalCashAmount(200);
                        dealer.setTotalCashAmount(200);
                        continue; //go to next level
                    } else if (gameLevel == 2) {
                        System.out.println("Congratulations! You beat level two. Moving on to level three.");
                        gameLevel = 3;
                        player.setTotalCashAmount(300);
                        dealer.setTotalCashAmount(300);
                        continue;
                    } else if(gameLevel == 3){
                        System.out.println("Congratulations! You beat the game. ");
                        isPlayAgain = promptToPlayAgain();
                        if(isPlayAgain){
                            break;
                        } else{
                            quitGame = true;
                            break;
                        }
                    }
                }
                if (player.getTotalCashAmount() < 10) {
                    System.out.println("Your total cash amount is below the minimum bet amount. You lose this game.");
                    isPlayAgain = promptToPlayAgain();
                    if (isPlayAgain) {
                        break;
                    } else {
                        quitGame = true;
                        break;
                    }
                }


                player.setCheatCodeActivated(false);
                int numberOfHands = 0;
                //welcome message
                if(gameLevel == 1) {
                    System.out.println("Welcome to Truong Vu's Casino : Level 1");
                } else if (gameLevel == 2){
                    System.out.println("Welcome to Truong Vu's Casino: Level 2");
                } else if (gameLevel == 3){
                    System.out.println("Welcome to Truong Vu's Casino: Level 3");
                }



                //output min and max bet
                System.out.println("Minimum bet: $10 Maximum bet: $40");

                //output player's total cash amount
                System.out.println("Total cash amount: " + "$" + player.getTotalCashAmount());


                //prompt player to input bet amount by calling the player.bet() method
                player.bet();
                player.setTotalBetAmountForAllHands(Player.getCurrentBetAmount());
                player.setTotalCashAmountRequired(player.getTotalBetAmountForAllHands());

                //output total bet amount
                System.out.println("You bet: " + "$" + Player.getCurrentBetAmount());


                //deal player's cards
                if (!player.isCheatCodeActivated()) {
                    player.deal();
                }

                //output player's first two cards
                System.out.println("Your cards are: ");
                player.getHand().showHand();
                activeHands = 1;

                //get the total of the player's cards (adds up all the cards that player has)
                player.getHand().getTotal();

                //output the first total, and if there is an ace then output the second total
                System.out.println("Total: " + player.getHand().getHandTotal());
                //output the second total if there is at least one ace in the hand
                if (player.getHand().getHasAce()) {
                    System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                }
                //check to see if player has blackjack
                if (player.getHand().getHasBlackJack()) {
                    System.out.println("Congratulations! You hit blackjack!");
                }


                //output the number of cards left in the deck
                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                pressSpaceToContinue();


                //dealer's turn

                //output dealer's total cash amount (same amount as player's)
                System.out.println("Dealer's total cash amount: " + "$" + dealer.getTotalCashAmount());

                //output dealer's total bet amount (same amount as player's)
                System.out.println("Dealer bet: " + "$" + Dealer.getCurrentBetAmount());

                //deal dealer's cards (two cards are dealt)
                dealer.deal();

                //output dealer's first card and don't show dealer's second card and only print dealer's first card total
                if (!dealer.isCardVisible()) { //if cheat code #5 is activated
                    System.out.println("Dealer's cards are: ");
                    System.out.println(dealer.getHand().getFirstCard().getName());
                    System.out.println("Card faced down");
                    System.out.println("Dealer total: " + dealer.getHand().getFirstCard().getRank());
                    if (dealer.getHand().getFirstCard().getName().charAt(0) == 'A') { //if dealer's first card is an ace, output second total
                        System.out.println("Dealer second total: " + dealer.getHand().getFirstCard().getSecondRank());
                    }
                    System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                    pressSpaceToContinue();
                } else {
                    System.out.println("Dealer's cards are: ");
                    dealer.getHand().showHand();
                    dealer.getHand().getTotal();
                    System.out.println("Dealer total: " + dealer.getHand().getHandTotal());
                    if (dealer.getHand().getHasAce()) {
                        System.out.println("Dealer second total: " + dealer.getHand().getSecondHandTotal());
                    }
                    dealer.setCardVisible(false);
                    pressSpaceToContinue();
                }


                //check to see if an ace is showing for dealer, if it is then dealer asks for insurance. Only enter this code block if player does not have blackjack
                if (!player.getHand().getHasBlackJack() && dealer.getHand().getFirstCard().getName().charAt(0) == 'A') { //if player doesn't have blackjack and dealer is showing an ace
                    dealer.promptInsurance(); //dealer asks player if he wants insurance
                    if (dealer.getInsuranceBetIsActive()) { //if player entered 'y' for insurance, then insurance bet is active
                        Dealer.setInsuranceBetAmount(Player.getCurrentBetAmount() / 2); //insurance bet amount is equal to half of current bet amount
                    }
                }


                //get the total of dealer's cards (add up all the cards that dealer has, used to determine if dealer has blackjack)
                dealer.getHand().getTotal();


                //if player and dealer both hit blackjack
                if (player.getHand().getHasBlackJack() && dealer.getHand().getHasBlackJack()) {
                    System.out.println("Dealer's cards are: ");
                    dealer.getHand().showHand();
                    System.out.println("Dealer's total: " + dealer.getHand().getHandTotal());
                    if (dealer.getHand().getHasAce()) {
                        System.out.println("Dealer's second total: " + dealer.getHand().getSecondHandTotal());
                    }
                    System.out.println("Push!");
                    player.getHand().resetHand();
                    dealer.getHand().resetHand();
                    continue;
                } else if (player.getHand().getHasBlackJack() && !dealer.getHand().getHasBlackJack()) { //if player has blackjack but dealer doesn't
                    //subtract dealer's current bet amount from dealer's current total cash amount
                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Dealer.getCurrentBetAmount());
                    //add player's current bet amount to player's current total cash amount
                    player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());
                    System.out.println("Dealer's cards are: ");
                    dealer.getHand().showHand(); //reveal dealer's hand
                    System.out.println("You win! Dealer does not have blackjack");
                    player.getHand().resetHand();
                    dealer.getHand().resetHand();
                    continue;

                } else if (!player.getHand().getHasBlackJack() && dealer.getHand().getHasBlackJack()) { //if dealer has blackjack but player doesn't
                    if (dealer.getInsuranceBetIsActive()) { //player entered yes for insurance
                        System.out.println("Dealer's cards are: ");
                        dealer.getHand().showHand();
                        System.out.println("Dealer total: " + dealer.getHand().getHandTotal());
                        if (dealer.getHand().getHasAce()) {
                            System.out.println("Dealer second total: " + dealer.getHand().getSecondHandTotal());
                        }
                        System.out.println("Congrats! Dealer has blackjack. You won the insurance bet. Push!");
                        dealer.setInsuranceBetIsActive(false);
                        Dealer.setInsuranceBetAmount(0);
                        player.getHand().resetHand();
                        dealer.getHand().resetHand();
                        continue;
                    }
                    //player entered no for insurance but dealer has a blackjack, then player loses
                    //subtract player's current bet amount from player's current total cash amount
                    player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                    //add dealer's current bet amount to dealer's current total cash amount
                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                    System.out.println("Dealer's cards are: ");
                    dealer.getHand().showHand();
                    System.out.println("You lose! Dealer has blackjack");
                    player.getHand().resetHand();
                    dealer.getHand().resetHand();
                    continue;
                    //reset player and dealer

                }

                //player and dealer both don't have black jack

                if (dealer.getInsuranceBetIsActive()) { //but player entered yes for insurance because dealer was showing an ace
                    player.setTotalCashAmount(player.getTotalCashAmount() - Dealer.getInsuranceBetAmount());//subtract insurance bet from player's total cash amount
                    System.out.println("Dealer does not have blackjack. You lose the insurance bet: " + "$" + Dealer.getInsuranceBetAmount());
                    System.out.println("Total cash amount: " + "$" + player.getTotalCashAmount());
                }


                //output player's information again

                //output player's first two cards
                System.out.println("Your cards are: ");
                player.getHand().showHand();
                //output the first total, and if there is an ace then output the second total
                System.out.println("Total: " + player.getHand().getHandTotal());
                //output the second total if there is at least one ace in the hand
                if (player.getHand().getHasAce()) {
                    System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                }
                //output the number of cards left in the deck
                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                pressSpaceToContinue();

                //check to see if player can split
                //if player can split, ask player to split
                if (player.getHand().getCanSplit()) {
                    while (true) {
                        Hand newHandOne = new Hand();
                        Hand newHandTwo = new Hand();
                        Hand newHandThree = new Hand();

                        boolean originalHandAskedToHit = false;
                        boolean newHandOneAskedToHit = false;
                        boolean newHandTwoAskedToHit = false;
                        boolean newHandThreeAskedToHit = false;


                        while (player.getHand().getCanSplit()) { //if player's first two cards are the same rank, then it can split
                            player.promptSplit(); //ask if player wants to split
                            player.setAskedToSplit(true);
                            if (player.isPlayerSplit()) { //if player entered yes for splitting
                                System.out.println("Cards have been split");

                                if (newHandOne.getFirstCard().getName().equals("blank")) {
                                    newHandOne = player.getHand().split();
                                    activeHands += 1;
                                } else if (newHandTwo.getFirstCard().getName().equals("blank")) {
                                    newHandTwo = player.getHand().split();
                                    activeHands += 1;
                                } else if (newHandThree.getFirstCard().getName().equals("blank")) {
                                    newHandThree = player.getHand().split();
                                    activeHands += 1;
                                }
                                //first hand
                                player.hit(); //add second card to first hand
                                player.getHand().getTotal();
                                System.out.println("Your hand: ");
                                player.getHand().showHand();
                                System.out.println("Total: " + player.getHand().getHandTotal());
                                if (player.getHand().getHasAce()) {
                                    System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                                }
                                System.out.println("Current bet amount for this hand: " + "$" + Player.getCurrentBetAmount());
                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                //check for blackjack
                                if (player.getHand().getHasBlackJack()) {
                                    System.out.println("Congratulations! You hit blackjack!");
                                    break;
                                }
                                //check for double down
                                if (player.getHand().getHasDoubleDown()) {
                                    player.promptDoubleDown(); //ask if player wants to double down
                                    if (player.isPlayerDoubledDown()) { //if player entered yes for double down
                                        player.getHand().hit(); //double down
                                        player.getHand().setDidDoubledDown(true);
                                        player.getHand().getTotal();
                                        System.out.println("Your card's are: ");
                                        player.getHand().showHand();
                                        System.out.println("Total: " + player.getHand().getHandTotal());
                                        if (player.getHand().getHasAce()) {
                                            System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                                            player.getHand().setHandTotal(player.getHand().getSecondHandTotal());
                                        }
                                        System.out.println("Your bet amount has doubled. New bet amount: " + "$" + Player.getCurrentBetAmount() * 2);
                                        break;
                                    }

                                }
                                if (!player.getHand().getHasBlackJack() && !player.isPlayerDoubledDown() && !player.getHand().getCanSplit()) { //if hand doesn't have blackjack, can't double down, and can't split
                                    //ask if player wants to hit, enter while loop
                                    while (true) {
                                        //ask if player wants to hit or stay
                                        player.hitOrStay();
                                        originalHandAskedToHit = true;
                                        //if player hit, output all of player's cards
                                        if (player.isPlayerHit()) { //if player hits
                                            player.getHand().hit();
                                            System.out.println("Your cards are: ");
                                            player.getHand().showHand();
                                            player.getHand().getTotal();
                                            //output the first total, and if there is an ace then output the second total
                                            System.out.println("Total: " + player.getHand().getHandTotal());
                                            //output the second total if there is at least one ace in the hand
                                            if (player.getHand().getHasAce()) {
                                                System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                                            }
                                            System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                            if (player.getHand().isBust()) { //if player busts
                                                //subtract current bet amount from total cash amount
                                                player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                                //add current bet amount to dealer's total cash amount
                                                dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                                System.out.println("You have busted! You lose this hand.");
                                                //output the current total cash amount
                                                System.out.println("Total cash amount: " + player.getTotalCashAmount());
                                                //output the number of cards left in the deck
                                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                break;

                                            } else { //if player didn't bust

                                            }


                                        } else { //if player stays and player has an ace, set the hand total to equal second hand total
                                            if (player.getHand().getHasAce()) {
                                                player.getHand().setHandTotal(player.getHand().getSecondHandTotal());
                                            }
                                            break;

                                        }
                                    }


                                }

                            } else { //player does not want to split
                                boolean doubleDowned = false;
                                //check for double down
                                if (player.getHand().getHasDoubleDown()) {
                                    while (true) {
                                        player.promptDoubleDown(); //ask if player wants to double down
                                        if (player.isPlayerDoubledDown()) { //if player entered yes for double down
                                            doubleDowned = true;
                                            player.getHand().hit(); //double down
                                            player.getHand().setDidDoubledDown(true);
                                            player.getHand().getTotal();
                                            System.out.println("Your card's are: ");
                                            player.getHand().showHand();
                                            System.out.println("Total: " + player.getHand().getHandTotal());
                                            if (player.getHand().getHasAce()) {
                                                System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                                                player.getHand().setHandTotal(player.getHand().getSecondHandTotal());
                                            }
                                            System.out.println("Your bet amount has doubled. New bet amount: " + "$" + Player.getCurrentBetAmount() * 2);
                                            break;
                                        } else {
                                            break;
                                        }
                                    }
                                }
                                //ask player if he wants to hit
                                if (doubleDowned == false) {
                                    while (true) {
                                        //ask if player wants to hit or stay
                                        player.hitOrStay();
                                        originalHandAskedToHit = true;
                                        //if player hit, output all of player's cards
                                        if (player.isPlayerHit()) { //if player hits
                                            player.getHand().hit();
                                            System.out.println("Your cards are: ");
                                            player.getHand().showHand();
                                            player.getHand().getTotal();
                                            //output the first total, and if there is an ace then output the second total
                                            System.out.println("Total: " + player.getHand().getHandTotal());
                                            //output the second total if there is at least one ace in the hand
                                            if (player.getHand().getHasAce()) {
                                                System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                                            }
                                            System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                            if (player.getHand().isBust()) { //if player busts
                                                //subtract current bet amount from total cash amount
                                                player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                                //add current bet amount to dealer's total cash amount
                                                dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                                System.out.println("You have busted! You lose this hand.");
                                                //output the current total cash amount
                                                System.out.println("Total cash amount: " + player.getTotalCashAmount());
                                                //output the number of cards left in the deck
                                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                break;

                                            } else { //if player didn't bust

                                            }


                                        } else { //if player stays and player has an ace, set the hand total to equal second hand total
                                            if (player.getHand().getHasAce()) {
                                                player.getHand().setHandTotal(player.getHand().getSecondHandTotal());
                                            }
                                            break;
                                        }
                                    }
                                }

                                break;
                            }

                        }

                        //reset playerHit, playerDoubledDown, and player split to false before entering the other active hands
                        player.setPlayerHit(false);
                        player.setPlayerDoubledDown(false);
                        player.setPlayerSplit(false);


                        //check how many active hands there is
                        if (newHandOne.getFirstCard().getName().endsWith("s")) {

                            newHandOne.hit(); //add a second card to this hand
                            newHandOne.getTotal();
                            System.out.println("Your hand: ");
                            newHandOne.showHand();
                            System.out.println("Total: " + newHandOne.getHandTotal());
                            if (newHandOne.getHasAce()) {
                                System.out.println("Second total: " + newHandOne.getSecondHandTotal());
                            }
                            System.out.println("Current bet amount for this hand: " + "$" + Player.getCurrentBetAmount());
                            System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                            if (newHandOne.getCanSplit()) {
                                while (newHandOne.getCanSplit()) {
                                    player.promptSplit();
                                    if (player.isPlayerSplit()) {
                                        System.out.println("Cards have been split");
                                        if (newHandTwo.getFirstCard().getName().equals("blank")) {
                                            newHandTwo = newHandOne.split();
                                            activeHands += 1;
                                        } else if (newHandThree.getFirstCard().getName().equals("blank")) {
                                            newHandThree = newHandOne.split();
                                            activeHands += 1;
                                        }
                                        //second hand
                                        newHandOne.hit(); //add second card
                                        newHandOne.getTotal();
                                        System.out.println("Your hand: ");
                                        newHandOne.showHand();
                                        System.out.println("Total: " + newHandOne.getHandTotal());
                                        if (newHandOne.getHasAce()) {
                                            System.out.println("Second total: " + newHandOne.getSecondHandTotal());
                                        }
                                        System.out.println("Current bet amount for this hand: " + "$" + Player.getCurrentBetAmount());
                                        System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                        //check for blackjack
                                        if (newHandOne.getHasBlackJack()) {
                                            System.out.println("Congratulations! You hit blackjack!");
                                            break;
                                        }
                                        //check for double down
                                        if (newHandOne.getHasDoubleDown()) {
                                            player.promptDoubleDown(); //ask if player wants to double down
                                            if (player.isPlayerDoubledDown()) { //if player entered yes for double down
                                                newHandOne.hit(); //double down
                                                newHandOne.setDidDoubledDown(true);
                                                newHandOne.getTotal();
                                                System.out.println("Your card's are: ");
                                                newHandOne.showHand();
                                                System.out.println("Total: " + newHandOne.getHandTotal());
                                                if (player.getHand().getHasAce()) {
                                                    System.out.println("Second total: " + newHandOne.getSecondHandTotal());
                                                    newHandOne.setHandTotal(newHandOne.getSecondHandTotal());
                                                }
                                                System.out.println("Your bet amount has doubled. New bet amount: " + "$" + Player.getCurrentBetAmount() * 2);
                                                break;
                                            }

                                        }
                                        if (!newHandOne.getHasBlackJack() && !player.isPlayerDoubledDown() && !newHandOne.getCanSplit()) { //if hand doesn't have blackjack, can't double down, and can't split
                                            //ask if player wants to hit, enter while loop
                                            while (true) {
                                                //ask if player wants to hit or stay
                                                player.hitOrStay();
                                                newHandOneAskedToHit = true;
                                                //if player hit, output all of player's cards
                                                if (player.isPlayerHit()) { //if player hits
                                                    newHandOne.hit(); //player hits
                                                    System.out.println("Your cards are: ");
                                                    newHandOne.showHand();
                                                    newHandOne.getTotal();
                                                    //output the first total, and if there is an ace then output the second total
                                                    System.out.println("Total: " + newHandOne.getHandTotal());
                                                    //output the second total if there is at least one ace in the hand
                                                    if (newHandOne.getHasAce()) {
                                                        System.out.println("Second total: " + newHandOne.getSecondHandTotal());
                                                    }
                                                    System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                    if (newHandOne.isBust()) { //if player busts
                                                        //subtract current bet amount from total cash amount
                                                        player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                                        //add current bet amount to dealer's total cash amount
                                                        dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                                        System.out.println("You have busted! You lose this hand.");
                                                        //output the current total cash amount
                                                        System.out.println("Total cash amount: " + player.getTotalCashAmount());
                                                        //output the number of cards left in the deck
                                                        System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                        break;

                                                    } else { //if player didn't bust

                                                    }


                                                } else { //if player stays and player has an ace, set the hand total to equal second hand total
                                                    if (newHandOne.getHasAce()) {
                                                        newHandOne.setHandTotal(player.getHand().getSecondHandTotal());
                                                    }
                                                    break;
                                                }
                                            }


                                        }
                                    } else { //player doesn't want to split
                                        boolean doubleDowned = false;
                                        //check for double down
                                        if (newHandOne.getHasDoubleDown()) {
                                            while (true) {
                                                player.promptDoubleDown(); //ask if player wants to double down
                                                if (player.isPlayerDoubledDown()) { //if player entered yes for double down
                                                    doubleDowned = true;
                                                    newHandOne.hit(); //double down
                                                    newHandOne.setDidDoubledDown(true);
                                                    newHandOne.getTotal();
                                                    System.out.println("Your card's are: ");
                                                    newHandOne.showHand();
                                                    System.out.println("Total: " + newHandOne.getHandTotal());
                                                    if (newHandOne.getHasAce()) {
                                                        System.out.println("Second total: " + newHandOne.getSecondHandTotal());
                                                        newHandOne.setHandTotal(newHandOne.getSecondHandTotal());
                                                    }
                                                    System.out.println("Your bet amount has doubled. New bet amount: " + "$" + Player.getCurrentBetAmount() * 2);
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            }
                                        }
                                        if (doubleDowned == false) {
                                            while (true) {
                                                //ask if player wants to hit or stay
                                                player.hitOrStay();
                                                newHandOneAskedToHit = true;
                                                //if player hit, output all of player's cards
                                                if (player.isPlayerHit()) { //if player hits
                                                    newHandOne.hit();
                                                    System.out.println("Your cards are: ");
                                                    newHandOne.showHand();
                                                    newHandOne.getTotal();
                                                    //output the first total, and if there is an ace then output the second total
                                                    System.out.println("Total: " + newHandOne.getHandTotal());
                                                    //output the second total if there is at least one ace in the hand
                                                    if (newHandOne.getHasAce()) {
                                                        System.out.println("Second total: " + newHandOne.getSecondHandTotal());

                                                    }
                                                    System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                    if (newHandOne.isBust()) { //if player busts
                                                        //subtract current bet amount from total cash amount
                                                        player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                                        //add current bet amount to dealer's total cash amount
                                                        dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                                        System.out.println("You have busted! You lose this hand.");
                                                        //output the current total cash amount
                                                        System.out.println("Total cash amount: " + player.getTotalCashAmount());
                                                        //output the number of cards left in the deck
                                                        System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                        break;

                                                    } else { //if player didn't bust

                                                    }


                                                } else { //if player stays and player has an ace, set the hand total to equal second hand total
                                                    if (newHandOne.getHasAce()) {
                                                        newHandOne.setHandTotal(newHandOne.getSecondHandTotal());
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    break;


                                }
                            } else { //if newHandOne can't split
                                boolean gotBlackJack = false;
                                boolean doubledDown = false;
                                //check for blackjack
                                if (newHandOne.getHasBlackJack()) {
                                    System.out.println("Congratulations! You hit blackjack!");
                                    gotBlackJack = true;

                                }
                                //check for double down
                                if (newHandOne.getHasDoubleDown()) {
                                    player.promptDoubleDown(); //ask if player wants to double down
                                    if (player.isPlayerDoubledDown()) { //if player entered yes for double down
                                        doubledDown = true;
                                        newHandOne.hit(); //double down
                                        newHandOne.setDidDoubledDown(true);
                                        newHandOne.getTotal();
                                        System.out.println("Your card's are: ");
                                        newHandOne.showHand();
                                        System.out.println("Total: " + newHandOne.getHandTotal());
                                        if (player.getHand().getHasAce()) {
                                            System.out.println("Second total: " + newHandOne.getSecondHandTotal());
                                            newHandOne.setHandTotal(newHandOne.getSecondHandTotal());
                                        }
                                        System.out.println("Your bet amount has doubled. New bet amount: " + "$" + Player.getCurrentBetAmount() * 2);

                                    }

                                }

                                //ask player if he wants to hit newHandOne
                                if (!gotBlackJack && !doubledDown) {
                                    while (true) {
                                        //ask if player wants to hit or stay
                                        player.hitOrStay();
                                        newHandOneAskedToHit = true;
                                        //if player hit, output all of player's cards
                                        if (player.isPlayerHit()) { //if player hits
                                            newHandOne.hit();
                                            System.out.println("Your cards are: ");
                                            newHandOne.showHand();
                                            newHandOne.getTotal();
                                            //output the first total, and if there is an ace then output the second total
                                            System.out.println("Total: " + newHandOne.getHandTotal());
                                            //output the second total if there is at least one ace in the hand
                                            if (newHandOne.getHasAce()) {
                                                System.out.println("Second total: " + newHandOne.getSecondHandTotal());
                                            }
                                            System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                            if (newHandOne.isBust()) { //if player busts
                                                //subtract current bet amount from total cash amount
                                                player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                                //add current bet amount to dealer's total cash amount
                                                dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                                System.out.println("You have busted! You lose this hand.");
                                                //output the current total cash amount
                                                System.out.println("Total cash amount: " + player.getTotalCashAmount());
                                                //output the number of cards left in the deck
                                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                break;

                                            } else { //if player didn't bust

                                            }


                                        } else { //if player stays and player has an ace, set the hand total to equal second hand total
                                            if (newHandOne.getHasAce()) {
                                                newHandOne.setHandTotal(newHandOne.getSecondHandTotal());
                                            }
                                            break;
                                        }
                                    }
                                }
                            }

                        }
                        //reset playerHit, playerDoubledDown, and player split to false before entering the other active hands
                        player.setPlayerHit(false);
                        player.setPlayerDoubledDown(false);
                        player.setPlayerSplit(false);

                        if (newHandTwo.getFirstCard().getName().endsWith("s")) {
                            newHandTwo.hit(); //add a second card to this hand
                            newHandTwo.getTotal();
                            System.out.println("Your hand: ");
                            newHandTwo.showHand();
                            System.out.println("Total: " + newHandTwo.getHandTotal());
                            if (newHandTwo.getHasAce()) {
                                System.out.println("Second total: " + newHandTwo.getSecondHandTotal());
                            }
                            System.out.println("Current bet amount for this hand: " + "$" + Player.getCurrentBetAmount());
                            System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                            if (newHandTwo.getCanSplit()) {
                                while (newHandTwo.getCanSplit()) {
                                    player.promptSplit();
                                    if (player.isPlayerSplit()) {
                                        System.out.println("Cards have been split");
                                        if (newHandThree.getFirstCard().getName().equals("blank")) {
                                            newHandThree = newHandTwo.split();
                                            activeHands += 1;
                                        }
                                        //second hand
                                        newHandTwo.hit(); //add second card
                                        newHandTwo.getTotal();
                                        System.out.println("Your hand: ");
                                        newHandTwo.showHand();
                                        System.out.println("Total: " + newHandTwo.getHandTotal());
                                        if (newHandTwo.getHasAce()) {
                                            System.out.println("Second total: " + newHandTwo.getSecondHandTotal());
                                        }
                                        System.out.println("Current bet amount for this hand: " + "$" + Player.getCurrentBetAmount());
                                        System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                        //check for blackjack
                                        if (newHandTwo.getHasBlackJack()) {
                                            System.out.println("Congratulations! You hit blackjack!");
                                            break;
                                        }
                                        //check for double down
                                        if (newHandTwo.getHasDoubleDown()) {
                                            player.promptDoubleDown(); //ask if player wants to double down
                                            if (player.isPlayerDoubledDown()) { //if player entered yes for double down
                                                newHandTwo.hit(); //double down
                                                newHandTwo.setDidDoubledDown(true);
                                                newHandTwo.getTotal();
                                                System.out.println("Your card's are: ");
                                                newHandTwo.showHand();
                                                System.out.println("Total: " + newHandTwo.getHandTotal());
                                                if (player.getHand().getHasAce()) {
                                                    System.out.println("Second total: " + newHandTwo.getSecondHandTotal());
                                                    newHandTwo.setHandTotal(newHandTwo.getSecondHandTotal());
                                                }
                                                System.out.println("Your bet amount has doubled. New bet amount: " + "$" + Player.getCurrentBetAmount() * 2);
                                                break;

                                            }

                                        }
                                        if (!newHandTwo.getHasBlackJack() && !player.isPlayerDoubledDown() && !newHandTwo.getCanSplit()) { //if hand doesn't have blackjack, can't double down, and can't split
                                            //ask if player wants to hit, enter while loop
                                            while (true) {
                                                //ask if player wants to hit or stay
                                                player.hitOrStay();
                                                newHandTwoAskedToHit = true;
                                                //if player hit, output all of player's cards
                                                if (player.isPlayerHit()) { //if player hits
                                                    newHandTwo.hit(); //player hits
                                                    System.out.println("Your cards are: ");
                                                    newHandTwo.showHand();
                                                    newHandTwo.getTotal();
                                                    //output the first total, and if there is an ace then output the second total
                                                    System.out.println("Total: " + newHandTwo.getHandTotal());
                                                    //output the second total if there is at least one ace in the hand
                                                    if (newHandTwo.getHasAce()) {
                                                        System.out.println("Second total: " + newHandTwo.getSecondHandTotal());
                                                    }
                                                    System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                    if (newHandTwo.isBust()) { //if player busts
                                                        //subtract current bet amount from total cash amount
                                                        player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                                        //add current bet amount to dealer's total cash amount
                                                        dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                                        System.out.println("You have busted! You lose this hand.");
                                                        //output the current total cash amount
                                                        System.out.println("Total cash amount: " + player.getTotalCashAmount());
                                                        //output the number of cards left in the deck
                                                        System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                        break;

                                                    } else { //if player didn't bust

                                                    }


                                                } else { //if player stays and player has an ace, set the hand total to equal second hand total
                                                    if (newHandTwo.getHasAce()) {
                                                        newHandTwo.setHandTotal(player.getHand().getSecondHandTotal());
                                                    }
                                                    break;
                                                }
                                            }


                                        }
                                    } else { //player doesn't want to split
                                        boolean doubleDowned = false;
                                        //check for double down
                                        if (newHandTwo.getHasDoubleDown()) {
                                            while (true) {
                                                player.promptDoubleDown(); //ask if player wants to double down
                                                if (player.isPlayerDoubledDown()) { //if player entered yes for double down
                                                    doubleDowned = true;
                                                    newHandTwo.hit(); //double down
                                                    newHandTwo.setDidDoubledDown(true);
                                                    newHandTwo.getTotal();
                                                    System.out.println("Your card's are: ");
                                                    newHandTwo.showHand();
                                                    System.out.println("Total: " + newHandTwo.getHandTotal());
                                                    if (player.getHand().getHasAce()) {
                                                        System.out.println("Second total: " + newHandTwo.getSecondHandTotal());
                                                        newHandTwo.setHandTotal(newHandTwo.getSecondHandTotal());
                                                    }
                                                    System.out.println("Your bet amount has doubled. New bet amount: " + "$" + Player.getCurrentBetAmount() * 2);
                                                    break;
                                                } else {
                                                    break;
                                                }
                                            }
                                        }
                                        if (doubleDowned == false) {
                                            while (true) {
                                                //ask if player wants to hit or stay
                                                player.hitOrStay();
                                                newHandTwoAskedToHit = true;
                                                //if player hit, output all of player's cards
                                                if (player.isPlayerHit()) { //if player hits
                                                    newHandTwo.hit();
                                                    System.out.println("Your cards are: ");
                                                    newHandTwo.showHand();
                                                    newHandTwo.getTotal();
                                                    //output the first total, and if there is an ace then output the second total
                                                    System.out.println("Total: " + newHandTwo.getHandTotal());
                                                    //output the second total if there is at least one ace in the hand
                                                    if (newHandTwo.getHasAce()) {
                                                        System.out.println("Second total: " + newHandTwo.getSecondHandTotal());
                                                    }
                                                    System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                    if (newHandTwo.isBust()) { //if player busts
                                                        //subtract current bet amount from total cash amount
                                                        player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                                        //add current bet amount to dealer's total cash amount
                                                        dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                                        System.out.println("You have busted! You lose this hand.");
                                                        //output the current total cash amount
                                                        System.out.println("Total cash amount: " + player.getTotalCashAmount());
                                                        //output the number of cards left in the deck
                                                        System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                        break;

                                                    } else { //if player didn't bust

                                                    }


                                                } else { //if player stays and player has an ace, set the hand total to equal second hand total
                                                    if (newHandTwo.getHasAce()) {
                                                        newHandTwo.setHandTotal(newHandTwo.getSecondHandTotal());
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    break;


                                }
                            } else { //newhandTwo can't split
                                boolean gotBlackJack = false;
                                boolean doubledDown = false;
                                //check for blackjack
                                if (newHandTwo.getHasBlackJack()) {
                                    System.out.println("Congratulations! You hit blackjack!");
                                    gotBlackJack = true;
                                }
                                //check for double down
                                if (newHandTwo.getHasDoubleDown()) {
                                    player.promptDoubleDown(); //ask if player wants to double down
                                    if (player.isPlayerDoubledDown()) { //if player entered yes for double down
                                        doubledDown = true;
                                        newHandTwo.hit(); //double down
                                        newHandTwo.setDidDoubledDown(true);
                                        newHandTwo.getTotal();
                                        System.out.println("Your card's are: ");
                                        newHandTwo.showHand();
                                        System.out.println("Total: " + newHandTwo.getHandTotal());
                                        if (player.getHand().getHasAce()) {
                                            System.out.println("Second total: " + newHandTwo.getSecondHandTotal());
                                            newHandTwo.setHandTotal(newHandTwo.getSecondHandTotal());
                                        }
                                        System.out.println("Your bet amount has doubled. New bet amount: " + "$" + Player.getCurrentBetAmount() * 2);

                                    }

                                }

                                if (!gotBlackJack && !doubledDown) {
                                    while (true) {
                                        //ask if player wants to hit or stay
                                        player.hitOrStay();
                                        newHandTwoAskedToHit = true;
                                        //if player hit, output all of player's cards
                                        if (player.isPlayerHit()) { //if player hits
                                            newHandTwo.hit();
                                            System.out.println("Your cards are: ");
                                            newHandTwo.showHand();
                                            newHandTwo.getTotal();
                                            //output the first total, and if there is an ace then output the second total
                                            System.out.println("Total: " + newHandTwo.getHandTotal());
                                            //output the second total if there is at least one ace in the hand
                                            if (newHandTwo.getHasAce()) {
                                                System.out.println("Second total: " + newHandTwo.getSecondHandTotal());
                                            }
                                            System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                            if (newHandTwo.isBust()) { //if player busts
                                                //subtract current bet amount from total cash amount
                                                player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                                //add current bet amount to dealer's total cash amount
                                                dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                                System.out.println("You have busted! You lose this hand.");
                                                //output the current total cash amount
                                                System.out.println("Total cash amount: " + player.getTotalCashAmount());
                                                //output the number of cards left in the deck
                                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                break;

                                            } else { //if player didn't bust

                                            }


                                        } else { //if player stays and player has an ace, set the hand total to equal second hand total
                                            if (newHandTwo.getHasAce()) {
                                                newHandTwo.setHandTotal(newHandTwo.getSecondHandTotal());
                                            }
                                            break;
                                        }
                                    }
                                }
                            }

                        }
                        //reset playerHit, playerDoubledDown, and player split to false before entering the other active hands
                        player.setPlayerHit(false);
                        player.setPlayerDoubledDown(false);
                        player.setPlayerSplit(false);

                        if (newHandThree.getFirstCard().getName().endsWith("s")) {
                            newHandThree.hit(); //add a second card to this hand
                            newHandThree.getTotal();
                            System.out.println("Your hand: ");
                            newHandThree.showHand();
                            System.out.println("Total: " + newHandThree.getHandTotal());
                            if (newHandThree.getHasAce()) {
                                System.out.println("Second total: " + newHandThree.getSecondHandTotal());
                            }
                            System.out.println("Current bet amount for this hand: " + "$" + Player.getCurrentBetAmount());
                            System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                            if (newHandThree.getCanSplit()) {
                                while (newHandThree.getCanSplit()) {
                                    player.promptSplit();
                                    if (player.isPlayerSplit()) {
                                        System.out.println("Cards have been split");

                                        //fourth hand
                                        newHandThree.hit(); //add second card
                                        newHandThree.getTotal();
                                        System.out.println("Your hand: ");
                                        newHandThree.showHand();
                                        System.out.println("Total: " + newHandThree.getHandTotal());
                                        if (newHandThree.getHasAce()) {
                                            System.out.println("Second total: " + newHandThree.getSecondHandTotal());
                                        }
                                        System.out.println("Current bet amount for this hand: " + "$" + Player.getCurrentBetAmount());
                                        System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                        //check for blackjack
                                        if (newHandThree.getHasBlackJack()) {
                                            System.out.println("Congratulations! You hit blackjack!");
                                            break;
                                        }
                                        //check for double down
                                        if (newHandThree.getHasDoubleDown()) {
                                            player.promptDoubleDown(); //ask if player wants to double down
                                            if (player.isPlayerDoubledDown()) { //if player entered yes for double down
                                                newHandThree.hit(); //double down
                                                newHandThree.setDidDoubledDown(true);
                                                newHandThree.getTotal();
                                                System.out.println("Your card's are: ");
                                                newHandThree.showHand();
                                                System.out.println("Total: " + newHandThree.getHandTotal());
                                                if (player.getHand().getHasAce()) {
                                                    System.out.println("Second total: " + newHandThree.getSecondHandTotal());
                                                    newHandThree.setHandTotal(newHandThree.getSecondHandTotal());
                                                }
                                                System.out.println("Your bet amount has doubled. New bet amount: " + "$" + Player.getCurrentBetAmount() * 2);
                                                break;

                                            }

                                        }
                                        if (!newHandThree.getHasBlackJack() && !player.isPlayerDoubledDown() && !newHandThree.getCanSplit()) { //if hand doesn't have blackjack, can't double down, and can't split
                                            //ask if player wants to hit, enter while loop
                                            while (true) {
                                                //ask if player wants to hit or stay
                                                player.hitOrStay();
                                                newHandThreeAskedToHit = true;
                                                //if player hit, output all of player's cards
                                                if (player.isPlayerHit()) { //if player hits
                                                    newHandThree.hit(); //player hits
                                                    System.out.println("Your cards are: ");
                                                    newHandThree.showHand();
                                                    newHandThree.getTotal();
                                                    //output the first total, and if there is an ace then output the second total
                                                    System.out.println("Total: " + newHandThree.getHandTotal());
                                                    //output the second total if there is at least one ace in the hand
                                                    if (newHandThree.getHasAce()) {
                                                        System.out.println("Second total: " + newHandThree.getSecondHandTotal());
                                                    }
                                                    System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                    if (newHandThree.isBust()) { //if player busts
                                                        //subtract current bet amount from total cash amount
                                                        player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                                        //add current bet amount to dealer's total cash amount
                                                        dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                                        System.out.println("You have busted! You lose this hand.");
                                                        //output the current total cash amount
                                                        System.out.println("Total cash amount: " + player.getTotalCashAmount());
                                                        //output the number of cards left in the deck
                                                        System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                        break;

                                                    } else { //if player didn't bust

                                                    }


                                                } else { //if player stays and player has an ace, set the hand total to equal second hand total
                                                    if (newHandThree.getHasAce()) {
                                                        newHandThree.setHandTotal(player.getHand().getSecondHandTotal());
                                                    }
                                                    break;
                                                }
                                            }


                                        }
                                    } else { //player does not want to split
                                        boolean doubledDown = false;
                                        //check for double down
                                        if (newHandThree.getHasDoubleDown()) {
                                            player.promptDoubleDown(); //ask if player wants to double down
                                            if (player.isPlayerDoubledDown()) { //if player entered yes for double down
                                                newHandThree.hit(); //double down
                                                newHandThree.setDidDoubledDown(true);
                                                newHandThree.getTotal();
                                                System.out.println("Your card's are: ");
                                                newHandThree.showHand();
                                                System.out.println("Total: " + newHandThree.getHandTotal());
                                                if (player.getHand().getHasAce()) {
                                                    System.out.println("Second total: " + newHandThree.getSecondHandTotal());
                                                    newHandThree.setHandTotal(newHandThree.getSecondHandTotal());
                                                }
                                                System.out.println("Your bet amount has doubled. New bet amount: " + "$" + Player.getCurrentBetAmount() * 2);
                                                break;
                                            } else {
                                                break;
                                            }

                                        }
                                        if (doubledDown == false) {
                                            while (true) {
                                                //ask if player wants to hit or stay
                                                player.hitOrStay();
                                                newHandThreeAskedToHit = true;
                                                //if player hit, output all of player's cards
                                                if (player.isPlayerHit()) { //if player hits
                                                    newHandThree.hit();
                                                    System.out.println("Your cards are: ");
                                                    newHandThree.showHand();
                                                    newHandThree.getTotal();
                                                    //output the first total, and if there is an ace then output the second total
                                                    System.out.println("Total: " + newHandThree.getHandTotal());
                                                    //output the second total if there is at least one ace in the hand
                                                    if (newHandThree.getHasAce()) {
                                                        System.out.println("Second total: " + newHandThree.getSecondHandTotal());
                                                    }
                                                    System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                    if (newHandThree.isBust()) { //if player busts
                                                        //subtract current bet amount from total cash amount
                                                        player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                                        //add current bet amount to dealer's total cash amount
                                                        dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                                        System.out.println("You have busted! You lose this hand.");
                                                        //output the current total cash amount
                                                        System.out.println("Total cash amount: " + player.getTotalCashAmount());
                                                        //output the number of cards left in the deck
                                                        System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                        break;

                                                    } else { //if player didn't bust

                                                    }


                                                } else { //if player stays and player has an ace, set the hand total to equal second hand total
                                                    if (newHandThree.getHasAce()) {
                                                        newHandThree.setHandTotal(newHandThree.getSecondHandTotal());
                                                    }
                                                    break;
                                                }
                                            }
                                        }
                                    }


                                }
                            } else { //newHandThree can't split
                                boolean gotBlackJack = false;
                                boolean doubledDown = false;
                                //check for blackjack
                                if (newHandThree.getHasBlackJack()) {
                                    System.out.println("Congratulations! You hit blackjack!");
                                    gotBlackJack = true;

                                }
                                //check for double down
                                if (newHandThree.getHasDoubleDown()) {
                                    player.promptDoubleDown(); //ask if player wants to double down
                                    if (player.isPlayerDoubledDown()) { //if player entered yes for double down
                                        doubledDown = true;
                                        newHandThree.hit(); //double down
                                        newHandThree.setDidDoubledDown(true);
                                        newHandThree.getTotal();
                                        System.out.println("Your card's are: ");
                                        newHandThree.showHand();
                                        System.out.println("Total: " + newHandThree.getHandTotal());
                                        if (player.getHand().getHasAce()) {
                                            System.out.println("Second total: " + newHandThree.getSecondHandTotal());
                                            newHandThree.setHandTotal(newHandThree.getSecondHandTotal());
                                        }
                                        System.out.println("Your bet amount has doubled. New bet amount: " + "$" + Player.getCurrentBetAmount() * 2);

                                    }

                                }
                                if (!gotBlackJack && !doubledDown) {
                                    while (true) {
                                        //ask if player wants to hit or stay
                                        player.hitOrStay();
                                        newHandThreeAskedToHit = true;
                                        //if player hit, output all of player's cards
                                        if (player.isPlayerHit()) { //if player hits
                                            newHandThree.hit();
                                            System.out.println("Your cards are: ");
                                            newHandThree.showHand();
                                            newHandThree.getTotal();
                                            //output the first total, and if there is an ace then output the second total
                                            System.out.println("Total: " + newHandThree.getHandTotal());
                                            //output the second total if there is at least one ace in the hand
                                            if (newHandThree.getHasAce()) {
                                                System.out.println("Second total: " + newHandThree.getSecondHandTotal());
                                            }
                                            System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                            if (newHandThree.isBust()) { //if player busts
                                                //subtract current bet amount from total cash amount
                                                player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                                //add current bet amount to dealer's total cash amount
                                                dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                                System.out.println("You have busted! You lose this hand.");
                                                //output the current total cash amount
                                                System.out.println("Total cash amount: " + player.getTotalCashAmount());
                                                //output the number of cards left in the deck
                                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                                break;

                                            } else { //if player didn't bust

                                            }


                                        } else { //if player stays and player has an ace, set the hand total to equal second hand total
                                            if (newHandThree.getHasAce()) {
                                                newHandThree.setHandTotal(newHandThree.getSecondHandTotal());
                                            }
                                            break;
                                        }
                                    }
                                }
                            }

                        }

                        player.setPlayerHit(false);
                        player.setPlayerDoubledDown(false);
                        player.setPlayerSplit(false);


                        //dealers turn to hit
                        System.out.println("Dealer's cards are: ");
                        dealer.getHand().showHand();
                        //output dealer's hand total
                        System.out.println("Dealer total: " + dealer.getHand().getHandTotal());
                        //if there is an ace output dealer's second hand total
                        if (dealer.getHand().getHasAce()) {
                            System.out.println("Dealer second total: " + dealer.getHand().getSecondHandTotal());
                        }
                        System.out.println("Cards left in deck: " + Deck.getCardsLeft());


                        //check each of player's active hands for blackjack, if player's active hands have blackjack then player wins because dealer does not have blackjack at this point


                        if (player.getHand().getHasBlackJack()) {
                            System.out.println("Your cards are: ");
                            player.getHand().showHand();
                            //output the first total, and if there is an ace then output the second total
                            System.out.println("Total: " + player.getHand().getHandTotal());
                            //output the second total if there is at least one ace in the hand
                            if (player.getHand().getHasAce()) {
                                System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                            }
                            System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                            System.out.println("You have blackjack!");
                            player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());
                            dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Player.getCurrentBetAmount());
                            System.out.println("You win this hand! Dealer does not have blackjack.");

                        }
                        if (newHandOne.getHasBlackJack()) {
                            System.out.println("Your cards are: ");
                            newHandOne.showHand();
                            //output the first total, and if there is an ace then output the second total
                            System.out.println("Total: " + newHandOne.getHandTotal());
                            //output the second total if there is at least one ace in the hand
                            if (newHandOne.getHasAce()) {
                                System.out.println("Second total: " + newHandOne.getSecondHandTotal());
                            }
                            System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                            System.out.println("You have blackjack!");
                            player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());
                            dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Player.getCurrentBetAmount());
                            System.out.println("You win this hand! Dealer does not have blackjack.");

                        }
                        if (newHandTwo.getHasBlackJack()) {
                            System.out.println("Your cards are: ");
                            newHandTwo.showHand();
                            //output the first total, and if there is an ace then output the second total
                            System.out.println("Total: " + newHandTwo.getHandTotal());
                            //output the second total if there is at least one ace in the hand
                            if (newHandTwo.getHasAce()) {
                                System.out.println("Second total: " + newHandTwo.getSecondHandTotal());
                            }
                            System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                            System.out.println("You have blackjack!");
                            player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());
                            dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Player.getCurrentBetAmount());
                            System.out.println("You win this hand! Dealer does not have blackjack.");

                        }
                        if (newHandThree.getHasBlackJack()) {
                            System.out.println("Your cards are: ");
                            newHandThree.showHand();
                            //output the first total, and if there is an ace then output the second total
                            System.out.println("Total: " + newHandThree.getHandTotal());
                            //output the second total if there is at least one ace in the hand
                            if (newHandThree.getHasAce()) {
                                System.out.println("Second total: " + newHandThree.getSecondHandTotal());
                            }
                            System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                            System.out.println("You have blackjack!");
                            player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());
                            dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Player.getCurrentBetAmount());
                            System.out.println("You win this hand! Dealer does not have blackjack.");

                        }


                        pressSpaceToContinue();

                        boolean allowDealerToHit = false;

                        //check active hands for blackjack and if it busted to decide if dealer can hit or not
                        if (activeHands == 1) {
                            if (!player.getHand().isBust()) {
                                allowDealerToHit = true;
                            }
                        } else if (activeHands == 2) {
                            if (!player.getHand().getHasBlackJack() && !player.getHand().isBust() || !newHandOne.getHasBlackJack() && !newHandOne.isBust()) {
                                allowDealerToHit = true;
                            }

                        } else if (activeHands == 3) {
                            if (!player.getHand().getHasBlackJack() && !player.getHand().isBust() || !newHandOne.getHasBlackJack() && !newHandOne.isBust() || !newHandTwo.getHasBlackJack() && !newHandTwo.isBust()) {
                                allowDealerToHit = true;
                            }

                        } else if (activeHands == 4) {
                            if (!player.getHand().getHasBlackJack() && !player.getHand().isBust() || !newHandOne.getHasBlackJack() && !newHandOne.isBust() || !newHandTwo.getHasBlackJack() && newHandTwo.isBust() || !newHandThree.getHasBlackJack() && !newHandThree.isBust()) {
                                allowDealerToHit = true;
                            }

                        }


                        if (allowDealerToHit) {
                            if (!dealer.isHitUntilBust()) { //if cheat code #4 is not activated
                                while (true) {
                                    while (dealer.getHand().getHandTotal() < 17 && dealer.getHand().getSecondHandTotal() <= 17) { //dealer has to hit on soft 17. if hand total is less than 17 and second hand total is less than or equal to 17, dealer has to hit. if second hand total is equal to 17 then that means dealer has an ace and 6 (soft 17)
                                        dealer.hit();
                                        System.out.println("Dealer's cards are: ");
                                        dealer.getHand().showHand();
                                        dealer.getHand().getTotal();
                                        //output dealer's hand total
                                        System.out.println("Dealer total: " + dealer.getHand().getHandTotal());
                                        //output second total if there is at least one ace in the hand
                                        if (dealer.getHand().getHasAce()) {
                                            System.out.println("Dealer second total: " + dealer.getHand().getSecondHandTotal());
                                        }
                                        System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                    }
                                    //after dealer has 17 or more, check to see if dealer bust or not
                                    if (dealer.getHand().isBust()) {
                                        if (activeHands == 1) {
                                            System.out.println("Dealer busted! You win");
                                            //subtract dealer's current bet amount from dealer's current total cash amount
                                            dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Player.getCurrentBetAmount());
                                            //add player's current bet amount to player's current total cash amount
                                            player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());
                                            break;
                                        } else if (activeHands == 2) {
                                            System.out.println("Dealer busted! You win");
                                            //subtract dealer's current bet amount from dealer's current total cash amount
                                            dealer.setTotalCashAmount(dealer.getTotalCashAmount() - (Player.getCurrentBetAmount() * 2));
                                            //add player's current bet amount to player's current total cash amount
                                            player.setTotalCashAmount(player.getTotalCashAmount() + (Player.getCurrentBetAmount() * 2));
                                            break;
                                        } else if (activeHands == 3) {
                                            System.out.println("Dealer busted! You win");
                                            //subtract dealer's current bet amount from dealer's current total cash amount
                                            dealer.setTotalCashAmount(dealer.getTotalCashAmount() - (Player.getCurrentBetAmount() * 3));
                                            //add player's current bet amount to player's current total cash amount
                                            player.setTotalCashAmount(player.getTotalCashAmount() + (Player.getCurrentBetAmount() * 3));
                                            break;

                                        } else if (activeHands == 4) {
                                            System.out.println("Dealer busted! You win");
                                            //subtract dealer's current bet amount from dealer's current total cash amount
                                            dealer.setTotalCashAmount(dealer.getTotalCashAmount() - (Player.getCurrentBetAmount() * 4));
                                            //add player's current bet amount to player's current total cash amount
                                            player.setTotalCashAmount(player.getTotalCashAmount() + (Player.getCurrentBetAmount() * 4));
                                            break;
                                        }

                                    } else { //if dealer didn't bust
                                        if (dealer.getHand().getHasAce()) { //if dealer has ace and second total didnt go over 21
                                            dealer.getHand().setHandTotal(dealer.getHand().getSecondHandTotal()); //set dealer hand total to equal dealer second hand total
                                        }
                                        break;
                                    }
                                }
                            } else {
                                dealerHitUntilBust();
                                dealer.setHitUntilBust(false);
                                if (activeHands == 1) {
                                    System.out.println("Dealer busted! You win");
                                    //subtract dealer's current bet amount from dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Player.getCurrentBetAmount());
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());

                                } else if (activeHands == 2) {
                                    System.out.println("Dealer busted! You win");
                                    //subtract dealer's current bet amount from dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() - (Player.getCurrentBetAmount() * 2));
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() + (Player.getCurrentBetAmount() * 2));

                                } else if (activeHands == 3) {
                                    System.out.println("Dealer busted! You win");
                                    //subtract dealer's current bet amount from dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() - (Player.getCurrentBetAmount() * 3));
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() + (Player.getCurrentBetAmount() * 3));


                                } else if (activeHands == 4) {
                                    System.out.println("Dealer busted! You win");
                                    //subtract dealer's current bet amount from dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() - (Player.getCurrentBetAmount() * 4));
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() + (Player.getCurrentBetAmount() * 4));

                                }

                            }
                        }
                        //check active hands for double down
                        if (player.getHand().isDoubledDown()) {
                            if (!player.getHand().isBust() && !dealer.getHand().isBust()) { //if player bust don't output the information of the hand that busted
                                //output hand information again
                                System.out.println("Your cards are: ");
                                player.getHand().showHand();
                                //output the first total, and if there is an ace then output the second total
                                System.out.println("Total: " + player.getHand().getHandTotal());

                                //output the second total if there is at least one ace in the hand
                                if (player.getHand().getHasAce() && player.getHand().getHandTotal() != player.getHand().getSecondHandTotal()) {
                                    System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                                }
                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                if (player.getHand().getHandTotal() > dealer.getHand().getHandTotal()) {
                                    //subtract dealer's current bet amount from dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() - (Dealer.getCurrentBetAmount() * 2));
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() + (Player.getCurrentBetAmount() * 2));
                                    System.out.println("You win this hand!");

                                } else if (player.getHand().getHandTotal() < dealer.getHand().getHandTotal()) {
                                    //add dealer's current bet amount to dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() + (Dealer.getCurrentBetAmount() * 2));
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() - (Player.getCurrentBetAmount() * 2));
                                    System.out.println("You lose this hand!");

                                } else {
                                    System.out.println("Push!");

                                }
                            }
                        }
                        if (newHandOne.isDoubledDown()) {
                            if (!newHandOne.isBust() && !dealer.getHand().isBust()) {
                                //output hand information again
                                System.out.println("Your cards are: ");
                                newHandOne.showHand();
                                //output the first total, and if there is an ace then output the second total
                                System.out.println("Total: " + newHandOne.getHandTotal());

                                //output the second total if there is at least one ace in the hand
                                if (newHandOne.getHasAce() && newHandOne.getHandTotal() != newHandOne.getSecondHandTotal()) {
                                    System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                                }
                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                if (newHandOne.getHandTotal() > dealer.getHand().getHandTotal()) {
                                    //subtract dealer's current bet amount from dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() - (Dealer.getCurrentBetAmount() * 2));
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() + (Player.getCurrentBetAmount() * 2));
                                    System.out.println("You win!");

                                } else if (newHandOne.getHandTotal() < dealer.getHand().getHandTotal()) {
                                    //add dealer's current bet amount to dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() + (Dealer.getCurrentBetAmount() * 2));
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() - (Player.getCurrentBetAmount() * 2));
                                    System.out.println("You lose!");

                                } else {
                                    System.out.println("Push!");

                                }
                            }
                        }
                        if (newHandTwo.isDoubledDown()) {
                            if (!newHandTwo.isBust() && !dealer.getHand().isBust()) {
                                //output hand information again
                                System.out.println("Your cards are: ");
                                newHandTwo.showHand();
                                //output the first total, and if there is an ace then output the second total
                                System.out.println("Total: " + newHandTwo.getHandTotal());

                                //output the second total if there is at least one ace in the hand
                                if (newHandTwo.getHasAce() && newHandTwo.getHandTotal() != newHandTwo.getSecondHandTotal()) {
                                    System.out.println("Second total: " + newHandTwo.getSecondHandTotal());
                                }
                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                if (newHandTwo.getHandTotal() > dealer.getHand().getHandTotal()) {
                                    //subtract dealer's current bet amount from dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() - (Dealer.getCurrentBetAmount() * 2));
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() + (Player.getCurrentBetAmount() * 2));
                                    System.out.println("You win!");

                                } else if (newHandTwo.getHandTotal() < dealer.getHand().getHandTotal()) {
                                    //add dealer's current bet amount to dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() + (Dealer.getCurrentBetAmount() * 2));
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() - (Player.getCurrentBetAmount() * 2));
                                    System.out.println("You lose!");

                                } else {
                                    System.out.println("Push!");

                                }
                            }
                        }
                        if (newHandThree.isDoubledDown()) {
                            if (!newHandThree.isBust() && !dealer.getHand().isBust()) {
                                //output hand information again
                                System.out.println("Your cards are: ");
                                newHandThree.showHand();
                                //output the first total, and if there is an ace then output the second total
                                System.out.println("Total: " + newHandThree.getHandTotal());

                                //output the second total if there is at least one ace in the hand
                                if (newHandThree.getHasAce() && newHandThree.getHandTotal() != newHandThree.getSecondHandTotal()) {
                                    System.out.println("Second total: " + newHandThree.getSecondHandTotal());
                                }
                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                if (newHandThree.getHandTotal() > dealer.getHand().getHandTotal()) {
                                    //subtract dealer's current bet amount from dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() - (Dealer.getCurrentBetAmount() * 2));
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() + (Player.getCurrentBetAmount() * 2));
                                    System.out.println("You win!");

                                } else if (newHandThree.getHandTotal() < dealer.getHand().getHandTotal()) {
                                    //add dealer's current bet amount to dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() + (Dealer.getCurrentBetAmount() * 2));
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() - (Player.getCurrentBetAmount() * 2));
                                    System.out.println("You lose!");

                                } else {
                                    System.out.println("Push!");

                                }
                            }
                        }


                        //check each active hand to determine which active hand wins
                        if (originalHandAskedToHit == true) {
                            if (!player.getHand().isBust() && !dealer.getHand().isBust()) { //if player bust don't output the information of the hand that busted
                                //output hand information again
                                System.out.println("Your cards are: ");
                                player.getHand().showHand();
                                //output the first total, and if there is an ace then output the second total
                                System.out.println("Total: " + player.getHand().getHandTotal());

                                //output the second total if there is at least one ace in the hand
                                if (player.getHand().getHasAce() && player.getHand().getHandTotal() != player.getHand().getSecondHandTotal()) {
                                    System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                                }
                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                if (player.getHand().getHandTotal() > dealer.getHand().getHandTotal()) {
                                    //subtract dealer's current bet amount from dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Dealer.getCurrentBetAmount());
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());
                                    System.out.println("You win this hand!");

                                } else if (player.getHand().getHandTotal() < dealer.getHand().getHandTotal()) {
                                    //add dealer's current bet amount to dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                    System.out.println("You lose this hand!");

                                } else {
                                    System.out.println("Push!");

                                }
                            }
                        }
                        if (newHandOneAskedToHit == true) {
                            if (!newHandOne.isBust() && !dealer.getHand().isBust()) {
                                //output hand information again
                                System.out.println("Your cards are: ");
                                newHandOne.showHand();
                                //output the first total, and if there is an ace then output the second total
                                System.out.println("Total: " + newHandOne.getHandTotal());

                                //output the second total if there is at least one ace in the hand
                                if (newHandOne.getHasAce() && newHandOne.getHandTotal() != newHandOne.getSecondHandTotal()) {
                                    System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                                }
                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                if (newHandOne.getHandTotal() > dealer.getHand().getHandTotal()) {
                                    //subtract dealer's current bet amount from dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Dealer.getCurrentBetAmount());
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());
                                    System.out.println("You win!");

                                } else if (newHandOne.getHandTotal() < dealer.getHand().getHandTotal()) {
                                    //add dealer's current bet amount to dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                    System.out.println("You lose!");

                                } else {
                                    System.out.println("Push!");

                                }
                            }
                        }
                        if (newHandTwoAskedToHit == true) {
                            if (!newHandTwo.isBust() && !dealer.getHand().isBust()) {
                                //output hand information again
                                System.out.println("Your cards are: ");
                                newHandTwo.showHand();
                                //output the first total, and if there is an ace then output the second total
                                System.out.println("Total: " + newHandTwo.getHandTotal());

                                //output the second total if there is at least one ace in the hand
                                if (newHandTwo.getHasAce() && newHandTwo.getHandTotal() != newHandTwo.getSecondHandTotal()) {
                                    System.out.println("Second total: " + newHandTwo.getSecondHandTotal());
                                }
                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                if (newHandTwo.getHandTotal() > dealer.getHand().getHandTotal()) {
                                    //subtract dealer's current bet amount from dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Dealer.getCurrentBetAmount());
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());
                                    System.out.println("You win!");

                                } else if (newHandTwo.getHandTotal() < dealer.getHand().getHandTotal()) {
                                    //add dealer's current bet amount to dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                    System.out.println("You lose!");

                                } else {
                                    System.out.println("Push!");

                                }
                            }
                        }
                        if (newHandThreeAskedToHit == true) {
                            if (!newHandThree.isBust() && !dealer.getHand().isBust()) {
                                //output hand information again
                                System.out.println("Your cards are: ");
                                newHandThree.showHand();
                                //output the first total, and if there is an ace then output the second total
                                System.out.println("Total: " + newHandThree.getHandTotal());

                                //output the second total if there is at least one ace in the hand
                                if (newHandThree.getHasAce() && newHandThree.getHandTotal() != newHandThree.getSecondHandTotal()) {
                                    System.out.println("Second total: " + newHandThree.getSecondHandTotal());
                                }
                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                if (newHandThree.getHandTotal() > dealer.getHand().getHandTotal()) {
                                    //subtract dealer's current bet amount from dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Dealer.getCurrentBetAmount());
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());
                                    System.out.println("You win!");

                                } else if (newHandThree.getHandTotal() < dealer.getHand().getHandTotal()) {
                                    //add dealer's current bet amount to dealer's current total cash amount
                                    dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                    //add player's current bet amount to player's current total cash amount
                                    player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                    System.out.println("You lose!");

                                } else {
                                    System.out.println("Push!");

                                }
                            }
                        }


                        player.getHand().resetHand();
                        dealer.getHand().resetHand();
                        activeHands = 0;

                        break; //break out of while loop for split function

                    }
                }

                if (player.isPlayerAskedToSplit()) { //if player split the hand, after determining the winner of each hand, go back to the beginning
                    player.setAskedToSplit(false);
                    continue;
                }

                //check to see if player can double down


                if (player.getHand().getHasDoubleDown()) { //if player's hand is equal to 10 or 11 then player can double down
                    player.promptDoubleDown(); //ask if player wants to double down
                    if (player.isPlayerDoubledDown()) { //if player entered yes for double down
                        player.getHand().hit();
                        player.getHand().getTotal();
                        System.out.println("Your card's are: ");
                        player.getHand().showHand();
                        System.out.println("Total: " + player.getHand().getHandTotal());
                        if (player.getHand().getHasAce()) {
                            System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                            player.getHand().setHandTotal(player.getHand().getSecondHandTotal());
                        }
                        Player.setCurrentBetAmount(Player.getCurrentBetAmount() * 2); //if player decides to double down then double player's current bet amount
                        System.out.println("Your bet amount has doubled. New bet amount: " + "$" + Player.getCurrentBetAmount());
                    }

                }


                //do not enter this while loop if player chose to double down because player can't hit anymore after doubling down.
                if (!player.isPlayerDoubledDown()) { //if player didnt double down, then enter this while loop.
                    while (true) {
                        //ask if player wants to hit or stay
                        player.hitOrStay();
                        //if player hit, output all of player's cards
                        if (player.isPlayerHit()) { //if player hits
                            player.getHand().hit(); //player hits
                            System.out.println("Your cards are: ");
                            player.getHand().showHand();
                            player.getHand().getTotal();
                            //output the first total, and if there is an ace then output the second total
                            System.out.println("Total: " + player.getHand().getHandTotal());
                            //output the second total if there is at least one ace in the hand
                            if (player.getHand().getHasAce()) {
                                System.out.println("Second total: " + player.getHand().getSecondHandTotal());
                            }
                            System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                            if (player.getHand().isBust()) { //if player busts
                                //subtract current bet amount from total cash amount
                                player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                                //add current bet amount to dealer's total cash amount
                                dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                                System.out.println("You have busted! You lose this hand.");
                                //output the current total cash amount
                                System.out.println("Total cash amount: " + player.getTotalCashAmount());
                                //output the number of cards left in the deck
                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                                break;

                            } else { //if player didn't bust

                            }


                        } else { //if player stays and player has an ace, set the hand total to equal second hand total
                            if (player.getHand().getHasAce()) {
                                player.getHand().setHandTotal(player.getHand().getSecondHandTotal());
                            }
                            break;
                        }
                    }
                }

                pressSpaceToContinue();


                //dealers turn to hit or stay
                //dealer has to hit until 17 or more. dealer also has to hit on soft 17 (ace and 6)

                if (player.getHand().isBust() == false) { //if player didn't bust then continue with dealer's turn
                    //first, show both of dealer's first two cards
                    System.out.println("Dealer's cards are: ");
                    dealer.getHand().showHand();
                    //output dealer's hand total
                    System.out.println("Dealer total: " + dealer.getHand().getHandTotal());
                    //if there is an ace output dealer's second hand total
                    if (dealer.getHand().getHasAce()) {
                        System.out.println("Dealer second total: " + dealer.getHand().getSecondHandTotal());
                    }
                    System.out.println("Cards left in deck: " + Deck.getCardsLeft());

                    pressSpaceToContinue();


                    if (!dealer.isHitUntilBust()) { //if cheat code #4 is not activated
                        while (true) {
                            while (dealer.getHand().getHandTotal() < 17 && dealer.getHand().getSecondHandTotal() <= 17) { //dealer has to hit on soft 17. if hand total is less than 17 and second hand total is less than or equal to 17, dealer has to hit. if second hand total is equal to 17 then that means dealer has an ace and 6 (soft 17)
                                dealer.hit();
                                System.out.println("Dealer's cards are: ");
                                dealer.getHand().showHand();
                                dealer.getHand().getTotal();
                                //output dealer's hand total
                                System.out.println("Dealer total: " + dealer.getHand().getHandTotal());
                                //output second total if there is at least one ace in the hand
                                if (dealer.getHand().getHasAce()) {
                                    System.out.println("Dealer second total: " + dealer.getHand().getSecondHandTotal());
                                }
                                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
                            }
                            //after dealer has 17 or more, check to see if dealer bust or not
                            if (dealer.getHand().isBust()) {
                                System.out.println("Dealer busted! You win");
                                //subtract dealer's current bet amount from dealer's current total cash amount
                                dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Dealer.getCurrentBetAmount());
                                //add player's current bet amount to player's current total cash amount
                                player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());
                                break;

                            } else { //if dealer didn't bust
                                if (dealer.getHand().getHasAce()) { //if dealer has ace and second total didnt go over 21
                                    dealer.getHand().setHandTotal(dealer.getHand().getSecondHandTotal()); //set dealer hand total to equal dealer second hand total
                                }
                                break; //break out of while(true) to determine winner of the hand
                            }
                        }
                    } else {
                        dealerHitUntilBust();
                        dealer.setHitUntilBust(false);
                        System.out.println("Dealer busted! You win");
                        //subtract dealer's current bet amount from dealer's current total cash amount
                        dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Dealer.getCurrentBetAmount());
                        //add player's current bet amount to player's current total cash amount
                        player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());

                    }
                }

                //determine winner of the hand
                while (player.getHand().isBust() == false && dealer.getHand().isBust() == false) {
                    if (player.getHand().getHandTotal() > dealer.getHand().getHandTotal()) {
                        //subtract dealer's current bet amount from dealer's current total cash amount
                        dealer.setTotalCashAmount(dealer.getTotalCashAmount() - Dealer.getCurrentBetAmount());
                        //add player's current bet amount to player's current total cash amount
                        player.setTotalCashAmount(player.getTotalCashAmount() + Player.getCurrentBetAmount());
                        System.out.println("You win!");
                        break;
                    } else if (player.getHand().getHandTotal() < dealer.getHand().getHandTotal()) {
                        //add dealer's current bet amount to dealer's current total cash amount
                        dealer.setTotalCashAmount(dealer.getTotalCashAmount() + Dealer.getCurrentBetAmount());
                        //add player's current bet amount to player's current total cash amount
                        player.setTotalCashAmount(player.getTotalCashAmount() - Player.getCurrentBetAmount());
                        System.out.println("You lose!");
                        break;
                    } else {
                        System.out.println("Push!");
                        break;
                    }
                }

                //need to reset player and dealer's cards before restarting the round
                player.getHand().resetHand();
                if (player.isPlayerHit()) { //if player hit, then reset playerHit to false
                    player.setPlayerHit(false);
                }
                if (player.isPlayerDoubledDown()) { //if player doubled down, then reset playerDoubledDown to false
                    player.setPlayerDoubledDown(false);
                }

                dealer.getHand().resetHand();
                if (dealer.isPlayerHit()) {
                    dealer.setPlayerHit(false);
                }
                if (dealer.getInsuranceBetIsActive()) {
                    dealer.setInsuranceBetIsActive(false);
                }
                if (Dealer.getInsuranceBetAmount() > 0) {
                    Dealer.setInsuranceBetAmount(0);
                }


            }
            if(quitGame){
                break;
            }

    }



    }

    private static void pressSpaceToContinue(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Press space and then enter to continue...");
            String input = scanner.nextLine();
            if (input.equals(" ")) {
                break;

            }
        }
    }
    public static void changeDealerTotalCash(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Choose an amount for dealer's total cash amount: ");
            boolean hasInt = scanner.hasNextInt();
            if(hasInt){
                dealer.setTotalCashAmount(scanner.nextInt());
                scanner.nextLine();
                break;
            } else{
                System.out.println("You did not enter a number. Please enter a numeric value.");
            }
        }
    }
    public static void dealerHitUntilBust(){
        while (!dealer.getHand().isBust()) {
                dealer.hit();
                System.out.println("Dealer's cards are: ");
                dealer.getHand().showHand();
                dealer.getHand().getTotal();
                //output dealer's hand total
                System.out.println("Dealer total: " + dealer.getHand().getHandTotal());
                //output second total if there is at least one ace in the hand
                if (dealer.getHand().getHasAce()) {
                    System.out.println("Dealer second total: " + dealer.getHand().getSecondHandTotal());
                }
                System.out.println("Cards left in deck: " + Deck.getCardsLeft());
            }
    }
    public static void activateDealerHitUntilBust(){
        dealer.setHitUntilBust(true);
    }
    public static void activateDealerCardVisible(){
        dealer.setCardVisible(true);
    }
    public static int getDealerTotalCash(){
        return dealer.getTotalCashAmount();
    }
    public static boolean promptToPlayAgain() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Do you want to play again? (y/n): ");
            boolean hasInt = scanner.hasNextInt();
            if (hasInt) {
                System.out.println("You entered a number. Please enter either y or n.");
            } else {
                String input = scanner.nextLine();
                if (input.length() > 1) {
                    System.out.println("You did not enter a letter. Please enter either y or n.");

                } else {
                    char validLetter = input.charAt(0);
                    if(validLetter == 'y'){
                        return true;

                    } else if(validLetter == 'n'){
                        return false;
                    } else{
                        System.out.println("You did not enter a valid letter. Please enter either y or n.");
                    }

                }
            }
        }
    }


}


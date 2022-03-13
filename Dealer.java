import java.util.Scanner;

public class Dealer extends Player{
    //fields
    private boolean insuranceBetIsActive;
    private boolean hitUntilBust;
    private boolean cardVisible;


    //constructor method
    public Dealer(){
        super();
        insuranceBetIsActive = false;


    }
    //getter method
    public boolean getInsuranceBetIsActive() {
        return insuranceBetIsActive;
    }

    public boolean isHitUntilBust() {
        return hitUntilBust;
    }

    public boolean isCardVisible() {
        return cardVisible;
    }

    //setter method
    public void setInsuranceBetIsActive(boolean insuranceBetIsActive) {
        this.insuranceBetIsActive = insuranceBetIsActive;
    }

    public void setHitUntilBust(boolean hitUntilBust) {
        this.hitUntilBust = hitUntilBust;
    }

    public void setCardVisible(boolean cardVisible) {
        this.cardVisible = cardVisible;
    }

    //instance method
    public void promptInsurance(){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Dealer is showing an ace. Do you want insurance? (y/n): ");
            boolean hasInt = scanner.hasNextInt();
            if (hasInt) { //user entered a number
                System.out.println("You entered a number. Please enter either y or n.");
                scanner.nextInt(); //clears number input from scanner
                scanner.nextLine(); //clears enter input from scanner
            } else{ //user entered a string
                String input = scanner.nextLine();
                if (input.length() > 1){ //user entered a string that has more than 1 character
                    System.out.println("You did not enter a letter. Please enter either y or n.");
                } else { //user entered a string that has 1 character or less
                    char validLetter = input.charAt(0);
                    if(validLetter == 'y'){ //user entered y
                        insuranceBetIsActive = true;
                        break;
                    } else if(validLetter == 'n'){ //user entered n
                        break;
                    } else{ //user didn't enter y or n
                        System.out.println("You did not enter y or n. Please enter either y or n.");
                    }
                }
            }
        }
    }






}
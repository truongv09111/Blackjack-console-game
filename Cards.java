public class Cards {
    //fields
    private String name;
    private int rank;
    private int secondRank;



    //constructor methods
    public Cards(){
        this.name = "blank";
        this.rank = 0;
        this.secondRank = 0;

    }
    public Cards(String name, int rank, int secondRank){
        this.name = name;
        this.rank = rank;
        this.secondRank = secondRank;
        ;

    }



    //getter methods

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public int getSecondRank(){
        return secondRank;
    }




}

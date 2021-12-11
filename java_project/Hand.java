public class Hand implements Comparable<Hand>{

    int card0, card1, card2;

    /**
     * Constructor for hand object
     * @param card0 - int value representing the 1st card value
     * @param card1 - int value representing the 2nd card value
     * @param card2 - int value representing the 3rd vard value
     */
    public Hand(int card0, int card1, int card2){
        this.card0 = card0;
        this.card1 = card1;
        this.card2 = card2;
    }

    /**
     * To return the values of the cards in array format
     * @return int[] - To return array of the 3 cards
     */
    public int[] getAsIntArray(){
        return new int[]{this.card0, this.card1, this.card2};
    }

    /**
     * To calculate the sum of the cards in hand
     * @return int - sum of the cards
     */
    private int getSum(){
        return card0 + card1 + card2;
    }

    /**
     * To compare the 2 hand objects and idenctiy  the winner
     * If the passed in object is not of type hand then 0 will be returned by default
     * If sum of both the hands are same then match will be tie or if both the hands are above 21
     * If one hand is above 21 and the other is below 21 the hand with sum less then 21 wins
     * If both the values are less then 21 the hands with greated value wins
     * @param Object - object to compare with the current object
     * @return int - int value representing the winning hand
     */
    public int compareTo(Hand h2){

        int thisSum = this.getSum();
        int hand2Sum = h2.getSum();

        if((thisSum > 21 && hand2Sum > 21) || (thisSum < 22 && hand2Sum < 22 && thisSum == hand2Sum)){
            return 0;
        }
        else if(thisSum > 21 && hand2Sum <=21){
            return -1;
        }
        else if(thisSum <= 21 && hand2Sum > 21){
            return 1;
        }
        else if(thisSum < 22 && hand2Sum < 22){
            if(thisSum > hand2Sum){
                return 1;
            }else{
                return -1;
            }
        }
        return 0;
    }
}
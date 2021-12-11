public class DeckOfCards implements RandomGenerator<Hand>{

    /**
     * To get a random value of Hand Objects
     * It generates 3 random values for the 3 hands and creates a Hand Object
     * @return Hand - Randomly generated hand object
     */
    public Hand get(){
        
        int card0 = RNGUtilities.nextInt(1, 14);
        int card1 = RNGUtilities.nextInt(1, 14);
        int card2 = RNGUtilities.nextInt(1, 14);

        return new Hand(card0, card1, card2);
    }
}
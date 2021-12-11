public class BeatabilityEstimator{

    /**
     * The method is used to calcualte beatability estimator of a given value
     * It takes a generic data of type and genereates random values for trails number of times
     * Checks the number of times a random generated value can beat the passed in value
     * @param <Data> - Genertic data type that is comparable to itself
     * @param d - Generic data object to calcualte beatability percentages
     * @param rg - Object of implementation of RandomGenerator that we can use to generate random objects of generic type
     * @param trails - number of times to try to calculate beatability generator
     * @return double - returns a double value indicating the betabiliy estimator
     */
    public static <Data extends Comparable> double estimate(Data d, RandomGenerator<Data> rg, int trails){

        int count = 0, index =0;

        while(index < trails){
            Data next = rg.get();

            if(next.compareTo(d) > 0){
                count++;
            }
            
            index++;
        }
        
        return ((double)count) / (double)trails;
    }
}
package info.leanix.unittest.business;

import info.leanix.unittest.data.SomeDataService;
import java.util.Arrays;

public class BusinessImp {

    private SomeDataService someDataService;
    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {
//       OptionalInt number = Arrays.stream(data).reduce(Integer::sum);
//       return number.orElse(0);
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }
    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for (int value:data) {
            sum += value;
        }
        return sum;
    }
}

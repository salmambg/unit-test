package info.leanix.unittest.business;

import info.leanix.unittest.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{1, 2, 3};
    }
}

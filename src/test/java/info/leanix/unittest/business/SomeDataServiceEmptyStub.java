package info.leanix.unittest.business;

import info.leanix.unittest.data.SomeDataService;

class SomeDataServiceEmptyStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] { };
    }
}

package info.leanix.unittest.business;

import info.leanix.unittest.data.SomeDataService;

class SomeDataServiceOneElementStub implements SomeDataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] { 5 };
    }
}

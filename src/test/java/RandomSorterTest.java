import com.rok.sorter.logic.RandomSorter;
import com.rok.sorter.model.SortResult;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by roman.kulikov on 5/17/2017.
 * All rights reserved =D
 */
public class RandomSorterTest {

    @Test
    public void testSorter(){
        Double[] numbers = new Double[]{9., 15., 156., -4., -0.9, 1.};
        RandomSorter sorter = new RandomSorter(numbers);

        SortResult sort = sorter.sort();
        String sortedArray = sort.getSortedArray();

        Assert.assertEquals("[-4.0, -0.9, 1.0, 9.0, 15.0, 156.0]", sortedArray);
    }
}

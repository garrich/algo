package arrays;

import org.junit.jupiter.api.Test;
import util.ResourceLoad;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


class MaximumErasureValueTest {

    @Test
    public void test1(){
        assertThat(new MaximumErasureValue().maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5})).isEqualTo(8);
    }

    @Test
    public void test2(){
        assertThat(new MaximumErasureValue().maximumUniqueSubarray(new int[]{4,2,4,5,6})).isEqualTo(17  );
    }
    @Test
    public void test3(){
        assertThat(new MaximumErasureValue().maximumUniqueSubarray(new int[]{})).isEqualTo(0);
    }
    @Test
    public void test4(){
        String tmp = ResourceLoad.asString("MaximumErasureValue/input.txt");
        String[] numsStr = tmp.split(",");
        int[] ints = Arrays.stream(numsStr).mapToInt(Integer::parseInt).toArray();
        assertThat(new MaximumErasureValue().maximumUniqueSubarray(ints)).isEqualTo(2171967);
    }
}
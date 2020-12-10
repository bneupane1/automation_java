import org.junit.Assert;
import org.junit.Test;

public class TestCalculator {

    @Test
    public void addTesting(){
        Calculator cal=new Calculator();
        //int result=cal.add(2,3);
        //System.out.println(result);
        Assert.assertEquals(6,cal.add(2,3));

    }

    @Test
    public void subTesting(){
        Calculator cal=new Calculator();
        //int result=cal.add(2,3);
        //System.out.println(result);
        Assert.assertEquals(1,cal.sub(4,3)); //assert.assertequals helps in verification or comparison by providing the expected value
    Assert.assertFalse(false);
    }

    @Test
    public void multiplyTesting(){
        Calculator cal = new Calculator();
        Assert.assertEquals(12,cal.multiply(4,3)); //here i have provided the  correct expected value

    }

    @Test
    public void divTesting(){
        Calculator cal = new Calculator();
        Assert.assertEquals(14,cal.div(4,2)); //here i have provided wrong expected value so the test case will fail
    }
}

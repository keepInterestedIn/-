/**
 * 数米问题主体测试
 *
 * @author Wang
 */
public class Main {

    /**
     * 主体测试程序
     *
     * @param args 输入参数
     */
    public static void main(String[] args) {
        long length = (long)1.2e8;
        double[] riceArray = createArray(length);
        //Counter counter = new FatherCounter();
        Counter counter = new FamilyCounter();
        //Counter counter = new TogetherCounter();
        long startTime = System.currentTimeMillis();
        long value = counter.count(riceArray);
        long endTime = System.currentTimeMillis();
        System.out.println("消耗时间（毫秒）：" + (endTime - startTime));
        System.out.println("结果为：" + value);
    }

    /**
     * 创建约定长度的数组，其中随机生成若干个1和若干个0
     *
     * @param length 约定长度
     * @return 数组
     */
    private static double[] createArray(long length) {
        double[] array = new double[(int)length];
        for (int i = 0; i < length; i++) {
            long num = Math.round(Math.random());
            array[i] = num;
        }
        return array;
    }
}

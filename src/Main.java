/**
 * 数米问题主体测试
 * 问题：
 * 1.为什么要用double作为数组类型，都是1或者0的话用int不也可以么，还能节约空间
 * 2.FamilyCounter类中total >= 0.125e8这个判断的理由是什么
 * 3.后面两种多线程写法，就本机来看第一种也就是普通的写法块，forl-work写法慢，是因为机器配置因素么
 * 4.第一种多线程写法会出现运行完成后不能自动中断
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
        //Counter counter = new FamilyCounter();
        Counter counter = new TogetherCounter();
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

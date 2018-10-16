/**
 * 计算接口
 *
 * 问题场景：数一亿粒米需要多长时间
 *
 * @author Wang
 */
public interface Counter {

    /**
     * 计算数组中有多少为1的数字
     *
     * @param riceArray 目标数组
     * @return  数组中为1的数目
     */
    long count(double[] riceArray);
}

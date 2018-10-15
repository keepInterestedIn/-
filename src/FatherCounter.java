/**
 *
 */
public class FatherCounter implements Counter {


    /**
     * 计算数组中有多少为1的数字
     *
     * @param riceArray 目标数组
     * @return 数组中为1的数目
     */
    @Override
    public long count(double[] riceArray) {
        long total = 0;
        for (int i = 0; i < riceArray.length; i++) {
            if (riceArray[i] == 1) {
                total++;
            }

            if (i >= 1e8) {
                break;
            }
        }

        return total;
    }
}

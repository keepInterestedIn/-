import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FamilyCounter implements Counter{
    private int familyMember;
    private ExecutorService pool;

    public FamilyCounter() {
        this.familyMember = 8;
        this.pool = Executors.newFixedThreadPool(this.familyMember);
    }

    private static class CounterRiceTask implements Callable<Long> {
        private double[] riceArray;
        private int from;
        private int to;
        public CounterRiceTask(double[] riceArray, int from, int to) {

        }

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Long call() throws Exception {
            return null;
        }
    }


    /**
     * 计算数组中有多少为1的数字
     *
     * @param riceArray 目标数组
     * @return 数组中为1的数目
     */
    @Override
    public long count(double[] riceArray) {
        return 0;
    }
}

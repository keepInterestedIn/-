import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * fork-work方式数米
 *
 * @author Wang
 */
public class TogetherCounter implements Counter {
    private ForkJoinPool pool;
    private static final int THERSHOLD = 7660;

    TogetherCounter() {
        int familyNumber = 4;
        this.pool = new ForkJoinPool(familyNumber);
    }

    private static class CounterRiceTask extends RecursiveTask<Long> {
        private double[] riceArray;
        private int from;
        private int to;

        CounterRiceTask(double[] riceArray, int from, int to) {
            this.riceArray = riceArray;
            this.from = from;
            this.to = to;
        }

        /**
         * The main computation performed by this task.
         *
         * @return the result of the computation
         */
        @Override
        protected Long compute() {
            long total = 0;
            if (to - from <= THERSHOLD) {
                for (int i = from; i < to; i++) {
                    if (riceArray[i] == 1) {
                        total++;
                    }
                }
                return total;
            } else {
                int mid = (from + to) / 2;
                CounterRiceTask left = new CounterRiceTask(riceArray, from, mid);
                left.fork();
                CounterRiceTask right = new CounterRiceTask(riceArray, mid, to);
                right.fork();
                return left.join() + right.join();
            }
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
        return pool.invoke(new CounterRiceTask(riceArray, 0, riceArray.length - 1));
    }
}

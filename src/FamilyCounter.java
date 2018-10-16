import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 多线程同时数米
 *
 * @author Wang
 */
public class FamilyCounter implements Counter {
    private int familyMember;
    private ExecutorService pool;

    FamilyCounter() {
        //由于本机电脑上面CPU是四核处理器，因此为4；经过测试设置为8的时候没有4运行速度快
        this.familyMember = 4;
        this.pool = Executors.newFixedThreadPool(this.familyMember);
    }

    private static class CounterRiceTask implements Callable<Long> {
        private double[] riceArray;
        private int from;
        private int to;

        CounterRiceTask(double[] riceArray, int from, int to) {
            this.riceArray = riceArray;
            this.from = from;
            this.to = to;
        }

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Long call() throws Exception {
            long total = 0;
            for (int i = from; i < to; i++) {
                if (riceArray[i] == 1) {
                    total++;
                }
                if (total >= 0.125e8) {
                    break;
                }
            }
            return total;
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
        long total = 0;
        List<Future<Long>> results = new ArrayList<>();
        int part = riceArray.length / this.familyMember;
        for (int i = 0; i < this.familyMember; i++) {
            results.add(pool.submit(new CounterRiceTask(riceArray, i * part, (i + 1) * part)));
        }
        for (Future<Long> j : results) {
            try {
                total += j.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return total;
    }
}

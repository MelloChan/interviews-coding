package 剑指offer;

/**
 * Created by MelloChan on 2017/10/16.
 * 单例模式总结
 */
public class No02 {
}

/**
 * 缺点:非线程安全
 */
class Singleton01 {
    private static Singleton01 singleton01;

    private Singleton01() {
    }

    public static Singleton01 getInstance() {
        if (singleton01 == null) {
            singleton01 = new Singleton01();
        }
        return singleton01;
    }
}

/**
 * 懒汉模式[方法锁]
 * 缺点:性能问题
 */
class Singleton02 {
    private static Singleton02 singleton02;

    private Singleton02() {
    }

    public synchronized static Singleton02 getInstance() {
        if (singleton02 == null) {
            singleton02 = new Singleton02();
        }
        return singleton02;
    }
}

/**
 * 懒汉模式[双重锁+ volatile禁止重排序]
 * 没有添加volatile的情况下,存在失效值的可能性[],即便加了volatile,无竞争同步的执行速度还是很慢
 * Java并发编程实战推荐延长初始化占位类模式 286p
 */
class Singleton03 {
    // volatile 保证可见性[Java内存模型]与禁止重排序 不保证原子性
    private volatile static Singleton03 singleton03;

    private Singleton03() {
    }

    public static Singleton03 getInstance() {
        if (singleton03 == null) {
            synchronized (Singleton02.class) {
                if (singleton03 == null) {
                    singleton03 = new Singleton03();
                }
            }
        }
        return singleton03;
    }
}

/**
 * 饿汉模式
 */
class Singleton04 {
    private static Singleton04 singleton04 = new Singleton04();

    private Singleton04() {
    }

    public static Singleton04 getInstance() {
        return singleton04;
    }
}

/**
 * 饿汉模式+静态内部类
 * Java并发编程实战推荐的单例模式
 */
class Singleton05 {
    private static class Singleton {
        public static Singleton05 singleton05 = new Singleton05();
    }

    public static Singleton05 getInstance() {
        return Singleton.singleton05;
    }
}

/**
 * 枚举形式的单例 绝对的安全性与简洁性 同时防止多次实例化
 * effective java推荐的方法
 */
enum Singleton06 {
    INSTANCE;

    public void leaveTheBuilding() {
        //TODO
    }
}


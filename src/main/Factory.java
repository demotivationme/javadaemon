package main;
import daemons.Daemon;
import mainabstract.AbstractTask;

import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.concurrent.ThreadFactory;

/**
 * Thread factory model
 */
class Factory implements ThreadFactory {
    private String       name;
    private HashMap<String,Thread> ThreadMap = new HashMap<String, Thread>();

    private Daemon daemon = null;

    public Factory() {
    }

    /**
     *
     * @param runnable
     * @return
     */
    @Override
    public Thread newThread(Runnable runnable) {
        Thread t = new Thread(runnable, this.name);
        ThreadMap.put(this.name, t);
        System.out.println("THREAD START :: " + ThreadMap.get(this.name).getName());
        return t;
    }

    /**
     *
     * @param args
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     */
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {

        Thread thread;
        Factory factory = new Factory();
        System.out.printf("Starting the Threads\n\n");

        // Get daemons list

        List<Class<?>> classes = ClassFinder.find("daemons");

        // Start work daemons

        for (int i = 0; i < classes.size(); i++) {
            TaskManager task = new TaskManager(classes.get(i).getSimpleName(), (AbstractTask) classes.get(i).newInstance());
            factory.name = classes.get(i).getSimpleName();
            thread = factory.newThread(task);
            thread.start();
        }

        // Start stats

        DaemonStatus threadStat = new DaemonStatus(factory);
        threadStat.run();

    }

    /**
     * Daemon for monitoring threads statuses
     */
    public static class DaemonStatus implements Runnable {
        Factory factory;

        public DaemonStatus(Factory f){
            this.factory = f;
        }

        @Override
        public void run() {
            while (true) {
                for (String key : factory.ThreadMap.keySet()) {
                    System.out.println(" DAEMON NAME::"+factory.ThreadMap.get(key).getName()+
                                       " DAEMON STATE::" + factory.ThreadMap.get(key).getState()+
                                       " DAEMON ID::" + factory.ThreadMap.get(key).getId()+
                                       " DAEMON TIME::" + new Date().toString());
                }
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
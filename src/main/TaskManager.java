package main;

import mainabstract.AbstractTask;

import java.lang.reflect.InvocationTargetException;

/**
 * Tasks manager model
 */
public class TaskManager implements Runnable{
    private String name;
    private Boolean terminate = false;
    private AbstractTask task;
    private Boolean demonize = false;
    public TaskManager(String name, AbstractTask cls) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        this.name = name;
        this.task = cls;
        cls.setName(name);
    }
    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()) {
            /**
             * Daemonize task
             */
            this.task.init();

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

    }
    public void terminate(){
        this.terminate = true;
    }
}

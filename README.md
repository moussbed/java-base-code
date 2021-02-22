# java-base-code

- #### **Creating Dates and Times**

  - **LocalDate** Contains just a date—no time and no time zone. A good example of LocalDate is your birthday this year. It is your birthday for a full day, regardless of what time it is.
  - **LocalTime** Contains just a time—no date and no time zone. A good example of LocalTime is midnight. It is midnight at the same time every day.
  - **LocalDateTime** Contains both a date and time but no time zone. A good example of LocalDateTime is “the stroke of midnight on New Year’s Eve.” Midnight on January 2 isn’t nearly as special, making the date relatively unimportant, and clearly an hour after midnight isn’t as special either.
  - **ZonedDateTime** Contains a date, time, and time zone. A good example of ZonedDateTime is “a conference call at 9:00 a.m. EST.” If you live in California, you’ll have to get up really early since the call is at 6:00 a.m. local time!

- #### **Concurrency**

- A **thread** is the smallest unit of execution that can be scheduled by the operating system. 
- A **process** is a group of associated threads that execute in the same, shared environment. 
- A **single-threaded process** is one contains exactly one thread, 
- whereas a **multi-threaded** process is one contains one or more threads.
- By **shared environment**, we mean that the threads in the same process share the same memory space and can communicate directly with one another.
- A **task** is a single unit of work performed by a thread
- Un thread peut effectuer plusieurs tasks indépendantes, mais une seule tâche à la fois.
              ![alt text](https://github.com/moussbed/java-base-code/blob/main/process-model.png?raw=true)

    - The process model shows a single process with three threads. It also shows how they are mapped to an arbitrary number of n CPUs available within the system.
    
- ##### Understanding Thread Concurrency  

  We mentioned that multi-threaded processing allows operating systems to execute threads 
  at the same time. The property of executing multiple threads and processes at the same time is referred to as concurrency. 
  Of course, with a single-core CPU system, only one task is actually executing at a given time. Even in multi-core or multi-CPU systems,
  there are often far more threads than CPU processors available. How does the system decide what to execute when there are multiple threads available?
  Operating systems use a thread scheduler to determine which threads should be currently executing, 
  as shown in Figure 7.1. For example, a thread scheduler may employ a round-robin schedule in which each available thread receives an equal number of CPU cycles with which to execute,
  with threads visited in a circular order. If there are 10 available threads, they might each get 100 milliseconds in which to execute,
  with the process returning to the first thread after the last thread has executed.
  When a thread’s allotted time is complete but the thread has not finished processing, 
  a context switch occurs. A context switch is the process of storing a thread’s current state and later restoring the state of the thread to continue execution.
  Be aware that there is often a cost associated with a context switch by way of lost time saving and reloading a thread’s state.
  Finally, a thread can interrupt or supersede another thread if it has a higher thread priority than the other thread. 
  A thread priority is a numeric value associated with a thread that is taken into consideration by the thread scheduler when determining which threads should currently be executing. 
  In Java, thread priorities are specified as integer values. The Thread class includes three important static constants, 
  as shown in Table 7.1. By default, user-defined threads receive a thread priority value of Thread.NORM_PRIORITY. 
  If you have a thread that must be executed right away, you can increase this value to 6 or higher or use the Thread.MAX_PRIORITY value. 
  If two threads have the same priority, the thread scheduler will arbitrarily choose the one to process first in most situations.
                                                                                                                                                                                                                                                              
 
- ##### The importance of Thread scheduling
  Even though multi-core CPUs are quite common these days, single-core CPUs were the standard in personal computing for many decades.
  During this time, operating systems developed complex thread-scheduling and context-switching algorithms that allowed users to execute dozens or even hundreds of threads on a single-core CPU system. 
  These scheduling algorithms allowed users to experience the illusion that multiple tasks were being performed at the exact same time within a single-CPU system. 
  For example, a user could listen to music while writing a paper and receive notifications for new messages.
  Since the number of threads often far outweighs the number of processors available even in multi-core systems, these thread-scheduling algorithms are still employed in operating systems today.  
  
- #### Introducing Runnable  
  
  - The Runnable interface is commonly used to define the work a thread will execute, separate from the main application thread. 
  - The following lambda expressions each rely on the Runnable interface:
    ```java
    
      @FunctionalInterface public interface Runnable { 
          void run();
      }
    
      () -> System.out.println("Hello World") 
      () -> {int i=10; i++;}
      () -> {return;}
      () -> {}
    ```
  - Creating Runnable Classes
  
    Even though Runnable was made a functional interface in Java 8, the interface Runnable has existed since the very first version of Java. It was, and still is, commonly used to define a thread task by creating a class that implements the Runnable interface, as shown in the following code:
  
      ```java
  
       public class CalculateAverage implements Runnable { 
          public void run() {
          // Define work here 
        }
       }
  
     ```
    
    It is also useful if you need to pass information to your Runnable object to be used by the run() method, 
    such as in the following class constructor:
    
     ```java
         public class CalculateAverages implements Runnable { 
           private double[] scores;
    
           public CalculateAverages(double[] scores) {
              this.scores = scores; 
           }
           public void run() {
             // Define work here that uses the scores object
           } 
         }
     ```
  
  - #### Creating a Thread
    The simplest way to execute a thread is by using the java.lang.Thread class, or Thread for short. 
    Executing a task with Thread is a two-step process. 
    First you define the Thread with the corresponding task to be done. 
    Then you start the task by using the Thread.start() method.  
    **Remember that order of thread execution is not often guaranteed.** 
    
    * Defining the task, or work, that a Thread instance will execute can be done two ways in Java:
    
         * Provide a Runnable object or lambda expression to the Thread constructor
            ```java
           
              public class PrintData implements Runnable { 
                public void run() {
                  for(int i=0; i<3; i++) 
                   System.out.println("Printing record: "+i);
                }
                public static void main(String[] args) {
                    (new Thread(new PrintData())).start();
                } 
              }
           
            ```
         * Create a class that extends Thread and overrides the run() method.
           ```java
           
            public class ReadInventoryThread extends Thread { 
              public void run() {
                System.out.println("Printing zoo inventory"); 
              }
              public static void main(String[] args) {
                  (new ReadInventoryThread()).start();
              } 
            }

           ```
        
    * In general, you should extend the Thread class only under very specific circumstances, 
      such as when you are creating your own priority-based thread. 
      In most situations, you should implement the Runnable interface rather than extend the Thread class.
      
  - #### The difference between extending the Thread class and implementing Runnable
  
     * The following are some reasons to prefer one method over the other in Java:
         
         * If you need to define your own Thread rules upon which multiple tasks will rely, such as a priority Thread, extending Thread may be preferable. 
         * Since Java doesn't support multiple inheritance, extending Thread does not allow you to extend any other class, whereas implementing Runnable lets you extend another class.
         * Implementing Runnable is often a better object-oriented design practice since it sep- arates the task being performed from the Thread object performing it.
         * Implementing Runnable allows the class to be used by numerous Concurrency API classes.
         
         
  - #### Creating Threads with the ExecutorService
  
     * With the announcement of the Concurrency API, Java introduced the ExecutorService, which creates and manages threads for you.
     * You first obtain an instance of an ExecutorService interface, and then you send the service tasks to be processed.
     * The framework includes numerous useful features, such as thread pooling and scheduling, which would be cumbersome for you to implement in every project.    
     * Therefore, it is recommended that you use this framework anytime you need to create and execute a separate task, even if you need only a single thread.
     
     * ##### Introducing the Single-Thread Executor
          * Since ExecutorService is an interface, how do you obtain an instance of it? The Concurrency API includes the Executors factory class that can be used to create instances of the ExecutorService object.
     * For example see the code in the class SingleThreadExecutor
     * With a single-thread executor, results are guaranteed to be executed in the order in which they are added to the executor service.
     
     * #### Executing multiple Tasks
          * In the previous example, it is possible that all three tasks were submitted for execution before the first task was even started. In this case, the single thread executor will queue the tasks and wait until the previous task completes before executing the next task.
     
     * #### Shutting Down a Thread Executor
          * Once you have finished using a thread executor, it is important that you call the shutdown() method.
          * A thread executor creates a non-daemon thread on the first task that is executed, so failing to call shutdown() will result in your application never terminating.
          * The shutdown process for a thread executor involves first rejecting any new tasks submitted to the thread executor while continuing to execute any previously submitted tasks.
          * During this time, calling isShutdown() will return true, while isTerminated() will return false
          * If a new task is submitted to the thread executor while it is shutting down, a RejectedExecutionException will be thrown. 
          * Once all active tasks have been completed, isShutdown() and isTerminated() will both return true.
                         
         ![alt text](https://github.com/moussbed/java-base-code/blob/main/executor-life-cycle.png?raw=true)
 
         * What if you want to cancel all running and upcoming tasks? The ExecutorService provides a method called shutdownNow(), which attempts to stop all running tasks and discards any that have not been started yet 
         * Lastly, shutdownNow() returns a List<Runnable> of tasks that were submitted to the thread executor but that were never started.
     
     * #### Submitting Tasks
         * You can submit tasks to an ExecutorService instance multiple ways. The first method we presented, execute(), is inherited from the Executor interface, which the ExecutorService interface extends.    
         * The execute() method takes a Runnable lambda expression or instance and completes the task asynchronously. 
         * Because the return type of the method is void, it does not tell us anything about the result of the task
         * It is considered a “fire-and-forget” method, as once it is submitted, the results are not directly available to the calling thread.
         * Fortunately, the writers of the Java added submit() methods to the ExecutorService interface, which, like execute(), can be used to complete tasks asynchronously. 
         * Unlike execute(), though, submit() returns a Future object that can be used to determine if the task is complete.
         
           ![alt text](https://github.com/moussbed/java-base-code/blob/main/executorService-methods.png?raw=true)
    
     * #### Submitting Task Collections : invokeAll() and invokeAny()
         * Both of these methods take a Collection object containing a list of tasks to execute. Both of these methods also execute synchronously.
         * By synchronous, we mean that unlike the other methods used to submit tasks to a thread executor, these methods will wait until the results are available before returning control to the enclosing program.
         * The invokeAll() method executes all tasks in a provided collection and returns a List of ordered Future objects, with one Future object corresponding to each submitted task, in the order they were in the original collection. Even though Future.isDone() returns true for each element in the returned List, a task could have completed normally or thrown an exception.
         * The invokeAny() method executes a collection of tasks and returns the result of one of the tasks that successfully completes execution, cancelling all unfinished tasks. While the first task to finish is often returned, this behavior is not guaranteed, as any completed task can be returned by this method.
     * #### Waiting for Results
    
        * How do we know when a task submitted to an ExecutorService is complete?
        * the submit() method returns a java.util.concurrent. Future<V> object, or Future<V> for short, that can be used to determine this result:
           ```java
               Future<?> future = service.submit(() -> System.out.println("Hello Zoo"));
            ```
            ![alt text](https://github.com/moussbed/java-base-code/blob/main/future-methods.png?raw=true)
            
        * See example in class : ResultForThreadRunnable
        * What is the return value of this task? As Future<V> is a generic class, the type V
          is determined by the return type of the Runnable method. Since the return type of Runnable.run() is void, the get() method always returns null. In the next section, you will see that there is another task class compatible with ExecutorService that supports other return types.    
            
 - #### Introducing Callable
     * When the Concurrency API was released in Java 5, the new java.util.concurrent. Callable interface was added, or Callable for short, which is similar to Runnable except that its call() method returns a value and can throw a checked exception.
     * The ExecutorService includes an overloaded version of the submit() method that takes a Callable object and returns a generic Future<T> object.
     * See example code in the class : ResultForThreadCallable
     
 - #### Waiting for All Tasks to Finish
     * After submitting a set of tasks to a thread executor, it is common to wait for the results. As you saw in the previous sections, one solution is to call get() on each Future object returned by the submit() method.
     * If we don’t need the results of the tasks and are finished using our thread executor, there is a simpler approach.
     * First, we shut down the thread executor using the shutdown() method. Next, we use the awaitTermination(long timeout, TimeUnit unit) method available for all thread executors
     * The method waits the specified time to complete all tasks, returning sooner if all tasks finish or an InterruptedException is detected. You can see an example of this in the following code snippet:
     ```java
       ExecutorService service = null; try {
       service = Executors.newSingleThreadExecutor();
       // Add tasks to the thread executor
       ...
       } finally {
       if(service != null) service.shutdown(); 
       }
       if(service != null) {
         service.awaitTermination(1, TimeUnit.MINUTES);
       // Check whether all tasks are finished 
        if(service.isTerminated())
           System.out.println("All tasks finished");
        else
          System.out.println("At least one task is still running"); 
       }
   
     ```
   * In this example, we submit a number of tasks to the thread executor and then shut down the thread executor and wait up to one minute for the results. Notice that we can call isTerminated() after the awaitTermination() method finishes to confirm that all tasks are actually finished.

 - #### Scheduling Tasks
    * Oftentimes in Java, we need to schedule a task to happen at some future time. We might even need to schedule the task to happen repeatedly, at some set interval. 
    * The ScheduledExecutorService, which is a subinterface of ExecutorService, can be used for just such a task.
    * Like ExecutorService, we obtain an instance of ScheduledExecutorService using a factory method in the Executors class, as shown in the following snippet
      ```java
      ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
      ```
      ![alt text](https://github.com/moussbed/java-base-code/blob/main/scheduledExecutorService-methods.png?raw=true)
    * In practice, these methods are among the most convenient in the Concurrency API, as they perform relatively complex tasks with a single line of code. The delay and period parameters rely on the TimeUnit argument to determine the format of the value, such as seconds or milliseconds.
    * The first two schedule() methods in Table 7.5 take a Callable or Runnable, respectively, perform the task after some delay, and return a ScheduledFuture<V> instance. ScheduledFuture<V> is identical to the Future<V> class, except that it includes a getDelay() method that returns the delay set when the process was created.
    * The following uses the schedule() method with Callable and Runnable tasks:
    ```java
      ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
      Runnable task1 = () -> System.out.println("Hello Zoo"); 
      Callable<String> task2 = () -> "Monkey";
      Future<?> result1 = service.schedule(task1, 10, TimeUnit.SECONDS); 
      Future<?> result2 = service.schedule(task2, 8, TimeUnit.MINUTES);
   
    ```
    * The first task is scheduled 10 seconds in the future, whereas the second task is scheduled 8 minutes in the future.
    * Bien que ces tâches soient planifiées dans le futur, l'exécution réelle peut être retardée. Par exemple, il se peut qu'il n'y ait pas de threads disponibles pour effectuer la tâche, à quel point ils attendront simplement dans la file d'attente. En outre, si ScheduledExecutorService est arrêté au moment où l'heure d'exécution de la tâche planifiée est atteinte, ils seront ignorés. 
    * The scheduleAtFixedRate() is useful for tasks that need to be run at specific intervals, such as checking the health of the animals once a day. 
      Even if it takes two hours to examine an animal on Monday, this doesn’t mean that Tuesday’s exam should start any later.
    * Finally, scheduleAtFixedDelay() is useful for processes that you want to happen repeatedly but whose specific time is unimportant. 
      For example, imagine that we have a zoo cafeteria worker who periodically restocks the salad bar throughout the day. 
      The process can take 20 minutes or more, since it requires the worker to haul a large number of items from the back room.  
      Once the worker has filled the salad bar with fresh food, he doesn’t need to check at some specific time, 
      just after enough time has passed for it to become low on stock again.  
      
    * If you are familiar with creating Cron jobs in Linux to schedule tasks, then you should know that scheduleAtFixedRate() is the closest built-in Java equivalent.  
  
 - #### Increasing Concurrency with Pools
    * All of our examples up until now have been with single-thread executors, which, while interesting, weren’t particularly useful. 
      After all, the name of this chapter is “Concurrency,” and you can’t do a lot of that with a single-thread executor!   
    * We now present three additional factory methods in the Executors class that act on a pool of threads, rather than on a single thread. 
      A thread pool is a group of pre-instantiated reusable threads that are available to perform a set of arbitrary tasks.   
      
    * Table 7.6 includes our two previous single-thread executor methods,  
           ![alt text](https://github.com/moussbed/java-base-code/blob/main/executors-methods.png?raw=true)

    * The newCachedThreadPool() method will create a thread pool of unbounded size, allocating a new thread anytime one is required or all existing threads are busy.
      This is commonly used for pools that require executing many short-lived asynchronous tasks. For long-lived processes, usage of this executor is strongly discouraged, 
      as it could grow to encompass a large number of threads over the application life cycle.  
      
    * The newFixedThreadPool() takes a number of threads and allocates them all upon creation. 
      As long as our number of tasks is less than our number of threads, all tasks will be executed concurrently. If at any point the number of tasks exceeds the number
      of threads in the pool, they will wait in similar manner as you saw with a single-thread executor.
      In fact, calling newFixedThreadPool() with a value of 1 is equivalent to calling newSingleThreadExecutor().  
      
    * The newScheduledThreadPool() is identical to the newFixedThreadPool() method, except that it returns an instance of ScheduledExecutorService and is therefore compatible with scheduling tasks.  
    
    
 - #### Synchronizing Data Access
     * Rappelez-vous que la sécurité des threads est la propriété d'un objet qui garantit une exécution sûre par plusieurs threads en même temps.    
     * Now that we have multiple threads capable of accessing the same objects in memory, we have to make sure to organize our access to this data such that we don’t end up with invalid or unexpected results.
     * Since threads run in a shared environment and memory space, how do we prevent two threads from interfering with each other?
     * See the code example in the SynchronizingDataAccess class
            ![alt text](https://github.com/moussbed/java-base-code/blob/main/LackOfThreadSynchronization.png?raw=true)
     * You can see in Figure 7.3 that both threads read and write the same values, causing one of the two ++sheepCount operations to be lost. 
       Therefore, the increment operator ++ is not thread-safe. As you will see later in this chapter, the unexpected result of two tasks executing at the same time is referred to as a race condition.
 
 - #### Protecting Data with Atomic Classes
     * With the release of the Concurrency API, Java added a new java.util.concurrent.atomic package to help coordinate access to primitive values and object references.
     * In our first SheepManager sample output, the same value, 2, was printed twice, with the highest counter being 9 instead of 10.
     * As we demonstrated in the previous section, the increment operator ++ is not thread-safe. 
     * Furthermore, the reason that it is not thread-safe is that the operation is not atomic, carrying out two tasks, read and write, that can be interrupted by other threads.
     * Atomic is the property of an operation to be carried out as a single unit of execution without any interference by another thread
     * A thread-safe atomic version of the increment operator would be one that performed the read and write of the variable as a single operation, not allowing any other threads to access the variable during the operation.
                          ![alt text](https://github.com/moussbed/java-base-code/blob/main/thread-synchronization-using-atomic-operations.png?raw=true)

     * Table 7.7 lists the atomic classes
                    ![alt text](https://github.com/moussbed/java-base-code/blob/main/atomic-classes.png?raw=true)
     * How do we use an atomic class? Each class includes numerous methods that are equiva- lent to many of the primitive built-in operators that we use on primitives, such as the assignment operator = and the increment operators ++. We describe the common atomic methods
                     ![alt text](https://github.com/moussbed/java-base-code/blob/main/common-atomic-methods.png?raw=true)
     * See the code example the ProtectingDataWithAtomicClasses class
     * How does this implementation differ from our previous examples? When we run this modification, we get varying output, such as the following:
     ```
       2 3 1 4 5 6 7 8 9 10
       1 4 3 5 6 2 7 8 10 9
       1 4 3 2 5 6 7 8 9 10  

     ```
     * Unlike our previous sample output, the numbers 1 through 10 will always be output
     * As you might notice, the results are still not ordered, although we’ll get to that soon enough.
     * The key here is that using the atomic classes ensures that the data is consistent between workers and that no values are lost due to concurrent modifications.
 
 - #### Improving Access with Synchronized Blocks
     * How do we improve the results so that each worker is able to increment and report the results in order?
     * The most common technique is to use a monitor, also called a lock, to synchronize access.
     * Un moniteur est une structure qui prend en charge l'exclusion mutuelle ou la propriété qu'au plus un thread exécute un segment de code particulier à un moment donné. 
     * In Java, any Object can be used as a monitor, along with the synchronized keyword, as shown in the following example:
     ```java
     SheepManager manager = new SheepManager(); 
     synchronized(manager) {
     // Work to be completed by one thread at a time 
      }
   
     ```    
     * This example is referred to as a synchronized block. Each thread that arrives will first check if any threads are in the block.
     * In this manner, a thread “acquires the lock” for the monitor.
     * If the lock is available, a single thread will enter the block, acquiring the lock and preventing all other threads from entering. 
       While the first thread is executing the block, all threads that arrive will attempt to acquire the same lock and wait for first thread to finish. 
       Once a thread finishes executing the block, it will release the lock, allowing one of the waiting threads to proceed.
       
     * We could have used an atomic count variable along with the synchronized block in this example, although it is unnecessary. 
       Since synchronized blocks allow only one thread to enter, we're not gaining any improvement by using an atomic variable if the only time that we access the variable is within a synchronized block.
  
     
 - #### Understanding the Cost of Synchronization    
     * La synchronisation consiste à protéger l'intégrité des données au détriment des performances.
     * Example de code du pattern Singleton dans la classe PatternSingleton
     
 - #### Using Concurrent Collections
 
     * Outre la gestion des threads, l'API Concurrency comprend des interfaces et des classes qui vous aident à coordonner l'accès aux collections sur plusieurs tâches    
     * ##### Introducing Concurrent Collections
         * The first question you might be asking is “Do we really need new concurrent collection classes?”
         * After all, in the previous section you saw that we can use the synchronized keyword on any method or block, so couldn’t we do the same for our existing collection classes?
         * For example, take a look at the following code that accesses a Map using the synchronized keyword:
            ```java
               public class ZooManager {
               private Map<String,Object> foodData = new HashMap<String,Object>();
               public synchronized void put(String key, String value) {
                 foodData.put(key, value); 
               }
               public synchronized Object get(String key) { 
                 return foodData.get(key);
               } 
             }
            ```
         * So then, why use a concurrent collection class? Like using ExecutorService to man- age threads for us, using the concurrent collections is extremely convenient in practice.  
         * In fact, the concurrent collections often include performance enhancements that avoid unnecessary synchronization. 
         * Accessing collections from across multiple threads is so common that the writers of Java thought it would be a good idea to have alternate versions of many of the regular collections classes just for multi-threaded access.
         * The following is an alternate version of our implementation that does not use the synchronized keyword but instead uses a concurrent collection class:
           ```java
             public class ZooManager {
             private Map<String,Object> foodData = new ConcurrentHashMap<String,Object>();
             public void put(String key, String value) { 
               foodData.put(key, value);
             }
             public Object get(String key) {
               return foodData.get(key); }
             }
           ```
     * ##### Understanding Memory Consistency Errors
         * The purpose of the concurrent collection classes is to solve common memory consistency errors.
         * A memory consistency error occurs when two threads have inconsistent views of what should be the same data
         * Conceptually, we want writes on one thread to be available to another thread if it accesses the concurrent collection after the write has occurred.
         * When two threads try to modify the same non-concurrent collection, the JVM may throw a ConcurrentModificationException at runtime. 
         * In fact, it can happen with a single thread. Take a look at the following code snippet:
            ```java
             Map<String, Object> foodData = new HashMap<String, Object>(); 
             foodData.put("penguin", 1);
             foodData.put("flamingo", 2);
             for(String key: foodData.keySet())
                  foodData.remove(key);
           ```
         * This snippet will throw a ConcurrentModificationException at runtime, since the iterator keyset() is not properly updated after the first element is removed.
         * Changing the first line to use a ConcurrentHashMap will prevent the code from throwing an exception at runtime:
           ```java
                        Map<String, Object> foodData = new ConcurrentHashMap<String, Object>(); 
                        foodData.put("penguin", 1);
                        foodData.put("flamingo", 2);
                        for(String key: foodData.keySet())
                             foodData.remove(key);
           ``` 
         * In this code snippet, the iterator created by keySet() is updated as soon as an object is removed from the Map.  
     * ##### Working with Concurrent Classes    
          ![alt text](https://github.com/moussbed/java-base-code/blob/main/concurrent-collection-classes.png?raw=true)
     * #### Understanding Blocking Queues
         * The BlockingQueue is just like a regular Queue, except that it includes methods that will wait a specific amount of time to complete an operation.
         
         ```java
            try {
            BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
            blockingQueue.offer(39);
            blockingQueue.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingQueue.poll());
            System.out.println(blockingQueue.poll(10, TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) { // Handle interruption
            }
       
            try {
            BlockingDeque<Integer> blockingDeque = new LinkedBlockingDeque<>();
            blockingDeque.offer(91);
            blockingDeque.offerFirst(5, 2, TimeUnit.MINUTES); 
            blockingDeque.offerLast(47, 100, TimeUnit.MICROSECONDS); 
            blockingDeque.offer(3, 4, TimeUnit.SECONDS);
            System.out.println(blockingDeque.poll());
            System.out.println(blockingDeque.poll(950, TimeUnit.MILLISECONDS)); 
            System.out.println(blockingDeque.pollFirst(200, TimeUnit.NANOSECONDS)); 
            System.out.println(blockingDeque.pollLast(1, TimeUnit.SECONDS));
            } catch (InterruptedException e) { 
             // Handle interruption
            }

         ```
     * ##### Understanding SkipList Collections
         *  The SkipList classes, ConcurrentSkipListSet and ConcurrentSkipListMap, are concurrent versions of their sorted counterparts, TreeSet and TreeMap, respectively. 
         *  They maintain their elements or keys in the natural ordering of their elements.
         
     * ##### Understanding CopyOnWrite Collections
         * Table 7.9 included two classes, CopyOnWriteArrayList and CopyOnWriteArraySet, that behave a little differently than the other concurrent examples that you have seen.
         * These classes copy all of their elements to a new underlying structure anytime an element is added, modified, or removed from the collection. 
           By a modified element, we mean that the reference in the collection is changed. 
           Modifying the actual contents of the collection will not cause a new structure to be allocated.
         * Although the data is copied to a new underlying structure, our reference to the object does not change. 
           This is particularly useful in multi-threaded environments that need to iterate the collection. 
           Any iterator established prior to a modification will not see the changes, but instead it will iterate over the original elements prior to the modification.  
         * Let’s take a look at how this works with an example:
           ```java
           List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52)); 
           for(Integer item: list) {
             System.out.print(item+" ");
             list.add(9);
            }
           System.out.println(); 
           System.out.println("Size: "+list.size());
           ```  
           
         * When executed as part of a program, this code snippet outputs the following:
          ```
           4 3 52
           Size: 6
          ```
         * Malgré l'ajout d'éléments au tableau tout en l'itérant, seuls les éléments de la collection au moment de la création de la boucle for () ont été accédés.  
         * The CopyOnWrite classes can use a lot of memory, since a new collection structure needs be allocated anytime the collection is modified. 
           They are commonly used in multi-threaded environment situations where reads are far more common than writes.    
     * ##### Obtaining Synchronized Collections
         * Besides the concurrent collection classes that we have covered, the Concurrency API also includes methods for obtaining synchronized versions of existing non-concurrent collection objects. 
         * These methods, defined in the Collections class, contain synchronized methods that operate on the inputted collection and return a reference that is the same type as the underlying collection     
                     ![alt text](https://github.com/moussbed/java-base-code/blob/main/synchronized-collections-methods.png?raw=true)
         * Quand devriez-vous utiliser ces méthodes? Si vous savez au moment de la création que votre objet nécessite une synchronisation, vous devez utiliser l'une des classes de collecte simultanée répertoriées dans le tableau 7.9.
         * D'un autre côté, si vous recevez une collection existante qui n'est pas une classe concurrente et que vous devez y accéder entre plusieurs threads, vous pouvez l'envelopper à l'aide des méthodes du tableau 7.12. 
         * Bien que les méthodes du Tableau 7.12 synchronisent l'accès aux éléments de données, telles que les méthodes get () et set (), elles ne synchronisent pas l'accès sur les itérateurs que vous pouvez créer à partir de la collection synchronisée. 
         * Par conséquent, il est impératif d'utiliser un bloc de synchronisation si vous devez effectuer une itération sur l'une des collections renvoyées dans le tableau 7.12, comme illustré dans l'exemple suivant: 
            ```java
              List<Integer> list = Collections.synchronizedList( new ArrayList<>(Arrays.asList(4,3,52)));
              synchronized(list) { 
                for(int data: list)
                   System.out.print(data+" "); 
              }
            ```            
 - #### Working with Parallel Streams
     * A serial stream is a stream in which the results are ordered, with only one entry being processed at a time.
     * A parallel stream is a stream that is capable of processing results concurrently, using multiple threads.
     * ##### Creating Parallel Streams
         * The first way to create a parallel stream is from an existing stream.
           ```java
           Stream<Integer> stream = Arrays.asList(1,2,3,4,5,6).stream(); 
           Stream<Integer> parallelStream = stream.parallel();
           ```
         * The second way to create a parallel stream is from a Java collection class. 
          ```java
            Stream<Integer> parallelStream2 = Arrays.asList(1,2,3,4,5,6).parallelStream();
          ```  
     * ##### Understanding Performance Improvements
         * Let’s say that you have a task that requires processing 4,000 records, with each record taking a modest 10 milliseconds to complete.
         * The following is a sample implementation that uses Thread.sleep() to simulate processing the data:
         * Example code is in class   PerformanceImprovementsWithStreamParallel
         * Given that there are 4,000 records, and each record takes 10 milliseconds to process, by using a serial stream(), the results will take approximately 40 seconds to complete this task. Each task is completed one at a time:
          ```java
             Tasks completed in: 40.044 seconds

          ```
         * If we use a parallel stream, though, the results can be processed concurrently:
           ```java
             public void processAllData(List<Integer> data) {
               data.parallelStream().map(a -> processRecord(a)).count();
             }
           ```
         * Depending on the number of CPUs available in your environment, the following is a
           possible output of the code using a parallel stream:  
           ```java
              Tasks completed in: 10.542 seconds
           ```
         * You see that using a parallel stream can have a four-fold improvement in the results.
         * Even better, the results scale with the number of processors.
         * Scaling is the property that, as we add more resources such as CPUs, the results gradually improve.
         * Does that mean that all of your streams should be parallel? Not exactly. 
           Parallel streams tend to achieve the most improvement when the number of elements in the stream is significantly large.
           For small streams, the improvement is often limited, as there are some overhead costs to allocating and setting up the parallel processing.
  
     * ##### Avoiding Stateful Operations
         * Side effects can also appear in parallel streams if your lambda expressions are stateful.
         * A stateful lambda expression is one whose result depends on any state that might change dur- ing the execution of a pipeline.
         * On the other hand, a stateless lambda expression is one whose result does not depend on any state that might change during the execution of a pipeline.
         * Let’s take a look an example to see why stateful lambda expressions should be avoided in parallel streams:
           ```java
           List<Integer> data = Collections.synchronizedList(new ArrayList<>()); 
           Arrays.asList(1,2,3,4,5,6).parallelStream()
                                      .map(i -> {data.add(i); return i;}) // AVOID STATEFUL LAMBDA EXPRESSIONS! 
                                      .forEachOrdered(i -> System.out.print(i+" "));
           System.out.println(); 
           for(Integer e: data) {
               System.out.print(e+" "); }
           
           ```
         * The following is a sample generation of this code snippet using a parallel stream:
           ```java
              1 2 3 4 5 6
              2 4 3 5 6 1
           ```
         * The forEachOrdered() method displays the numbers in the stream sequentially, whereas the order of the elements in the data list is completely random.
         * You can see that a stateful lambda expression, which modifies the data list in parallel, produces unpredictable results at runtime.
         * It strongly recommended that you avoid stateful operations when using parallel streams, so as to remove any potential data side effects.  
             
     * ##### Performing Order-Based Tasks
         * Since order is not guaranteed with parallel streams, methods such as findAny() on parallel streams may result in unexpected behavior
         * Let’s take a look at the results of findAny() applied to a serial stream:
            ```java
               System.out.print(Arrays.asList(1,2,3,4,5,6).stream().findAny().get());
            ```
         * This code consistently outputs the first value in the serial stream, 1.
         * With a parallel stream, the JVM can create any number of threads to process the stream.
         * When you call findAny() on a parallel stream, the JVM selects the first thread to finish the task and retrieves its data:
           ```java
               System.out.print(Arrays.asList(1,2,3,4,5,6).parallelStream().findAny().get());
           ```
         * The result is that the output could be 4, 1, or really any value in the stream. You can see that with parallel streams, the results of findAny() are no longer predictable. 
         
     * ##### Using the Three-argument reduce() method
         * Although the one- and two-argument versions of reduce() do support parallel process- ing, it is recommended that you use the three-argument version of reduce() when working with parallel streams.
         * Providing an explicit combiner method allows the JVM to partition the operations in the stream more efficiently.

 - #### Managing Concurrent Processes
     * The Concurrency API includes classes that can be used to coordinate tasks among a group of related threads.
     * In this section, we present two classes with which you should be familiar, CyclicBarrier and ForkJoinPool.
     * For now, let’s start with a code sample without a CyclicBarrier:
       ```java
          package org.mb.base.threads.managing.concurrent.processes;
          
          import java.util.concurrent.ExecutorService;
          import java.util.concurrent.Executors;
          
          public class LionPenManager {
          
              private void removeAnimals() { System.out.println("Removing animals"); }
              private void cleanPen() { System.out.println("Cleaning the pen"); }
              private void addAnimals() { System.out.println("Adding animals"); }
              public void performTask() {
                  removeAnimals();
                  cleanPen();
                  addAnimals();
              }
              public static void main(String[] args) {
          
                  ExecutorService executorService=null;
          
                  try {
          
                      executorService = Executors.newFixedThreadPool(4);
                      LionPenManager lionPenManager = new LionPenManager();
                      for (int i = 0; i < 4; i++) {
                          executorService.submit(lionPenManager::performTask);
                      }
          
                  }finally {
                      if(executorService != null) executorService.shutdown();
                  }
          
                  //  The following is sample output based on this implementation:
          
                  /*
                   Removing animals
                   Removing animals
                   Cleaning the pen
                   Adding animals
                   Removing animals
                   Cleaning the pen
                   Adding animals
                   Removing animals
                   Cleaning the pen
                   Adding animals
                   Cleaning the pen
                   Adding animals
          
                   */
          
              }
          }

       ```
     * Although within a single thread the results are ordered, among multiple workers the output is entirely random.
     * We see that some animals are still being removed while the cage is being cleaned, and other animals are added before the cleaning process is finished.
     * In our conceptual example, this would be quite chaotic and would not lead to a very clean cage.
     * We can improve these results by using the CyclicBarrier class.
       
     * ##### Creating a CyclicBarrier 
       * The CyclicBarrier takes in its constructors a limit value, indicating the number of threads to wait for.
       * As each thread finishes, it calls the await() method on the cyclic barrier.
       * Once the specified number of threads have each called await(), the barrier is released and all threads can continue.
       * The following is a reimplementation of our LionPenManager class that uses CyclicBarrier objects to coordinate access:
        ```java
       package org.mb.base.threads.managing.concurrent.processes;
       
       import java.util.concurrent.BrokenBarrierException;
       import java.util.concurrent.CyclicBarrier;
       import java.util.concurrent.ExecutorService;
       import java.util.concurrent.Executors;
       
       public class LionPenManagerWithCyclicBarrier {
       
           private void removeAnimals() { System.out.println("Removing animals"); }
           private void cleanPen() { System.out.println("Cleaning the pen"); }
           private void addAnimals() { System.out.println("Adding animals"); }
       
           public void  performtask(CyclicBarrier c1, CyclicBarrier c2){
               try {
                   removeAnimals();
                   c1.await();
                   cleanPen();
                   c2.await();
                   addAnimals();
               } catch (InterruptedException | BrokenBarrierException e) {
                   e.printStackTrace();
               }
       
           }
       
           public static void main(String[] args) {
               ExecutorService service =null;
       
               try {
                   service = Executors.newFixedThreadPool(4);
                   LionPenManagerWithCyclicBarrier lionPenManager = new LionPenManagerWithCyclicBarrier();
                   CyclicBarrier c1 = new CyclicBarrier(4);
                   CyclicBarrier c2 = new CyclicBarrier(4, () -> System.out.println(" *** Pen  cleaned!"));
       
                   for (int i = 0; i < 4; i++) {
                       service.submit(()-> {
                           lionPenManager.performtask(c1, c2);
                       });
                   }
               }finally {
                   if (service != null) {
                       service.shutdown();
                   }
               }
       
               // The following is sample output based on this revised implementation of our LionPenManager class:
       
               /*
       
               Removing animals
               Removing animals
               Removing animals
               Removing animals
               Cleaning the pen
               Cleaning the pen
               Cleaning the pen
               Cleaning the pen
               *** Pen Cleaned!
               Adding animals
               Adding animals
               Adding animals
               Adding animals
                */
       
           }
       }
        ```
     * In this example, we have updated the performTask() to use CyclicBarrier objects.
     * Like synchronizing on the same object, coordinating a task with a CyclicBarrier requires the object to be static or passed to the thread performing the task.     
     * If you are using a thread pool, make sure that you set the number of available threads to be at least as large as your CyclicBarrier limit value. 
     * The CyclicBarrier class allows us to perform complex, multi-threaded tasks, while all threads stop and wait at logical barriers.
     * This solution is superior to a single-threaded solution, as the individual tasks, such as removing the animals, can be completed in parallel by all four zoo workers.
     * There is a slight loss in performance to be expected from using a CyclicBarrier. 
     * Par exemple, un travailleur peut être incroyablement lent à faire sortir les lions, ce qui fait que les trois autres travailleurs attendent qu'il finisse. 
     * Étant donné que nous ne pouvons pas commencer à nettoyer la cage alors qu'il est plein de lions, cette solution est à peu près aussi simultanée que possible. 
     
     * #### Applying the Fork/Join Framework
       * Suppose that we need to measure the weight of all of the animals in our zoo. Further suppose that we ask exactly one person to perform this task and complete it in an hour.
       * What’s the first thing that person is likely to do? Probably ask for help!
       * In most of the examples in this chapter, we knew at the start of the process exactly how many threads and tasks we needed to perform. Sometimes, we aren’t so lucky.
       * It may be that we have five threads, or five zoo workers in our example, but we have no idea how many tasks need to be performed. 
       * When a task gets too complicated, we can split the task into multiple other tasks using the fork/join framework.
       * The fork/join framework relies on the concept of recursion to solve complex tasks. Recursion is the process by which a task calls itself to solve a problem.
       * A recursive solution is constructed with a base case and a recursive case:
           * Base case: A non-recursive method that is used to terminate the recursive path
           * Recursive case: A recursive method that may call itself one or multiple times to solve a problem
       * Let’s use an array of Double values called weights. For simplicity, let’s say that there are 10 animals in the zoo; thus our array is of size 10.
       * Conceptually, we start off with a single zoo worker who realizes that they cannot perform all 10 tasks in time.
       * They perform a recursive step by dividing the set of 10 animals into two sets of 5 animals, one set for each zoo worker. 
       * The two zoo workers then further subdivide the set until each zoo worker has at most three animals to weigh, which is the base case in our example.
       * Applying the fork/join framework requires us to perform three steps:
           1. Create a ForkJoinTask.
           2. Create the ForkJoinPool.
           3. Start the ForkJoinTask.
       * The first step is the most complex, as it requires defining the recursive process. Fortunately, the second and third steps are easy and can each be completed with a single line of code.
       * You should know how to implement the fork/join solution by extending one of two classes, RecursiveAction and RecursiveTask, both of which implement the ForkJoinTask interface.    
       * RecursiveAction implementation example : class WeighAnimalAction
       * Dividing tasks into recursive subtasks may not always result in evenly divided sets. 
         In our zoo example, one zoo worker may end up with three animals to weigh, 
         while others may have only one animal to weigh. The goal of the fork/join framework is to break up large tasks into smaller ones, 
         not to guarantee every base case ends up being exactly the same size.
       * By default, the ForkJoinPool class will use the number of processors to determine how many threads to create. The following is a sample output of this code:
        ```java
          [start=0,middle=5,end=10] 
          [start=0,middle=2,end=5] 
          Animal Weighed: 0
          Animal Weighed: 2 
          [start=5,middle=7,end=10] 
          Animal Weighed: 1
          Animal Weighed: 3 
          Animal Weighed: 5 
          Animal Weighed: 6 
          Animal Weighed: 7 
          Animal Weighed: 8 
          Animal Weighed: 9 
          Animal Weighed: 4
       
          Weights: 94 73 8 92 75 63 76 60 73 3
       
        ```
       *  The key concept to take away from this example is that the process was started as a single task, and it spawned additional concurrent tasks to split up the work after it had already started.
       * Working with a RecursiveTask  : class WeighAnimalTask
     
       
  
 - #### Understanding Liveness
     * As you have seen in this chapter, many thread operations can be performed independently, but some require coordination. For example, synchronizing on a method requires all threads that call the method to wait for other threads to finish before continuing.
     * You also saw earlier in the chapter that threads in a CyclicBarrier will each wait for the barrier limit to be reached before continuing.
     * Liveness is the ability of an application to be able to execute in a timely manner.
     * Liveness problems, then, are those in which the application becomes unresponsive or in some kind of “stuck” state.
     * For the exam, there are three types of liveness issues with which you should be familiar: deadlock, starvation, and livelock:
        * Deadlock : Deadlock occurs when two or more threads are blocked forever, each waiting on the other.
        * Starvation: Starvation occurs when a single thread is perpetually denied access to a shared resource or lock.
          The thread is still active, but it is unable to complete its work as a result of other threads constantly taking the resource that they trying to access.
        * Livelock: Livelock occurs when two or more threads are conceptually blocked forever, although they are each still active and trying to complete their task.          
       
     
 - #### Managing Race Conditions
     * A race condition is an undesirable result that occurs when two tasks, which should be completed sequentially, are completed at the same time.      
      
           
       
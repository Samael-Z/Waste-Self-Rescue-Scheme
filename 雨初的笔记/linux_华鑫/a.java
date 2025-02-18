+ 实验要求：编写程序模拟两个村庄共用同一口井水。编写一个Village类，该类有一个静态的int型成员变量waterAmout，用于模拟井水的水量。在主类Land的main（）方法中创建两个村庄，一个村庄改变了waterAmount的值，另一个村庄查看waterAmount的值。

  ```java
  public class Main {
          public static void main(String[] args) {
                  Village a = new Village();
                  Village b = new Village();
                  a.drink(1);
                  System.out.println("还剩下" + Village.get() + "的水");
                  b.drink(2);
                  System.out.println("还剩下" + Village.get() + "的水");
          }
  }
  
  class Village {
          static int sum = 100;
          public void drink(int a)
          {
                  sum -= a;
          }
          public static int get()
          {
                  return sum;
          }
  }
  
  ```

+ 实验要求：简历的内容如下：

  “姓名：张三 出生时间：1989.10.16。个人网站：http://www.zhang.com。身高：185cm，体重：72kg”

  编写一个java应用程序，判断简历中的姓名是否姓“张”，单独输出简历中的出生日期和个人网站，并判断简历中的身高是否大于180cm，体重是否小于75kg。


+ 实验要求：使用Scanner类和正则表达式统计一篇英文中的单词，要求如下：

  一共出现了多少个单词。

  有多少个互不相同的单词。

  按单词出现频率大小输出单词。

  ```cpp
  import java.util.*;
  
  public class A {
      public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          String s = scanner.nextLine();
  
          String[] words = s.split("\\W+");
          System.out.printf("一共出现了%d个单词\n", words.length);
  
          HashMap<String, Integer> h = new HashMap<String, Integer>();
  
          for (String word : words) {
              if (h.containsKey(word)) {
                  int t = h.get(word);
  //                h.remove(word);
                  h.put(word, t + 1);
              } else {
                  h.put(word, 1);
              }
          }
  
          List<Map.Entry<String, Integer>> l = new ArrayList<>();
          for (Map.Entry<String, Integer> t : h.entrySet()) {
              l.add(t);
          }
  
          Collections.sort(l, new Comparator<Map.Entry<String, Integer>>() {
              @Override
              public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                  if (o1.getValue() > o2.getValue())
                      return 1;
                  else return 0;
              }
          });
  
          System.out.printf("共有%d个不同单词\n", l.size());
          for (Map.Entry<String, Integer> t : l)
          {
              System.out.printf("%s 出现 %d次\n", t.getKey(), t.getValue());
          }
      }
  }
  ```

+ 实验要求：用两个线程玩猜数字游戏，第一个线程负责随机给出1到100之间的一个整数，第二个线程负责猜出这个数。要求每当第二个线程给出自己的猜测后，第一个线程都会提示“猜小了”、“猜大了”或“猜对了”。猜数之前，要求第二个线程要等待第一个线程设置好要猜测的数。第一个线程设置好猜测数之后，两个线程还要互相等待，其原则是，第二个线程给出自己的猜测后，等待第一个线程给出的提示；第一个线程给出提示后，等待给第二个线程给出猜测，如此进行，直到第二个线程给出正确的猜测后，两个线程进入死亡状态。

  ```cpp
  import java.lang.reflect.Parameter;
  import java.util.Random;
  import java.util.concurrent.Semaphore;
  
  public class A {
      public static void main(String[] args) {
          Test test = new Test();
      }
  }
  
  class Test implements Runnable {
      Thread a, b;
      boolean done = false;
      int num = 0;
      int guess;
      int min = 1;
      int max = 100;
      char turn = 'a';
      int count = 0;
      Semaphore s = new Semaphore(1);
  
      Test() {
          a = new Thread(this);
          b = new Thread(this);
          a.setName("a");
          b.setName("b");
          a.start();
          b.start();
      }
  
      @Override
      public void run() {
          while (true) {
              try {
                  play();
  
              } catch (InterruptedException e) {
              }
              if (done) {
                  System.out.printf("一共猜了%d次\n", count);
                  return;
              }
          }
      }
  
      void play() throws InterruptedException {
          if (Thread.currentThread() == a) {
              if (turn != 'a') {
                  return;
              }
  
              s.acquire();
              turn = 'b';
  
              if (num == 0) {
                  Random r = new Random();
                  num = r.nextInt();
                  if (num < 0) num = -num;
                  num = num % 100 + 1;
                  System.out.println("num = " + num);
                  s.release();
                  return;
              }
  
  
              if (guess < num) {
                  System.out.println("猜小了");
                  min = num + 1;
              } else if (guess > num) {
                  System.out.println("猜大了");
                  max = num - 1;
              } else {
                  System.out.println("猜对了");
                  done = true;
                  return; // 不释放
              }
  
              s.release();
          } else if (Thread.currentThread() == b) {
              if (turn != 'b') return;
  
              s.acquire();
              turn = 'a';
  
              if (num == 0) {
                  s.release();
                  return;
              }
  
              guess = (min + max) / 2;
              System.out.println("猜" + guess);
              count++;
              s.release();
          }
      }
  }
  ```

  

+ 4 9  15 23
package com.hf.stream;

import java.math.BigInteger;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @Author huangfeng
 * @Date: Created in 11:04 上午 2020/12/2
 * @Description
 **/
public class StreamDemo {
    public static void main(String[] args) {
       /** List<String> words = new ArrayList<>();
        words.add("hello");
        words.add(",");
        words.add("how");
        words.add("are");
        words.add("you");
        words.add(".");
        int count = 0;
        for (String word: words) {
            if (word.length() > 2) count++;
        }
        System.out.println(count);

        long newCount = words.stream().filter(w->w.length()>4).count();
        System.out.println(newCount);

        newCount = words.parallelStream().filter(w->w.length()>3).count();
        System.out.println(newCount);

        //Collection接口下的类都可以通过调用stream()方法转换为一个流
**/
        //数组 ??如何过滤元素
//        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
//        int n = 4;
//        boolean result = Stream.of(arr).map((m, n)->String::compareTo).count();
//        System.out.println(result);

//        Stream<String> echo = Stream.generate(()->"echo");
//        System.out.println(echo.findFirst());

//        Stream<Double> randoms = Stream.generate(Math::random);
//        System.out.println(randoms.iterator());

//        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO, n->n.add(BigInteger.ONE));
//        Iterator<BigInteger> iterator = integers.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        /**
        String[] words = new String[]{"hello", "world"};
        show("words", Stream.of(words));

        show("silence", Stream.empty());

        //generate创建无限流
        show("echo", Stream.generate(()->"echo"));

        show("random", Stream.generate(Math::random));

        show("iterate", Stream.iterate(BigInteger.ZERO, n->n.add(BigInteger.ONE)));

//        show("iterate2", Stream.iterate(BigInteger.ZERO, n->n.compareTo(new BigInteger("10"))>0, n->n.add(BigInteger.ONE)));
        Iterable<Path> iterable = FileSystems.getDefault().getRootDirectories();
        Stream<Path> rootDirectors = StreamSupport.stream(iterable.spliterator(), false);
        show("rootDirectors", rootDirectors);

        Iterator<Path> iterator = Paths.get("/Users/huangfeng").iterator();
        Stream<Path> pathComponents = StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false);
        show("components", pathComponents);

         **/
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("word");
        Stream<Stream<String>> res = words.stream().map(m->codePoints(m));

    }

    public static Stream<String> codePoints(String words) {
        var result = new ArrayList<String>();
        int i=0;
        while(i<words.length()) {
            int j = words.offsetByCodePoints(i, 1);
            result.add(words.substring(i, j));
            i = j;
        }
        return result.stream();
    }

    /**
     *
     * @param title
     * @param stream
     * @param <T>
     */
    public static<T> void  show(String title, Stream<T> stream) {
        final int SIZE = 10;
        List<T> fistElement = stream.limit(SIZE+1).collect(Collectors.toList());
        System.out.print(title+" ");
        for (int i = 0; i < fistElement.size(); i++) {
            if (i>0) System.out.print(",");
            if (i<SIZE) System.out.print(fistElement.get(i));
            else
                System.out.print("...");
        }
        System.out.println();
    }
}

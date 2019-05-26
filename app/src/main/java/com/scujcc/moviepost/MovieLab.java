package com.scujcc.moviepost;
import java.util.ArrayList;
import java.util.List;
/**
 * 存储电影信息，它在整个应用程序中应该只有一个实例，所以采用单列设计模型来完成。
 */
public class MovieLab {
    private static MovieLab instance ;
    private List<String> movies;
    /**
     * 让构造方法成为私有，避免外部调用
     */
    private MovieLab() {
        init();
    }
    /**
     * 此方法只会返回一个实例，不会创建新的实例。
     * @return 单例.表示电影仓库
     */
    public static MovieLab get(){
        if (null == instance){
            instance = new MovieLab();
        }
        return instance;
    }
    /**
     * 返回此仓库中有几部电影
     * @return 电影数量，整数
     */
    public int getSize() {
       return movies.size();
    }
    /**
     * 放回指定的电影信息（目前只有名称）
     * @param n 电影的编号或称第几部电影
     * @return 电影信息（目前只有名称）
     */
    public String getMovie(int n){
        return movies.get(n);
    }
    /**
     * 初始化一些电影信息用于测试
     */
    private void init(){
        movies = new ArrayList<>();
        movies.add("CCTV1");
        movies.add("CCTV2");
        movies.add("CCTV3");
        movies.add("CCTV4");


    }
}

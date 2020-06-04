package com.example.demo.util;


import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * <p>TempleteTest</p>
 * <p>description</p>
 *
 * @author wushuai
 * @version 1.0.0
 * @date 2020-06-04 10:50
 */
@Component
public class TempleteTest<T> {
    private T templete;
    private String name;
    private Integer id;


    /**
     * 静态类方法，中的泛型K和T已经没有任何关系了
     *
     * @param templete
     * @param <K>
     * @return
     */
    private static <K> TempleteTest<K> createK(K templete) {
        return new TempleteTest<>(templete, "", 1);
    }

    /**
     * 这个方法和上面的方法完全一样
     *
     * @param templete
     * @param <T>
     * @return
     */
    private static <T> TempleteTest<T> createK_v2(T templete) {
        return new TempleteTest<>(templete, "", 1);
    }

    /**
     * 不加空参构造器，Spring会自动注入有参构造器，会发生错误
     */
    public TempleteTest() {}

    public TempleteTest(T templete, String name, Integer id) {
        this.templete = templete;
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "TempleteTest{" +
                "templete=" + templete +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TempleteTest<?> that = (TempleteTest<?>) o;
        return Objects.equals(templete, that.templete) &&
                Objects.equals(name, that.name) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(templete, name, id);
    }

    public T getTemplete() {
        return templete;
    }

    public void setTemplete(T templete) {
        this.templete = templete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}



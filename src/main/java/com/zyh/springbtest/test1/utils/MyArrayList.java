package com.zyh.springbtest.test1.utils;

import java.util.Arrays;
import java.util.Date;

/**
 * 自己实现的顺序列表结构
 * @param <E>   顺序列表的数据单元类型
 */
public class MyArrayList<E> {
    private Object[] data = null; //data 用来保存此线性表的数据域
    private int length; //线性表的容量
    private int current; //实际表长(指向数组末尾第一个没有数据的位置)

    /**
     * 默认长度为10
     */
    MyArrayList(){
        this(10);
    }

    /**
     * 初始化线性表，声明表长度
     * @param initialSize 线性表初始长度
     */
    public MyArrayList(int initialSize){
        if(initialSize >=0){
            this.length = initialSize;
            this.data = new Object[initialSize];
            this.current = 0;
        }else{
            throw new RuntimeException("初始化大小不能小于0："+initialSize);
        }
    }

    /**
     * 在线性表末尾添加元素,添加之前判断线性表是否已经满了
     * @param e 添加的元素
     * @return 成功返回真
     */
    public boolean add(E e){
        //判断是否已满
        ensureCapacity();
        //将元素添加到数组末尾
        this.data[current] = e;
        //下标++
        current++;
        return true;
    }

    /**
     * 删除指定位置的元素
     * @param index     要删除数据的位置
     * @return false：删除失败；true：删除成功
     */
    public boolean delete(int index){
        //删除数组的元素：使用改变数组下标的方式达到删除的效果。
        //遍历数组匹配指定下标，让指定下标右边的元素往左移动改变下标。最后再将最右边的下标删除
        //a b c
        //0 1 2
        //data[index] = data[index + 1];  //改变右边下标
        //data                             //删除最右边的下标
        //从待删除下标处开始遍历，将右边的元素往左移
        if(index >= current){  //如果index大于最大长度，返回假
            System.err.print(new Date() + ": 下标超出表长");
            return false;
        }
        //该表元素下标
        System.arraycopy(data, index + 1, data, index, current - 1 - index);
        /*
         * 原来采用for循环方式赋值，非常low，改用System.arraycopy()
         * for (int i = index; i < current - 1; i++) {
         *      data[i] = data[i+1]; //该表元素下标
         * }
        */
        data[current-1] = null;  //将原来下标最右边的一位元素变成null
        --current;  //实际表长-1
        return true;
    }

    /**
     * 向表中插入数据
     * @param pos   要插入数据的位置
     * @param tar   要插入的数据
     * @return      true:插入成功；false:失败
     */
    public boolean insert(int pos, E tar) {
        if (pos < 0 || pos > current) {
            throw new RuntimeException("插入位置不合法");
        }
        ensureCapacity();

        //从尾部往前扫
        for(int j = current; j > pos; j--){
            data[j] = data[j - 1];
        }
        data[pos] = tar;
        //插入成功后，表长度+1
        current++;
        return true;
    }

    //修改指定位置的数字
    public boolean set (int pos, E tar) {
        if(pos < 0 || pos > current){
            throw new RuntimeException("插入位置不合法");
        }
        data[pos] = tar;
        return true;
    }

    //置空操作
    public void clear() {
        current = 0;
    }

    /**
     * 根据下标返回元素值
     * @param   index   想要获取对象的位置
     * @return      需要的对象
     */
        public E get(int index){
            if(index >= 0){
                return (E) data[index];
            }else {
                throw new RuntimeException("下标不能小于0:" + index);
            }
    }

    /**
     *  判断表容量是否超出预定大小，如果超出将自动扩充容量
     */
    private void ensureCapacity(){
        //判断表实际长度是否超出表最大容量
        if(current >= length){
            length += length/2;//最大表容量扩展为原来的1.5倍
            data = Arrays.copyOf(data,length);//将原数组进行拷贝
        }
    }

    /**
     * 返回实际表容量
     * @return      当前表容量（current）
     */
    public int size(){
        return this.current;
    }

    /**
     * 返回总长度
     * @return      表的总容量（length）
     */
    public  int getLength(){
        return this.length;
    }

    /**
     * 判断表是否为空
     * @return  true:空; false:非空
     */
    public boolean isEmpty(){
        //return (current == 0) ? true : false;
        return current == 0; //如果current == 0，说明为空返回真，否则返回假
    }

    //主方法测试
    public static void main(String[] args) {
            MyArrayList<Integer> list = new MyArrayList<Integer>(); //创建arrayList
            for (int i = 1; i <= 25; i++) {
                list.add(i);
                System.out.println("now i = " + i + ", size = " + list.size() + ",length = "+list.getLength());
            }
            //list.delete(9);
            //list.removeToIndex(list.size());
            //遍历list数组
            list.insert(10,999);
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }

    }
}

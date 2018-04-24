package com.zyh.springbtest.test1.utils;

/**
 * 基础实现一个单端的链表
 */
public class MyLinkedList {
    private class Data{
        private Object obj;
        private Data next = null;

        Data(Object obj){
            this.obj = obj;
        }
    }

    private Data first = null;

    public void insertFirst(Object obj){
        Data data = new Data(obj);
        data.next = first;
        first = data;
    }

    public Object deleteFirst() throws Exception{
        if(first == null)
            throw new Exception("empty!");
        Data temp = first;
        first = first.next;
        return temp.obj;
    }

    public Object find(Object obj) throws Exception{
        if(first == null)
            throw new Exception("LinkedList is empty!");
        Data cur = first;
        while(cur != null){
            if(cur.obj.equals(obj)){
                return cur.obj;
            }
            cur = cur.next;
        }
        return null;
    }

    public void remove(Object obj) throws Exception{
        if(first == null)
            throw new Exception("LinkedList is empty!");
        if(first.obj.equals(obj)){
            first = first.next;
        }else{
            Data pre = first;
            Data cur = first.next;
            while(cur != null){
                if(cur.obj.equals(obj)){
                    pre.next = cur.next;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }

    public boolean isEmpty(){
        return (first == null);
    }
}

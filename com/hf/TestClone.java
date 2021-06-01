package com.hf;

public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1 = new Person();
        Person father = new Person();
        p1.setFather(father);

        Person p2 = (Person) p1.clone();
        p2.setName("peng**");
//        p1.setName("peng**");
        System.out.println(p2.getName());

        System.out.println(p1 == p2);
        System.out.println(p1.getFather() == p2.getFather());
        System.out.println(p1.getName() == p2.getName());
    }
}


class Person implements Cloneable {
    private int id;
    private String name="huang**";
    private Person father;
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = null;

        person = (Person)super.clone();
        return person;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getFather() {
        return father;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
package com.hf.innerclass;

public class Person {
    private  String name ="person";
    public static void main(String[] args) {
        Person.Dog dog = new Person.Dog();
//        dog.say("形参");
        Person p = new Person();
        Person.Bird bird = p.new Bird();
        bird.say("bird 形参");
    }
    static class Dog {
        String name = "dog";
        public void say(String name) {
            System.out.println(this.name);
            System.out.println(name);
//            System.out.println(Person.name);
        }
    }
    class Bird {
        String name = "dog";
        public void say(String name) {
            System.out.println(this.name);
            System.out.println(name);
            System.out.println(Person.this.name);
        }
    }
}

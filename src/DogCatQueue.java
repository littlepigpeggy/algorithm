// 猫狗队列问题
// 为了获取相对次序，不单单只放入Pet, 自定义数据结构petEnter保留次序

import java.util.ArrayDeque;
import java.util.Queue;

public class DogCatQueue {
    private Queue<petEnter> dog;
    private Queue<petEnter> cat;
    private static Integer index;

    public DogCatQueue(){
        dog = new ArrayDeque<>();
        cat = new ArrayDeque<>();
        index = 0;
    }

    public void push(Pet pet){
        if (pet.type == "Dog"){
            petEnter newEnter = new petEnter(pet, index);
            dog.add(newEnter);
            ++index;
        }
        else{
            petEnter newEnter = new petEnter(pet, index);
            cat.add(newEnter);
            ++index;
        }
    }

    public Pet pollDog(){
        return dog.poll().getPet();
    }

    public Pet pollCat(){
        return cat.poll().getPet();
    }

    public Pet pollAll(){
        if (cat.peek().getCount() > dog.peek().getCount()){
            return dog.peek().getPet();
        }
        else {
            return cat.peek().getPet();
        }
    }

    public boolean isEmpty(){
        if (cat.isEmpty() && dog.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    public static class petEnter{
        private Pet pet;
        private int count;
        public petEnter(Pet pet, int count){
            this.pet = pet;
            this.count = count;
        }
        public Pet getPet(){
            return this.pet;
        }
        public int getCount(){
            return this.count;
        }
    }

    public static class Pet{
        private String type;

        public Pet(String type){
            this.type = type;
        }

        public String getType(){
            return this.type;
        }
    }

    public static class Dog extends Pet{
        public Dog() {
            super("Dog");
        }
    }

    public static class Cat extends Pet{
        public Cat(){
            super("Cat");
        }
    }



}

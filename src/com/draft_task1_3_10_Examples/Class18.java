package com.draft_task1_3_10_Examples;
// источник: https://www.cyberforum.ru/java-j2se/thread1981757.html?ysclid=ln2ttaeoav290530652
// источник: https://translated.turbopages.org/proxy_u/en-ru.ru.9667ef09-65152473-92836c2f-74722d776562/https/stackoverflow.com/questions/6576855/java-how-to-access-methods-from-another-class

public class Class18 extends Class17_Animal {  // public class Cat extends Animal
    public static void main(String[] args) {
        Class17_Animal class17_Animal = new Class17_Animal();
        class17_Animal.name = "Murka";
        class17_Animal.type = "cat";
        class17_Animal.voice = "Murr";

        System.out.println(class17_Animal.name + ", " +  class17_Animal.type  + ", " +  class17_Animal.voice );
    }
}

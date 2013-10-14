package java_examples_parent;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: ollyshaw
 * Date: 14/10/2013
 * Time: 19:45
 * To change this template use File | Settings | File Templates.
 */
public class TypedStackTest {

    TypedStack<Animal> stack;

    @Before
    public void setup() {
        stack = new TypedStack<Animal>();
    }

    //I know, we're testing two things here :-)
    @Test
    public void testPushAndPop() throws Exception {
        Animal dog = new Dog();
        Animal cat = new Cat();
        Dog anotherDog = new Dog();
        Cat anotherCat = new Cat();
        stack.push(dog);
        stack.push(cat);
        stack.push(anotherCat);
        stack.push(anotherDog);

        assertTrue(stack.pop() instanceof Dog);
        assertTrue(stack.pop() instanceof Cat);
        assertTrue(stack.pop() instanceof Cat);
        assertTrue(stack.pop() instanceof Dog);

    }

    @Test
    public void testPushAll() throws Exception {
        List<Animal> toAdd = new LinkedList<Animal>();
        List<Dog> dogsToAdd = new LinkedList<Dog>();
        List<Cat> catsToAdd = new LinkedList<Cat>();
        for (int ii=0; ii<10 ; ii++){
           toAdd.add(new Cat());
           toAdd.add(new Dog());
           dogsToAdd.add(new Dog());
           catsToAdd.add(new Cat());

        }
        stack.pushAll(toAdd);
        stack.pushAll(dogsToAdd);
        stack.pushAll(catsToAdd);

        assertEquals(40, stack.size());

    }

    @Test
    public void testPopAllToList() throws Exception {
        List<Animal> toAdd = new LinkedList<Animal>();
        List<Dog> dogsToAdd = new LinkedList<Dog>();
        List<Cat> catsToAdd = new LinkedList<Cat>();
        for (int ii=0; ii<10 ; ii++){
            toAdd.add(new Cat());
            toAdd.add(new Dog());
            dogsToAdd.add(new Dog());
            catsToAdd.add(new Cat());

        }
        stack.pushAll(toAdd);
        stack.pushAll(dogsToAdd);
        stack.pushAll(catsToAdd);

        List<Animal> animals = new LinkedList<Animal>();
        stack.popAllToList(animals);
        assertEquals(40, animals.size());
        assertTrue(stack.empty());

    }

    @Test
    public void testEmpty() throws Exception {
        assertTrue(stack.empty());
        stack.push(new Dog());
        assertFalse(stack.empty());
        stack.pop();
        assertTrue(stack.empty());
    }
}

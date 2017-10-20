package lambda.part2.exercise;

import data.Person;
import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class ArrowNotationExercise {

    @Test
    public void getAge() {
        // Person -> Integer
        final Function<Person, Integer> getAge = Person::getAge; // TODO

        assertEquals(Integer.valueOf(33), getAge.apply(new Person("", "", 33)));
    }
  
    private static boolean sameAge(Person p1, Person p2) {
        return (p1.getAge() == p2.getAge());
    }

    @Test
    public void compareAges() {
        // TODO use BiPredicate
        // compareAges: (Person, Person) -> boolean
        BiPredicate<Person,Person> compareAges = ArrowNotationExercise::sameAge;

        //throw new UnsupportedOperationException("Not implemented");
        assertEquals(true, compareAges.test(new Person("a", "b", 22), new Person("c", "d", 22)));
    }

    // TODO
    // getFullName: Person -> String

    private static String getFullName(Person p) {
        return p.getFirstName() + " " + p.getLastName();
    }


    // TODO
    // ageOfPersonWithTheLongestFullName: (Person -> String) -> ((Person, Person) -> int)
    //
  @Test
    public void getAgeOfPersonWithTheLongestFullName() {
        // Person -> String
        final Function<Person, String> getFullName = ArrowNotationExercise::getFullName;


        final BiFunction<Person, Person, Integer> ageOfPersonWithTheLongestFullName =
             (p1, p2) -> (getFullName.apply(p1)).length() > (getFullName.apply(p2)).length() ? p1.getAge() : p2.getAge();

        assertEquals(
                Integer.valueOf(1),
                ageOfPersonWithTheLongestFullName.apply(
                        new Person("a", "b", 2),
                        new Person("aa", "b", 1)));
    }
}
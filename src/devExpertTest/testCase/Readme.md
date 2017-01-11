# InvoicingTest_00

Initial code

# InvoicingTest_01

only difference:

* assertTrue("Invoice should have 1 item", false);
* fail("Invoice should have 1 item"); 

# InvoicingTest_02

method extraction: add a new method assertDocumentItemEquals

# InvoicingTest_03

add some cleanup logic in finally block

# InvoicingTest_04

method extraction: instance initialization is done in createXXX method

# InvoicingTest_05

move initialization logic to @before, and cleanup in @after

# InvoicingTest_06

add a new member attribute private List<Object> testObjects;
when instance is created, add instance to this list. So in @after, the instance could be 
cleaned up generically.

# InvoicingTest_07
test a new method: testRemoveItemQuantity

# InvoicingTest_08
new approach @Test(expected=java.lang.IndexOutOfBoundsException.class)
How does it work:
set breakpoint in class ExpectException, method @Override evaluate, line 24 fExpected.isAssignableFrom

# InvoicingTest_09

* all test methods are run in the same thread
* add new method to compare expected price
* more human readable format in junit display result thanks to @parameter, not pure method name now

When a class is annotated with RunWith, JUnit will invoke the class it references to run the
tests in that class instead of the runner built into JUnit.
 
Check the source code of class Parameterized:
public class Parameterized extends Suite
There is an annotation:
Annotation for a method which provides parameters to be injected into the **test class constructor** 
by **Parameterized**

```Java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public static @interface Parameters
```

## Suite

Parameterized is a Suite. Suite is a Runner.

```Java
/**
 * Using Suite as a runner allows you to manually
 * build a suite containing tests from many classes. It is the JUnit 4 equivalent of the JUnit 3.8.x
 * static junit.framework.Test suite() method. To use it, annotate a class
 * with **@RunWith(Suite.class)** and **@SuiteClasses({TestClass1.class, ...})**.
 * When you run this class, it will run all the tests in all the suite classes.
 *
 * @since 4.0
 */
public class Suite extends ParentRunner<Runner> {
    /**
     * Returns an empty suite.
     */
    public static Runner emptySuite() {
        try {
            return new Suite((Class<?>) null, new Class<?>[0]);
        } catch (InitializationError e) {
            throw new RuntimeException("This shouldn't be possible");
        }
    }
}
```
debugging could start by setting breakpoint in constructor of Parameterized and:

* allParameters
* createRunnersForParameters
* @Override createTest

# ProposalTest 

```Java
	@Test
	@Category(CategoryAddData.class)
	public void testAddItemQuantity(){ 
```
1. just mark method with a tag

2. create a suite class, and run this class for testing.

```Java
@RunWith(Categories.class)  
@IncludeCategory(CategoryAddData.class)  
@SuiteClasses( { ProposalTest.class}) 

public class AddDataSuite {

}
```

## How does @RunWith(Categories.class) work

check its source code:
From a given set of test classes, runs only the classes and methods that are
 * annotated with either the category given with the @IncludeCategory
 * annotation, or a subtype of that category.
 
 public class Categories extends Suite
 
 debug this method:
 ```Java
 @Override
 public boolean shouldRun(Description description) 
 ```
 
        
 
/*
 * Copyright (c) 2007 Mockito contributors
 * This program is made available under the terms of the MIT License.
 */
package org.mockito.runners;

import org.junit.internal.runners.InitializationError;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * JUnit 4.0-4.4 runner initializes mocks annotated with {@link Mock},
 * so that explicit usage of {@link MockitoAnnotations#initMocks(Object)} is not necessary. 
 * Mocks are initialized before each test method. 
 * Runner is completely optional - there are other ways you can get &#064;Mock working, for example by writing a base class.
 * Read more in javadoc for {@link MockitoAnnotations#initMocks(Object)}
 * <p>
 * Example:
 * <pre>
 * &#064;RunWith(MockitoJUnit4Runner.class)
 * public class ExampleTest {
 * 
 *     &#064;Mock
 *     private List list;
 * 
 *     &#064;Test
 *     public void shouldDoSomething() {
 *         list.add(100);
 *     }
 * }
 * <p>
 * 
 * </pre>
 */
@SuppressWarnings("deprecation")
public class MockitoJUnit4Runner extends JUnit4ClassRunner {

    public MockitoJUnit4Runner(Class<?> klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected Object createTest() throws Exception {
        Object test = super.createTest();
        MockitoAnnotations.initMocks(test);
        return test;
    }
}
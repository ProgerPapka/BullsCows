package game.servlets;

import game.beans.BullsCows;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Method;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class UserServletTest {

    private static String mainValue;

    private String value;
    private BullsCows result;

    public UserServletTest(String value, BullsCows result) {
        this.value = value;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection setOfParametrs() {
        return Arrays.asList(new Object[][]{
                {
                        "7305", new BullsCows(4, 0)
                },
                {
                        "7053", new BullsCows(1, 3)
                },
                {
                        "3705", new BullsCows(2, 2)
                },
                {
                        "7430", new BullsCows(1, 2)
                },
                {
                        "8305", new BullsCows(3, 0)
                }
        });
    }

    @BeforeClass
    public static void initData() {
        mainValue = "7305";
    }

    @Test
    public void compareWithValue() throws Exception {
        Method method = UserServlet.class.getDeclaredMethod("compareWithValue",
                String.class, String.class);
        method.setAccessible(true);
        UserServlet servlet = new UserServlet();
        BullsCows bullsCows = (BullsCows) method.invoke(servlet, this.value, mainValue);
        assertEquals(bullsCows, this.result);
    }

    @Test
    public void generateValue() throws Exception {
        Method method = UserServlet.class.getDeclaredMethod("generateValue");
        method.setAccessible(true);
        UserServlet servlet = new UserServlet();
        String value = (String) method.invoke(servlet);
        assertTrue(correctGenerate(value));
    }

    private boolean correctGenerate(String value) {
        char[] array = value.toCharArray();
        Set set = new HashSet();
        for (char a : array) {
            set.add(a);
        }
        return set.size() == 4;
    }

}
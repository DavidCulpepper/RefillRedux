import android.test.ActivityInstrumentationTestCase2;

import com.praeses.refillredux.MainActivity;
import com.praeses.refillredux.R;
import com.squareup.spoon.Spoon;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.click;
import static com.google.android.apps.common.testing.ui.espresso.action.ViewActions.typeText;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

/**
 * Created by klimaye on 12/5/13.
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testHello() {
        onView(withId(R.id.first_name))
                .perform(typeText("John"));
        onView(withId(R.id.last_name))
                .perform(typeText("Doe"));
        onView(withId(R.id.say_hello))
                .perform(click());
        onView(withId(R.id.message))
                .check(matches(withText("Hello, John Doe")));
    }

    public void testScreenshot() {
        Spoon.screenshot(getActivity(),"hello");
    }
}

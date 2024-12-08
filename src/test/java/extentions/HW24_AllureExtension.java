package extentions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import steps.HW24_AllureSteps;

public class HW24_AllureExtension  implements AfterTestExecutionCallback {
    HW24_AllureSteps allureSteps = new HW24_AllureSteps();
    @Override
    public void afterTestExecution(ExtensionContext context) {
        if (context.getExecutionException().isPresent()) allureSteps.captureScreenshotSpoiler();
    }
}

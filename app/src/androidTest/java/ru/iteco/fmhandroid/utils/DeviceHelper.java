package ru.iteco.fmhandroid.utils;

import androidx.test.platform.app.InstrumentationRegistry;

public class DeviceHelper {

    public static void clearAppData() {

        try {

            InstrumentationRegistry.getInstrumentation()
                    .getUiAutomation()
                    .executeShellCommand(
                            "pm clear ru.iteco.fmhandroid"
                    );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
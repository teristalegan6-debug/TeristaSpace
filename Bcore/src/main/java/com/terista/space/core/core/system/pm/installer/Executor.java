package com.terista.space.core.core.system.pm.installer;

import com.terista.space.core.core.system.pm.BPackageSettings;
import com.terista.space.core.entity.pm.InstallOption;


public interface Executor {
    public static final String TAG = "InstallExecutor";

    int exec(BPackageSettings ps, InstallOption option, int userId);
}

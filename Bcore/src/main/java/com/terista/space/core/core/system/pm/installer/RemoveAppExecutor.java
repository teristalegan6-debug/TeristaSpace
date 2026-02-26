package com.terista.space.core.core.system.pm.installer;

import com.terista.space.core.core.env.BEnvironment;
import com.terista.space.core.core.system.pm.BPackageSettings;
import com.terista.space.core.entity.pm.InstallOption;
import com.terista.space.core.utils.FileUtils;


public class RemoveAppExecutor implements Executor {
    @Override
    public int exec(BPackageSettings ps, InstallOption option, int userId) {
        FileUtils.deleteDir(BEnvironment.getAppDir(ps.pkg.packageName));
        return 0;
    }
}

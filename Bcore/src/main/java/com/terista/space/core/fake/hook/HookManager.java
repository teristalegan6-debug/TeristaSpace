package com.terista.space.core.fake.hook;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import com.terista.space.core.BlackBoxCore;
import com.terista.space.core.fake.delegate.AppInstrumentation;

import com.terista.space.core.fake.service.HCallbackProxy;
import com.terista.space.core.fake.service.IAccessibilityManagerProxy;
import com.terista.space.core.fake.service.IAccountManagerProxy;
import com.terista.space.core.fake.service.IActivityClientProxy;
import com.terista.space.core.fake.service.IActivityManagerProxy;
import com.terista.space.core.fake.service.IActivityTaskManagerProxy;
import com.terista.space.core.fake.service.IAlarmManagerProxy;
import com.terista.space.core.fake.service.IAppOpsManagerProxy;
import com.terista.space.core.fake.service.IAppWidgetManagerProxy;
import com.terista.space.core.fake.service.IAttributionSourceProxy;
import com.terista.space.core.fake.service.IAutofillManagerProxy;
import com.terista.space.core.fake.service.ISensitiveContentProtectionManagerProxy;
import com.terista.space.core.fake.service.ISettingsSystemProxy;
import com.terista.space.core.fake.service.IConnectivityManagerProxy;
import com.terista.space.core.fake.service.ISystemSensorManagerProxy;
import com.terista.space.core.fake.service.IContentProviderProxy;
import com.terista.space.core.fake.service.IXiaomiAttributionSourceProxy;
import com.terista.space.core.fake.service.IXiaomiSettingsProxy;
import com.terista.space.core.fake.service.IXiaomiMiuiServicesProxy;
import com.terista.space.core.fake.service.IDnsResolverProxy;
import com.terista.space.core.fake.service.IContextHubServiceProxy;
import com.terista.space.core.fake.service.IDeviceIdentifiersPolicyProxy;
import com.terista.space.core.fake.service.IDevicePolicyManagerProxy;
import com.terista.space.core.fake.service.IDisplayManagerProxy;
import com.terista.space.core.fake.service.IFingerprintManagerProxy;
import com.terista.space.core.fake.service.IGraphicsStatsProxy;
import com.terista.space.core.fake.service.IJobServiceProxy;
import com.terista.space.core.fake.service.ILauncherAppsProxy;
import com.terista.space.core.fake.service.ILocationManagerProxy;
import com.terista.space.core.fake.service.IMediaRouterServiceProxy;
import com.terista.space.core.fake.service.IMediaSessionManagerProxy;
import com.terista.space.core.fake.service.IAudioServiceProxy;
import com.terista.space.core.fake.service.ISensorPrivacyManagerProxy;
import com.terista.space.core.fake.service.ContentResolverProxy;
import com.terista.space.core.fake.service.IWebViewUpdateServiceProxy;
import com.terista.space.core.fake.service.IMiuiSecurityManagerProxy;
import com.terista.space.core.fake.service.SystemLibraryProxy;
import com.terista.space.core.fake.service.ReLinkerProxy;
import com.terista.space.core.fake.service.WebViewProxy;
import com.terista.space.core.fake.service.WebViewFactoryProxy;
import com.terista.space.core.fake.service.MediaRecorderProxy;
import com.terista.space.core.fake.service.AudioRecordProxy;
import com.terista.space.core.fake.service.MediaRecorderClassProxy;
import com.terista.space.core.fake.service.SQLiteDatabaseProxy;
import com.terista.space.core.fake.service.ClassLoaderProxy;
import com.terista.space.core.fake.service.FileSystemProxy;
import com.terista.space.core.fake.service.GmsProxy;
import com.terista.space.core.fake.service.LevelDbProxy;
import com.terista.space.core.fake.service.DeviceIdProxy;
import com.terista.space.core.fake.service.GoogleAccountManagerProxy;
import com.terista.space.core.fake.service.AuthenticationProxy;
import com.terista.space.core.fake.service.AndroidIdProxy;
import com.terista.space.core.fake.service.AudioPermissionProxy;

import com.terista.space.core.fake.service.INetworkManagementServiceProxy;
import com.terista.space.core.fake.service.INotificationManagerProxy;
import com.terista.space.core.fake.service.IPackageManagerProxy;
import com.terista.space.core.fake.service.IPermissionManagerProxy;
import com.terista.space.core.fake.service.IPersistentDataBlockServiceProxy;
import com.terista.space.core.fake.service.IPhoneSubInfoProxy;
import com.terista.space.core.fake.service.IPowerManagerProxy;
import com.terista.space.core.fake.service.ApkAssetsProxy;
import com.terista.space.core.fake.service.ResourcesManagerProxy;
import com.terista.space.core.fake.service.IShortcutManagerProxy;
import com.terista.space.core.fake.service.IStorageManagerProxy;
import com.terista.space.core.fake.service.IStorageStatsManagerProxy;
import com.terista.space.core.fake.service.ISystemUpdateProxy;
import com.terista.space.core.fake.service.ITelephonyManagerProxy;
import com.terista.space.core.fake.service.ITelephonyRegistryProxy;
import com.terista.space.core.fake.service.IUserManagerProxy;
import com.terista.space.core.fake.service.IVibratorServiceProxy;
import com.terista.space.core.fake.service.IVpnManagerProxy;
import com.terista.space.core.fake.service.IWifiManagerProxy;
import com.terista.space.core.fake.service.IWifiScannerProxy;
import com.terista.space.core.fake.service.IWindowManagerProxy;
import com.terista.space.core.fake.service.context.ContentServiceStub;
import com.terista.space.core.fake.service.context.RestrictionsManagerStub;
import com.terista.space.core.fake.service.libcore.OsStub;
import com.terista.space.core.utils.Slog;
import com.terista.space.core.utils.compat.BuildCompat;
import com.terista.space.core.fake.service.ISettingsProviderProxy;
import com.terista.space.core.fake.service.FeatureFlagUtilsProxy;
import com.terista.space.core.fake.service.WorkManagerProxy;



public class HookManager {
    public static final String TAG = "HookManager";

    private static final HookManager sHookManager = new HookManager();

    private final Map<Class<?>, IInjectHook> mInjectors = new HashMap<>();

    public static HookManager get() {
        return sHookManager;
    }

    public void init() {
        if (BlackBoxCore.get().isBlackProcess() || BlackBoxCore.get().isServerProcess()) {
            addInjector(new IDisplayManagerProxy());
            addInjector(new OsStub());
            addInjector(new IActivityManagerProxy());
            addInjector(new IPackageManagerProxy());
            addInjector(new ITelephonyManagerProxy());
            addInjector(new HCallbackProxy());
            addInjector(new IAppOpsManagerProxy());
            addInjector(new INotificationManagerProxy());
            addInjector(new IAlarmManagerProxy());
            addInjector(new IAppWidgetManagerProxy());
            addInjector(new ContentServiceStub());
            addInjector(new IWindowManagerProxy());
            addInjector(new IUserManagerProxy());
            addInjector(new RestrictionsManagerStub());
            addInjector(new IMediaSessionManagerProxy());
            addInjector(new IAudioServiceProxy());
            addInjector(new ISensorPrivacyManagerProxy());
            addInjector(new ContentResolverProxy());
            addInjector(new IWebViewUpdateServiceProxy());
            addInjector(new SystemLibraryProxy());
            addInjector(new ReLinkerProxy());
            addInjector(new WebViewProxy());
            addInjector(new WebViewFactoryProxy());
            addInjector(new WorkManagerProxy());
            addInjector(new MediaRecorderProxy());
            addInjector(new AudioRecordProxy());
            addInjector(new IMiuiSecurityManagerProxy());
            addInjector(new ISettingsProviderProxy());
            addInjector(new FeatureFlagUtilsProxy());
            addInjector(new MediaRecorderClassProxy());
            addInjector(new SQLiteDatabaseProxy());
            addInjector(new ClassLoaderProxy());
            addInjector(new FileSystemProxy());
            addInjector(new GmsProxy());
            addInjector(new LevelDbProxy());
            addInjector(new DeviceIdProxy());
            addInjector(new GoogleAccountManagerProxy());
            addInjector(new AuthenticationProxy());
            addInjector(new AndroidIdProxy());
            addInjector(new AudioPermissionProxy());
            addInjector(new ILocationManagerProxy());
            addInjector(new IStorageManagerProxy());
            addInjector(new ILauncherAppsProxy());
            addInjector(new IJobServiceProxy());
            addInjector(new IAccessibilityManagerProxy());
            addInjector(new ITelephonyRegistryProxy());
            addInjector(new IDevicePolicyManagerProxy());
            addInjector(new IAccountManagerProxy());
            addInjector(new IConnectivityManagerProxy());
            addInjector(new IDnsResolverProxy());
                    addInjector(new IAttributionSourceProxy());
        addInjector(new IContentProviderProxy());
        addInjector(new ISettingsSystemProxy());
        addInjector(new ISystemSensorManagerProxy());
        
        
        addInjector(new IXiaomiAttributionSourceProxy());
        addInjector(new IXiaomiSettingsProxy());
        addInjector(new IXiaomiMiuiServicesProxy());
            addInjector(new IPhoneSubInfoProxy());
            addInjector(new IMediaRouterServiceProxy());
            addInjector(new IPowerManagerProxy());
            addInjector(new IContextHubServiceProxy());
            
            addInjector(new IVibratorServiceProxy());
            addInjector(new IPersistentDataBlockServiceProxy());
            addInjector(AppInstrumentation.get());
            
            addInjector(new IWifiManagerProxy());
            addInjector(new IWifiScannerProxy());
            addInjector(new ApkAssetsProxy());
            addInjector(new ResourcesManagerProxy());
            
            if (BuildCompat.isS()) {
                addInjector(new IActivityClientProxy(null));
                addInjector(new IVpnManagerProxy());
            }
            
            if (BuildCompat.isS()) {
                addInjector(new ISensitiveContentProtectionManagerProxy());
            }
            
            if (BuildCompat.isR()) {
                addInjector(new IPermissionManagerProxy());
            }
            
            if (BuildCompat.isQ()) {
                addInjector(new IActivityTaskManagerProxy());
            }
            
            if (BuildCompat.isPie()) {
                addInjector(new ISystemUpdateProxy());
            }
            
            if (BuildCompat.isOreo()) {
                addInjector(new IAutofillManagerProxy());
                addInjector(new IDeviceIdentifiersPolicyProxy());
                addInjector(new IStorageStatsManagerProxy());
            }
            
            if (BuildCompat.isN_MR1()) {
                addInjector(new IShortcutManagerProxy());
            }
            
            if (BuildCompat.isN()) {
                addInjector(new INetworkManagementServiceProxy());
            }
            
            if (BuildCompat.isM()) {
                addInjector(new IFingerprintManagerProxy());
                addInjector(new IGraphicsStatsProxy());
            }
            
            if (BuildCompat.isL()) {
                addInjector(new IJobServiceProxy());
            }
        }
        injectAll();
    }

    public void checkEnv(Class<?> clazz) {
        IInjectHook iInjectHook = mInjectors.get(clazz);
        if (iInjectHook != null && iInjectHook.isBadEnv()) {
            Log.d(TAG, "checkEnv: " + clazz.getSimpleName() + " is bad env");
            iInjectHook.injectHook();
        }
    }

    public void checkAll() {
        for (Class<?> aClass : mInjectors.keySet()) {
            IInjectHook iInjectHook = mInjectors.get(aClass);
            if (iInjectHook != null && iInjectHook.isBadEnv()) {
                Log.d(TAG, "checkEnv: " + aClass.getSimpleName() + " is bad env");
                iInjectHook.injectHook();
            }
        }
    }

    void addInjector(IInjectHook injectHook) {
        mInjectors.put(injectHook.getClass(), injectHook);
    }

    void injectAll() {
        for (IInjectHook value : mInjectors.values()) {
            try {
                Slog.d(TAG, "hook: " + value);
                value.injectHook();
            } catch (Exception e) {
                Slog.d(TAG, "hook error: " + value);
                
                handleHookError(value, e);
            }
        }
    }

    
    private void handleHookError(IInjectHook hook, Exception e) {
        String hookName = hook.getClass().getSimpleName();
        
        
        Slog.e(TAG, "Hook failed: " + hookName + " - " + e.getMessage(), e);
        
        
        if (hookName.contains("ActivityManager") || 
            hookName.contains("PackageManager") ||
            hookName.contains("WebView") ||
            hookName.contains("ContentProvider")) {
            
            Slog.w(TAG, "Critical hook failed: " + hookName + ", attempting recovery");
            
            try {
                
                if (hook.isBadEnv()) {
                    Slog.d(TAG, "Attempting to recover hook: " + hookName);
                    hook.injectHook();
                }
            } catch (Exception recoveryException) {
                Slog.e(TAG, "Hook recovery failed: " + hookName, recoveryException);
            }
        }
    }

    
    public boolean areCriticalHooksInstalled() {
        String[] criticalHooks = {
            "IActivityManagerProxy",
            "IPackageManagerProxy", 
            "WebViewProxy",
            "IContentProviderProxy"
        };
        
        for (String hookName : criticalHooks) {
            boolean found = false;
            for (Class<?> hookClass : mInjectors.keySet()) {
                if (hookClass.getSimpleName().equals(hookName)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Slog.w(TAG, "Critical hook missing: " + hookName);
                return false;
            }
        }
        
        Slog.d(TAG, "All critical hooks are installed");
        return true;
    }

    
    public void reinitializeHooks() {
        Slog.d(TAG, "Reinitializing all hooks");
        
        
        mInjectors.clear();
        
        
        init();
        
        Slog.d(TAG, "Hook reinitialization completed");
    }
}

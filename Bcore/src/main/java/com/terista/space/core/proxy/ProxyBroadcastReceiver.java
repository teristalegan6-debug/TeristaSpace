package com.terista.space.core.proxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;

import com.terista.space.core.BlackBoxCore;
import com.terista.space.core.entity.am.PendingResultData;
import com.terista.space.core.proxy.record.ProxyBroadcastRecord;


public class ProxyBroadcastReceiver extends BroadcastReceiver {
    public static final String TAG = "ProxyBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        intent.setExtrasClassLoader(context.getClassLoader());
        ProxyBroadcastRecord record = ProxyBroadcastRecord.create(intent);
        if (record.mIntent == null) {
            return;
        }
        PendingResult pendingResult = goAsync();
        try {
            BlackBoxCore.getBActivityManager().scheduleBroadcastReceiver(record.mIntent, new PendingResultData(pendingResult), record.mUserId);
        } catch (RemoteException e) {
            pendingResult.finish();
        }
    }
}
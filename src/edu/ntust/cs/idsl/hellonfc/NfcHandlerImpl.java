package edu.ntust.cs.idsl.hellonfc;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;

/**
 * 
 * @author Chun-Kai Wang <m10209122@mail.ntust.edu.tw>
 *
 */
public class NfcHandlerImpl implements NfcHandler {
    
    private Activity activity;
    private NfcAdapter nfcAdapter;
    private PendingIntent intent;
    private IntentFilter[] filters;
    
    public NfcHandlerImpl(Activity activity) {
        this.activity = activity;
        
        // 若裝置不支援 NFC 將回傳 null
        nfcAdapter = NfcAdapter.getDefaultAdapter(activity.getApplicationContext());
        
        // 註冊讓該 Activity 負責處理所有接收到的 NFC Intents
        intent = PendingIntent.getActivity(activity, 0,
                new Intent(activity, activity.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

        // 建立要處理的 Intent Filter 負責處理來自 Tag 或 p2p 交換的資料
        // 使用優先權最低的 ACTION_TAG_DISCOVERED 即可偵測是否發現 NFC Tag
        IntentFilter tagDetected = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
        filters = new IntentFilter[] { tagDetected };
    }
    
    @Override
    public boolean isSupported() {
        return nfcAdapter != null;
    }    
    
    @Override
    public boolean isEnable() {
        return nfcAdapter.isEnabled();
    }    
    
    @Override
    public void enableForegrount() {
        nfcAdapter.enableForegroundDispatch(activity, intent, filters, null);
    }
    
    @Override
    public void disableForeground() {
        nfcAdapter.disableForegroundDispatch(activity);
    }
        
}
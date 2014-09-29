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
        
        // �Y�˸m���䴩 NFC �N�^�� null
        nfcAdapter = NfcAdapter.getDefaultAdapter(activity.getApplicationContext());
        
        // ���U���� Activity �t�d�B�z�Ҧ������쪺 NFC Intents
        intent = PendingIntent.getActivity(activity, 0,
                new Intent(activity, activity.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);

        // �إ߭n�B�z�� Intent Filter �t�d�B�z�Ӧ� Tag �� p2p �洫�����
        // �ϥ��u���v�̧C�� ACTION_TAG_DISCOVERED �Y�i�����O�_�o�{ NFC Tag
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
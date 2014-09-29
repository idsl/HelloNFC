package edu.ntust.cs.idsl.hellonfc;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 
 * @author Chun-Kai Wang <m10209122@mail.ntust.edu.tw>
 *
 */
public class MainActivity extends Activity {

    private NfcHandler nfcHandler;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   
        nfcHandler = new NfcHandlerImpl(this);
        setTextView();  
    }

    @Override
    protected void onResume() {
        super.onResume();
        nfcHandler.enableForegrount();
    }

    @Override
    protected void onPause() {
        super.onPause();
        nfcHandler.disableForeground();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        
        // 偵測到 NFC Tag 時顯示 Hello NFC
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(intent.getAction())) {
            Toast.makeText(MainActivity.this, R.string.hello_nfc, Toast.LENGTH_SHORT).show();
        }
    }
    
    private void setTextView() {
        textView = (TextView) findViewById(R.id.textView);
        if (!nfcHandler.isSupported()) {
            textView.setText(R.string.nfc_unsupported);
            return;
        }
        if (!nfcHandler.isEnable()) {
            textView.setText(R.string.nfc_disabled);
            return;
        }
        textView.setText(R.string.nfc_ready);
    }

}
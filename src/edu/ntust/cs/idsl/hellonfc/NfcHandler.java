package edu.ntust.cs.idsl.hellonfc;

/**
 * 
 * @author Chun-Kai Wang <m10209122@mail.ntust.edu.tw>
 *
 */
public interface NfcHandler {

    /**
     * Android 裝置是否支援 NFC
     * 
     * @return boolean
     */
    public boolean isSupported();

    /**
     * Android 裝置是否啟動 NFC
     * 
     * @return boolean
     */
    public boolean isEnable();

    /**
     * 啟動 NfcAdapter 支持前景模式下處理 NFC Intent
     */
    public void enableForegrount();

    /**
     * 關閉 NfcAdapter 的前景模式
     */
    public void disableForeground();

}
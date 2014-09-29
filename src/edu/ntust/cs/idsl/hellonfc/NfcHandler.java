package edu.ntust.cs.idsl.hellonfc;

/**
 * 
 * @author Chun-Kai Wang <m10209122@mail.ntust.edu.tw>
 *
 */
public interface NfcHandler {

    /**
     * Android �˸m�O�_�䴩 NFC
     * 
     * @return boolean
     */
    public boolean isSupported();

    /**
     * Android �˸m�O�_�Ұ� NFC
     * 
     * @return boolean
     */
    public boolean isEnable();

    /**
     * �Ұ� NfcAdapter ����e���Ҧ��U�B�z NFC Intent
     */
    public void enableForegrount();

    /**
     * ���� NfcAdapter ���e���Ҧ�
     */
    public void disableForeground();

}
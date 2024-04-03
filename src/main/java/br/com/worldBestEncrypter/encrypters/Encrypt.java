package br.com.worldBestEncrypter.encrypters;

public interface Encrypt {
    public String encrypt(String textToEncrypt);

    public String decrypt(String textToDecrypt);
}

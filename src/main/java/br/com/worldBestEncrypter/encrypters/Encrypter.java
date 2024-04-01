package br.com.worldBestEncrypter.encrypters;

public interface Encrypter {
    public String encrypt(String textToEncrypt);

    public String decrypt(String textToDecrypt);
}

package br.com.worldBestEncrypter.encrypters;

import br.com.worldBestEncrypter.SystemErrors.InvalidCharacterException;

public interface Encrypt {
    public String encrypt(String textToEncrypt) throws InvalidCharacterException;

    public String decrypt(String textToDecrypt) throws InvalidCharacterException;
}

package br.com.worldBestEncrypter.encrypters;

import br.com.worldBestEncrypter.SystemErrors.InvalidCharacterException;

public class CaesarCipher implements Encrypt {

    private int key;
    public CaesarCipher(int key){
        this.setKey(key);
    }

    public void setKey(int key){
        key = key % 26;
        this.key = key;
    };

    public int getKey(){
        return this.key;
    }


    @Override
    public String encrypt(String textToEncrypt) throws InvalidCharacterException {
        StringBuilder result = new StringBuilder();

        // Loop sobre cada caractere da frase
        for (int i = 0; i < textToEncrypt.length(); i++) {
            char curChar = textToEncrypt.charAt(i);

            // Verificar se o caractere é uma letra do alfabeto
            if (Character.isLetter(curChar)) {
                // Converter o caractere para minúscula para facilitar o cálculo
                char base;
                char encryptedChar;

                if(curChar < 'Ç') {
                    base = Character.isLowerCase(curChar) ? 'a' : 'A';
                    encryptedChar = (char) (((curChar - base + this.key) % 26) + base);
                } else {
                    encryptedChar = curChar;
                }

                result.append(encryptedChar);
            }else if (curChar == ' '){
                result.append(curChar);
            } else {
                throw new InvalidCharacterException("O carácter [" + String.valueOf(curChar) + "] não é valido para criptografar em cifra de ceasar");
            }
        }

        return result.toString();
    }

    @Override
    public String decrypt(String textToDecrypt) throws InvalidCharacterException{
        StringBuilder result = new StringBuilder();

        // Loop sobre cada caractere da frase
        for (int i = 0; i < textToDecrypt.length(); i++) {
            char curChar = textToDecrypt.charAt(i);

            // Verificar se o caractere é uma letra do alfabeto
            if (Character.isLetter(curChar)) {
                // Converter o caractere para minúscula para facilitar o cálculo
                char base;
                char decryptedChar;

                if(curChar < 'Ç') {
                    base = Character.isLowerCase(curChar) ? 'a' : 'A';
                    decryptedChar = (char) (((curChar - base - this.key + 26) % 26) + base);
                } else {
                    decryptedChar = curChar;
                }

                result.append(decryptedChar);
            }else if (curChar == ' '){
                result.append(curChar);
            }
            else {
                throw new InvalidCharacterException("O carácter [" + String.valueOf(curChar) + "] não é valido para descriptografar em cifra de ceasar");
            }
        }

        return result.toString();
    }
}

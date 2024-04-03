package br.com.worldBestEncrypter.encrypters;

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
    public String encrypt(String textToEncrypt) {
        StringBuilder result = new StringBuilder();

        // Loop sobre cada caractere da frase
        for (int i = 0; i < textToEncrypt.length(); i++) {
            char curChar = textToEncrypt.charAt(i);

            // Verificar se o caractere é uma letra do alfabeto
            if (Character.isLetter(curChar)) {
                // Converter o caractere para minúscula para facilitar o cálculo
                char base = Character.isLowerCase(curChar) ? 'a' : 'A';
                // Aplicar o deslocamento de acordo com a chave
                curChar = (char) (((curChar - base + this.key) % 26) + base);
            }
            // Adicionar o caractere resultante ao resultado final
            result.append(curChar);
        }

        return result.toString();
    }

    @Override
    public String decrypt(String textToDecrypt) {
        StringBuilder result = new StringBuilder();

        // Loop sobre cada caractere da frase
        for (int i = 0; i < textToDecrypt.length(); i++) {
            char curChar = textToDecrypt.charAt(i);

            // Verificar se o caractere é uma letra do alfabeto
            if (Character.isLetter(curChar)) {
                // Converter o caractere para minúscula para facilitar o cálculo
                char base = Character.isLowerCase(curChar) ? 'a' : 'A';
                // Para descriptar, subtrair a chave e adicionar 26 para evitar valores negativos
                curChar = (char) (((curChar - base - this.key + 26) % 26) + base);
            }
            // Adicionar o caractere resultante ao resultado final
            result.append(curChar);
        }

        return result.toString();
    }
}

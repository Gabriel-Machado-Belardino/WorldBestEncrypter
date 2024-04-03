package br.com.worldBestEncrypter.encrypters;

public class CaesarCipher implements Encrypter {
    @Override
    public String encrypt(String textToEncrypt, int chave) {
        StringBuilder resultado = new StringBuilder();

        // Ajustar a chave para manter-se dentro do intervalo [0, 25]
        chave = chave % 26;

        // Loop sobre cada caractere da frase
        for (int i = 0; i < textToEncrypt.length(); i++) {
            char caractere = textToEncrypt.charAt(i);

            // Verificar se o caractere é uma letra do alfabeto
            if (Character.isLetter(caractere)) {
                // Converter o caractere para minúscula para facilitar o cálculo
                char base = Character.isLowerCase(caractere) ? 'a' : 'A';
                // Aplicar o deslocamento de acordo com a chave
                caractere = (char) (((caractere - base + chave) % 26) + base);
            }
            // Adicionar o caractere resultante ao resultado final
            resultado.append(caractere);
        }

        return resultado.toString();
    }

    @Override
    public String decrypt(String textToDecrypt, int chave) {
        StringBuilder resultado = new StringBuilder();

        // Ajustar a chave para manter-se dentro do intervalo [0, 25]
        chave = chave % 26;

        // Loop sobre cada caractere da frase
        for (int i = 0; i < textToDecrypt.length(); i++) {
            char caractere = textToDecrypt.charAt(i);

            // Verificar se o caractere é uma letra do alfabeto
            if (Character.isLetter(caractere)) {
                // Converter o caractere para minúscula para facilitar o cálculo
                char base = Character.isLowerCase(caractere) ? 'a' : 'A';
                // Para descriptar, subtrair a chave e adicionar 26 para evitar valores negativos
                caractere = (char) (((caractere - base - chave + 26) % 26) + base);
            }
            // Adicionar o caractere resultante ao resultado final
            resultado.append(caractere);
        }

        return resultado.toString();
    }
}

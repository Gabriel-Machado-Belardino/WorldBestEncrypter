package br.com.worldBestEncrypter.encrypters;

import java.util.HashMap;

public class Morse implements Encrypter {
    private static final HashMap<Character, String> charParaMorse = new HashMap<>();

    // Mapeamento de código Morse para caracteres
    private static final HashMap<String, Character> morseParaChar = new HashMap<>();

    // Bloco estático para inicializar os mapas de caracteres e código Morse
    static {
        // Mapeamento de caracteres para código Morse
        charParaMorse.put('A', ".-");
        charParaMorse.put('B', "-...");
        charParaMorse.put('C', "-.-.");
        charParaMorse.put('D', "-..");
        charParaMorse.put('E', ".");
        charParaMorse.put('F', "..-.");
        charParaMorse.put('G', "--.");
        charParaMorse.put('H', "....");
        charParaMorse.put('I', "..");
        charParaMorse.put('J', ".---");
        charParaMorse.put('K', "-.-");
        charParaMorse.put('L', ".-..");
        charParaMorse.put('M', "--");
        charParaMorse.put('N', "-.");
        charParaMorse.put('O', "---");
        charParaMorse.put('P', ".--.");
        charParaMorse.put('Q', "--.-");
        charParaMorse.put('R', ".-.");
        charParaMorse.put('S', "...");
        charParaMorse.put('T', "-");
        charParaMorse.put('U', "..-");
        charParaMorse.put('V', "...-");
        charParaMorse.put('W', ".--");
        charParaMorse.put('X', "-..-");
        charParaMorse.put('Y', "-.--");
        charParaMorse.put('Z', "--..");

        // Criando o mapeamento inverso de código Morse para caracteres
        for (char key : charParaMorse.keySet()) {
            morseParaChar.put(charParaMorse.get(key), key);
        }
    }

    @Override
    public String encrypt(String textToEncrypt) {
        StringBuilder resultado = new StringBuilder();
        // Divide o texto em palavras usando espaço como delimitador
        String[] palavras = textToEncrypt.split(" ");
        // Itera sobre cada palavra no texto
        for (String palavra : palavras) {
            // Verifica se a palavra existe no mapa morseParaChar
            if (morseParaChar.containsKey(palavra)) {
                // Se a palavra existir, obtém o caractere correspondente e adiciona ao resultado
                resultado.append(morseParaChar.get(palavra));
            } else {
                // Se a palavra não existir, adiciona um espaço ao resultado
                resultado.append(" ");
            }
        }
        // Retorna o texto encripitado
        return resultado.toString();
    }

    @Override
    public String decrypt(String textToDecrypt) {
        StringBuilder resultado = new StringBuilder();
        // Itera sobre cada caractere no texto a ser decifrado
        for (int i = 0; i < textToDecrypt.length(); i++) {
            // Converte o caractere para maiúsculo para garantir correspondência com o mapa charParaMorse
            char caractere = Character.toUpperCase(textToDecrypt.charAt(i));
            // Verifica se o caractere existe no mapa charParaMorse
            if (charParaMorse.containsKey(caractere)) {
                // Se o caractere existir, obtém a representação em código Morse correspondente e adiciona ao resultado
                resultado.append(charParaMorse.get(caractere)).append(" ");
            } else if (caractere == ' ') {
                // Se o caractere for um espaço, adiciona uma barra (indicando espaço em código Morse) ao resultado
                resultado.append("/ ");
            }
        }
        // Retorna o texto descriptado
        return resultado.toString();
    }

}
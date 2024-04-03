package br.com.worldBestEncrypter.encrypters;

import java.util.HashMap;

public class Morse implements Encrypt {
    private static final HashMap<Character, String> charToMorse = new HashMap<>();

    // Mapeamento de código Morse para caracteres
    private static final HashMap<String, Character> morseToChar = new HashMap<>();

    // Bloco estático para inicializar os mapas de caracteres e código Morse
    static {
        // Mapeamento de caracteres para código Morse
        charToMorse.put('A', ".-");
        charToMorse.put('B', "-...");
        charToMorse.put('C', "-.-.");
        charToMorse.put('D', "-..");
        charToMorse.put('E', ".");
        charToMorse.put('F', "..-.");
        charToMorse.put('G', "--.");
        charToMorse.put('H', "....");
        charToMorse.put('I', "..");
        charToMorse.put('J', ".---");
        charToMorse.put('K', "-.-");
        charToMorse.put('L', ".-..");
        charToMorse.put('M', "--");
        charToMorse.put('N', "-.");
        charToMorse.put('O', "---");
        charToMorse.put('P', ".--.");
        charToMorse.put('Q', "--.-");
        charToMorse.put('R', ".-.");
        charToMorse.put('S', "...");
        charToMorse.put('T', "-");
        charToMorse.put('U', "..-");
        charToMorse.put('V', "...-");
        charToMorse.put('W', ".--");
        charToMorse.put('X', "-..-");
        charToMorse.put('Y', "-.--");
        charToMorse.put('Z', "--..");
        charToMorse.put(' ', "/");
        charToMorse.put('1', ".----");
        charToMorse.put('2', "..---");
        charToMorse.put('3', "...--");
        charToMorse.put('4', "....-");
        charToMorse.put('5', ".....");
        charToMorse.put('6', "-....");
        charToMorse.put('7', "--...");
        charToMorse.put('8', "---..");
        charToMorse.put('9', "----.");
        charToMorse.put('0', "-----");

        // Criando o mapeamento inverso de código Morse para caracteres
        for (char key : charToMorse.keySet()) {
            morseToChar.put(charToMorse.get(key), key);
        }
    }

    @Override
    public String encrypt(String textToDecrypt) {
        StringBuilder result = new StringBuilder();
        // Itera sobre cada caractere no texto a ser decifrado
        for (int i = 0; i < textToDecrypt.length(); i++) {
            // Converte o caractere para maiúsculo para garantir correspondência com o mapa charToMorse
            char curChar = Character.toUpperCase(textToDecrypt.charAt(i));
            // Verifica se o caractere existe no mapa charToMorse
            if (charToMorse.containsKey(curChar)) {
                // Se o caractere existir, obtém a representação em código Morse correspondente e adiciona ao resultado
                result.append(charToMorse.get(curChar)).append(" ");
            } else {
                result.append("/ ");
            }
        }
        // Retorna o texto descriptado
        return result.toString();
    }

    @Override
    public String decrypt(String textToEncrypt) {
        StringBuilder result = new StringBuilder();
        // Divide o texto em palavras usando espaço como delimitador
        String[] words = textToEncrypt.split(" ");
        // Itera sobre cada palavra no texto
        for (String word : words) {
            // Verifica se a palavra existe no mapa morseToChar
            if (morseToChar.containsKey(word)) {
                // Se a palavra existir, obtém o caractere correspondente e adiciona ao resultado
                result.append(morseToChar.get(word));
            } else {
                // Se a palavra não existir, adiciona um espaço ao resultado
                result.append(" ");
            }
        }
        // Retorna o texto encripitado
        return result.toString();
    }

}